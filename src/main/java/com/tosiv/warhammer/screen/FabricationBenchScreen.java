package com.tosiv.warhammer.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.tosiv.warhammer.Warhammer;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;

public class FabricationBenchScreen extends HandledScreen<FabricationBenchScreenHandler> {

    private static final Identifier TEXTURE = new Identifier(Warhammer.MOD_ID, "textures/gui/container/imperial_fabrication_bench.png");
    private static final Text RECIPES_TITLE = new TranslatableText("container.warhammer.fabrication.recipes");
    private static final int TITLE_COLOR = 0x404040;

    public FabricationBenchScreen(FabricationBenchScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.backgroundWidth = 276;
        this.playerInventoryTitleX = 107;
    }

    @Override
    protected void init() {
        super.init();
        //titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2;
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

    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        drawMouseoverTooltip(matrices, mouseX, mouseY);
    }
}
