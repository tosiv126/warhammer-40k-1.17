package com.tosiv.warhammer.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.tosiv.warhammer.Warhammer;
import com.tosiv.warhammer.crafting.FabricationBenchRecipe;
import com.tosiv.warhammer.network.SetFabricationBenchRecipeC2SPacket;
import it.unimi.dsi.fastutil.objects.Object2BooleanArrayMap;
import it.unimi.dsi.fastutil.objects.Object2BooleanMap;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.recipebook.ClientRecipeBook;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerListener;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class FabricationBenchScreen extends HandledScreen<FabricationBenchScreenHandler> {

    private static final Identifier TEXTURE = new Identifier(Warhammer.MOD_ID, "textures/gui/container/imperial_fabrication_bench.png");
    private static final Text RECIPES_TITLE = new TranslatableText("container.warhammer.fabrication.recipes");
    private static final Text MISSING_INGREDIENTS_TEXT = new TranslatableText("container.warhammer.fabrication.missing_ingredients");
    private static final int TITLE_COLOR = 0x404040;
    private final PlayerInventory inventory;
    private final Object2BooleanMap<FabricationBenchRecipe> enabledRecipes = new Object2BooleanArrayMap<>();
    private final FabricationRecipeWidget[] currentPage = new FabricationRecipeWidget[7];
    int indexStartOffset;
    private int selectedIndex = 0;
    private List<FabricationBenchRecipe> recipes;
    private boolean scrolling;

    public FabricationBenchScreen(FabricationBenchScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.backgroundWidth = 276;
        this.playerInventoryTitleX = 107;
        this.inventory = inventory;
        handler.addListener(new ScreenHandlerListener() {
            @Override
            public void onSlotUpdate(ScreenHandler handler, int slotId, ItemStack stack) {
                FabricationBenchScreen.this.refreshRecipeList();
            }

            @Override
            public void onPropertyUpdate(ScreenHandler handler, int property, int value) {
                // NO-OP
            }
        });
    }

    @Override
    protected void init() {
        super.init();
        this.refreshRecipeList();
        int i = (this.width - this.backgroundWidth) / 2;
        int j = (this.height - this.backgroundHeight) / 2;
        int k = j + 16 + 2;
        for (int l = 0; l < 7; ++l) {
            this.currentPage[l] = this.addDrawableChild(new FabricationRecipeWidget(i + 5, k, l, (button) -> {
                if (button instanceof FabricationRecipeWidget) {
                    this.selectedIndex = ((FabricationRecipeWidget) button).getIndex() + this.indexStartOffset;
                    if (selectedIndex >= 0 && selectedIndex < recipes.size()) {
                        selectRecipe(recipes.get(selectedIndex));
                    }
                }

            }));
            k += 20;
        }
    }

    public void refreshRecipeList() {
        World world = inventory.player.world;
        // config
        boolean onlyCraftableRecipes = false;
        boolean onlyUnlockedRecipes = world.getGameRules().getBoolean(GameRules.DO_LIMITED_CRAFTING);

        Stream<FabricationBenchRecipe> recipes = handler.getAllRecipes().stream();
        if (onlyUnlockedRecipes) {
            ClientRecipeBook recipeBook = ((ClientPlayerEntity) this.inventory.player).getRecipeBook();
            recipes = recipes.filter(recipeBook::contains);
        }
        if (onlyCraftableRecipes) {
            recipes = recipes.filter(it -> it.matches(this.inventory, world));
        }
        this.recipes = recipes.toList();
        this.enabledRecipes.clear();
        this.recipes.forEach(it -> this.enabledRecipes.put(it, it.matches(this.inventory, world)));
    }

    private void selectRecipe(FabricationBenchRecipe recipe) {
        SetFabricationBenchRecipeC2SPacket.send(recipe, this.handler.syncId);
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        if (!recipes.isEmpty()) {
            int drawX = (this.width - this.backgroundWidth) / 2;
            int drawY = (this.height - this.backgroundHeight) / 2;
            int k = drawY + 16 + 1;
            int l = drawX + 5 + 5;
            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.setShaderTexture(0, TEXTURE);
            this.renderScrollbar(matrices, drawX, drawY);
            int m = 0;
            Iterator<FabricationBenchRecipe> i = recipes.iterator();

            FabricationBenchRecipe currentRecipe;
            boolean enabled;
            while (i.hasNext()) {
                currentRecipe = i.next();
                if (this.canScroll(recipes.size()) && (m < this.indexStartOffset || m >= 7 + this.indexStartOffset)) {
                    ++m;
                } else {
                    enabled = enabledRecipes.getOrDefault(currentRecipe, false);
                    //DefaultedList<Ingredient> inputs = currentRecipe.getIngredients();
                    //ItemStack itemStack = currentRecipe.getOriginalFirstBuyItem();
                    //ItemStack itemStack2 = currentRecipe.getAdjustedFirstBuyItem();
                    //ItemStack itemStack3 = currentRecipe.getSecondBuyItem();
                    ItemStack result = currentRecipe.getOutput();
                    this.itemRenderer.zOffset = 100.0F;
                    int n = k + 2;
                    //this.renderFirstBuyItem(matrices, itemStack2, itemStack, l, n);
                    //if (!second.isEmpty()) {
                    //	this.itemRenderer.renderInGui(itemStack3, drawX + 5 + 35, n);
                    //	this.itemRenderer.renderGuiItemOverlay(this.textRenderer, itemStack3, drawX + 5 + 35, n);
                    //}

                    this.renderArrow(matrices, enabled, drawX, n);
                    this.itemRenderer.renderInGui(result, drawX + 5 + 68, n);
                    this.itemRenderer.renderGuiItemOverlay(this.textRenderer, result, drawX + 5 + 68, n);
                    this.itemRenderer.zOffset = 0.0F;
                    k += 20;
                    ++m;
                }
            }

            for (FabricationRecipeWidget widget : currentPage) {
                if (widget.isHovered()) {
                    widget.renderToolTip(matrices, mouseX, mouseY);
                }

                widget.visible = widget.index < this.recipes.size();
            }
            RenderSystem.enableDepthTest();
        }
        drawMouseoverTooltip(matrices, mouseX, mouseY);
    }

    @Override
    protected void drawForeground(MatrixStack matrices, int mouseX, int mouseY) {
        this.textRenderer.draw(matrices, this.title, (float) (49 + (this.backgroundWidth - this.textRenderer.getWidth(this.title)) / 2), 6.0F, TITLE_COLOR);
        this.textRenderer.draw(matrices, this.playerInventoryTitle, (float) this.playerInventoryTitleX, (float) this.playerInventoryTitleY, TITLE_COLOR);
        this.textRenderer.draw(matrices, RECIPES_TITLE, (float) (5 - this.textRenderer.getWidth(RECIPES_TITLE) / 2 + 48), 6.0F, TITLE_COLOR);
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);

        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        drawTexture(matrices, x, y, this.getZOffset(), 0.0F, 0.0F, this.backgroundWidth, this.backgroundHeight, 256, 512);
        if (!recipes.isEmpty()) {
            int k = this.selectedIndex;
            if (k < 0 || k >= recipes.size()) {
                return;
            }

            FabricationBenchRecipe recipe = recipes.get(k);
            if (!enabledRecipes.getOrDefault(recipe, false)) {
                RenderSystem.setShaderTexture(0, TEXTURE);
                RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
                drawTexture(matrices, this.x + 83 + 99, this.y + 35, this.getZOffset(), 311.0F, 0.0F, 28, 21, 256, 512);
            }
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        this.scrolling = false;
        int i = (this.width - this.backgroundWidth) / 2;
        int j = (this.height - this.backgroundHeight) / 2;
        if (this.canScroll(this.recipes.size()) && mouseX > i + 94 && mouseX < i + 94 + 6 && mouseY > j + 18 && mouseY <= j + 18 + 139 + 1) {
            this.scrolling = true;
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
        int i = this.recipes.size();
        if (this.scrolling) {
            int j = this.y + 18;
            int k = j + 139;
            int l = i - 7;
            float f = ((float) mouseY - (float) j - 13.5F) / ((float) (k - j) - 27.0F);
            f = f * (float) l + 0.5F;
            this.indexStartOffset = MathHelper.clamp((int) f, 0, l);
            return true;
        } else {
            return super.mouseDragged(mouseX, mouseY, button, deltaX, deltaY);
        }
    }

    @Override
    protected void onMouseClick(Slot slot, int slotId, int button, SlotActionType actionType) {
        super.onMouseClick(slot, slotId, button, actionType);
    }

    private void renderScrollbar(MatrixStack matrices, int x, int y) {
        int i = recipes.size() + 1 - 7;
        if (i > 1) {
            int j = 139 - (27 + (i - 1) * 139 / i);
            int k = 1 + j / i + 139 / i;
            int m = Math.min(113, this.indexStartOffset * k);
            if (this.indexStartOffset == i - 1) {
                m = 113;
            }

            drawTexture(matrices, x + 94, y + 18 + m, this.getZOffset(), 0.0F, 199.0F, 6, 27, 256, 512);
        } else {
            drawTexture(matrices, x + 94, y + 18, this.getZOffset(), 6.0F, 199.0F, 6, 27, 256, 512);
        }

    }

    private boolean canScroll(int listSize) {
        return listSize > 7;
    }

    private void renderArrow(MatrixStack matrices, boolean enabled, int x, int y) {
        RenderSystem.enableBlend();
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderTexture(0, TEXTURE);
        drawTexture(matrices, x + 5 + 35 + 20, y + 3, this.getZOffset(), enabled ? 15.0F : 25.0F, 171.0F, 10, 9, 256, 512);
    }

    private void renderFirstBuyItem(MatrixStack matrices, ItemStack adjustedFirstBuyItem, ItemStack originalFirstBuyItem, int x, int y) {
        this.itemRenderer.renderInGui(adjustedFirstBuyItem, x, y);
        if (originalFirstBuyItem.getCount() == adjustedFirstBuyItem.getCount()) {
            this.itemRenderer.renderGuiItemOverlay(this.textRenderer, adjustedFirstBuyItem, x, y);
        } else {
            this.itemRenderer.renderGuiItemOverlay(this.textRenderer, originalFirstBuyItem, x, y, originalFirstBuyItem.getCount() == 1 ? "1" : null);
            this.itemRenderer.renderGuiItemOverlay(this.textRenderer, adjustedFirstBuyItem, x + 14, y, adjustedFirstBuyItem.getCount() == 1 ? "1" : null);
            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.setShaderTexture(0, TEXTURE);
            this.setZOffset(this.getZOffset() + 300);
            drawTexture(matrices, x + 7, y + 12, this.getZOffset(), 0.0F, 176.0F, 9, 2, 256, 512);
            this.setZOffset(this.getZOffset() - 300);
        }

    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double amount) {
        int size = this.recipes.size();
        if (this.canScroll(size)) {
            int offScreenRecipes = size - 7;
            this.indexStartOffset = (int) ((double) this.indexStartOffset - amount);
            this.indexStartOffset = MathHelper.clamp(this.indexStartOffset, 0, offScreenRecipes);
        }

        return true;
    }

    private class FabricationRecipeWidget extends ButtonWidget {

        private final int index;

        public FabricationRecipeWidget(int x, int y, int index, PressAction onPress) {
            super(x, y, 89, 20, LiteralText.EMPTY, onPress);
            this.index = index;
            this.visible = false;
        }

        public int getIndex() {
            return index;
        }

        public void renderToolTip(MatrixStack matrices, int mouseX, int mouseY) {
            int idx = this.index + FabricationBenchScreen.this.indexStartOffset;
            if (this.hovered && FabricationBenchScreen.this.recipes.size() > idx) {
                FabricationBenchRecipe recipe = FabricationBenchScreen.this.recipes.get(idx);

                if (mouseX < this.x + 53) {
                    // TODO inputs
                } else if(mouseX > this.x + 53 && mouseX < this.x + 65) {
                    if (!FabricationBenchScreen.this.enabledRecipes.getBoolean(recipe)) { // 49-65
                        FabricationBenchScreen.this.renderTooltip(matrices, MISSING_INGREDIENTS_TEXT, mouseX, mouseY);
                    }
                } else {
                        FabricationBenchScreen.this.renderTooltip(matrices, recipe.getOutput(), mouseX, mouseY);
                }
            }

        }
    }
}
