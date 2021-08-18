package com.tosiv.warhammer.screen;

import com.tosiv.warhammer.Warhammer;
import com.tosiv.warhammer.crafting.FabricationBenchRecipe;
import com.tosiv.warhammer.util.registry.ModBlocks;
import com.tosiv.warhammer.util.registry.ModRecipes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeUnlocker;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Predicate;

public class FabricationBenchScreenHandler extends ScreenHandler {

    public static final Text TITLE = new TranslatableText("container.warhammer.fabrication");
    public static final int OUTPUT_SLOT = 0;
    private final ScreenHandlerContext context;
    private final PlayerEntity player;
    private final PlayerInventory playerInv;
    private final List<FabricationBenchRecipe> allRecipes;
    private FabricationBenchRecipe lastRecipe = null;
    private final OutputSlot outputSlot;

    public FabricationBenchScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, ScreenHandlerContext.EMPTY);
    }

    public FabricationBenchScreenHandler(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(Warhammer.IMPERIAL_FABRICATION_BENCH, syncId);
        this.context = context;
        this.playerInv = playerInventory;
        this.player = playerInventory.player;
        this.allRecipes = player.world.getRecipeManager().listAllOfType(ModRecipes.FABRICATION_BENCH);
        this.addSlot(outputSlot = new OutputSlot(playerInventory.player, new CraftingResultInventory() {
            @Override
            public void markDirty() {
                super.markDirty();
                FabricationBenchScreenHandler.this.onContentChanged(this);
            }
        }, OUTPUT_SLOT, 184, 37));

        // player inventory slots
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                this.addSlot(new Slot(playerInventory, col + row * 9 + 9, 108 + col * 18, 84 + row * 18));
            }
        }

        // hotbar
        for (int col = 0; col < 9; col++) {
            this.addSlot(new Slot(playerInventory, col, 108 + col * 18, 142));
        }
    }

    public List<FabricationBenchRecipe> getAllRecipes() {
        return allRecipes;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return canUse(this.context, player, ModBlocks.IMPERIAL_FABRICATION_BENCH);
    }

    @Override
    public void setStackInSlot(int slot, ItemStack stack) {
        super.setStackInSlot(slot, stack);
        if(this.player.world.isClient()) {
            this.listeners.forEach(it -> it.onSlotUpdate(this, slot, stack));
        }
    }

    /**
     * called serverside when the client changes the selected recipe
     */
    public void select(@Nullable FabricationBenchRecipe recipe) {
        if(recipe != null) {
            World world = player.getEntityWorld();
            if (isRecipeAllowed(world, recipe, r -> ((ServerPlayerEntity) player).getRecipeBook().contains(r)) && recipe.matches(playerInv, world)) {
                this.lastRecipe = recipe;
            }
            else {
                recipe = null;
            }
        }
        this.outputSlot.setRecipe(recipe);
    }

    public boolean isRecipeAllowed(World world, FabricationBenchRecipe recipe, Predicate<FabricationBenchRecipe> predicate) {
        return allRecipes.contains(recipe) && (recipe.isIgnoredInRecipeBook() || !world.getGameRules().getBoolean(GameRules.DO_LIMITED_CRAFTING) || predicate.test(recipe));
    }

    public static class OutputSlot extends Slot {

        private final PlayerEntity player;
        private FabricationBenchRecipe recipe;
        private int amount;

        public OutputSlot(PlayerEntity player, CraftingResultInventory craftingInventory, int index, int x, int y) {
            super(craftingInventory, index, x, y);
            this.player = player;
        }

        public void setRecipe(@Nullable FabricationBenchRecipe recipe) {
            if(recipe != this.recipe) {
                this.recipe = recipe;
                this.setStack(recipe != null ? recipe.getOutput().copy() : ItemStack.EMPTY);
            }
        }

        @Override
        public ItemStack takeStack(int amount) {
            if (this.hasStack() && this.recipe != null) {
                this.amount += Math.min(amount, this.getStack().getCount());
                ItemStack ret = this.recipe.craft(player.getInventory());
                if(!this.recipe.matches(player.getInventory(), player.getEntityWorld())) {
                    this.setStack(ItemStack.EMPTY);
                }
                return ret;
            }
            return ItemStack.EMPTY;
        }

        @Override
        protected void onCrafted(ItemStack stack, int amount) {
            this.amount += amount;
            this.onCrafted(stack);
        }

        @Override
        protected void onTake(int amount) {
            this.amount += amount;
        }

        @Override
        public boolean canInsert(ItemStack stack) {
            return false;
        }

        @Override
        protected void onCrafted(ItemStack stack) {
            if (this.amount > 0) {
                stack.onCraft(this.player.world, this.player, this.amount);
            }
            if (this.inventory instanceof RecipeUnlocker) {
                ((RecipeUnlocker) this.inventory).unlockLastRecipe(this.player);
            }
            this.amount = 0;
        }

        @Override
        public void onTakeItem(PlayerEntity player, ItemStack stack) {
            this.onCrafted(stack);
            if (!player.world.isClient() && this.recipe != null && !this.recipe.matches(player.getInventory(), player.getEntityWorld())) {
                this.setStack(ItemStack.EMPTY);
            }
        }
    }
}
