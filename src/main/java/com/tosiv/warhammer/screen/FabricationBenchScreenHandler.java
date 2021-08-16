package com.tosiv.warhammer.screen;

import com.tosiv.warhammer.Warhammer;
import com.tosiv.warhammer.util.registry.ModBlocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.s2c.play.ScreenHandlerSlotUpdateS2CPacket;
import net.minecraft.recipe.CraftingRecipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

import java.util.Optional;

public class FabricationBenchScreenHandler extends ScreenHandler {

    public static final Text TITLE = new TranslatableText("container.warhammer.fabrication");
    private final ScreenHandlerContext context;
    private final CraftingResultInventory result;
    private final PlayerEntity player;

    public FabricationBenchScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, ScreenHandlerContext.EMPTY);
    }

    public FabricationBenchScreenHandler(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(Warhammer.IMPERIAL_FABRICATION_BENCH, syncId);
        this.context = context;
        this.result = new CraftingResultInventory();
        this.player = playerInventory.player;
        this.addSlot(new OutputSlot(playerInventory.player, this.result, 0, 184, 37));

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

    @Override
    public boolean canUse(PlayerEntity player) {
        return canUse(this.context, player, ModBlocks.IMPERIAL_FABRICATION_BENCH);
    }

    // TODO adjust based on villager screen
    protected static void updateResult(ScreenHandler screenHandler, World world, PlayerEntity player, CraftingInventory craftingInventory, CraftingResultInventory resultInventory) {
        if (!world.isClient) {
            ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity) player;
            ItemStack itemStack = ItemStack.EMPTY;
            Optional<CraftingRecipe> optional = world.getServer().getRecipeManager().getFirstMatch(RecipeType.CRAFTING, craftingInventory, world);
            if (optional.isPresent()) {
                CraftingRecipe craftingRecipe = optional.get();
                if (resultInventory.shouldCraftRecipe(world, serverPlayerEntity, craftingRecipe)) {
                    itemStack = craftingRecipe.craft(craftingInventory);
                }
            }

            resultInventory.setStack(0, itemStack);
            screenHandler.setPreviousTrackedSlot(0, itemStack);
            serverPlayerEntity.networkHandler.sendPacket(new ScreenHandlerSlotUpdateS2CPacket(screenHandler.syncId, 0, itemStack));
        }
    }

    public static class OutputSlot extends Slot {

        public OutputSlot(PlayerEntity inventory, CraftingResultInventory craftingInventory, int index, int x, int y) {
            super(craftingInventory, index, x, y);
        }
    }
}
