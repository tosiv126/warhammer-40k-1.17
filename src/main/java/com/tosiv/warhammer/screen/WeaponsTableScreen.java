package com.tosiv.warhammer.screen;/*
package wraith.customizable_guns.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtInt;
import net.minecraft.nbt.NbtList;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import wraith.customizable_guns.Utils;
import wraith.customizable_guns.item.AttachmentItem;
import wraith.customizable_guns.item.GunItem;

import java.util.HashSet;

public class WeaponsTableScreen extends HandledScreen<WeaponsTableScreenHandler> {

    private static final Identifier TEXTURE = Utils.ID("textures/gui/weapons_table.png");
    private HashSet<Button> buttons = new HashSet<>();
    private boolean mousePressed;

    public WeaponsTableScreen(WeaponsTableScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.backgroundWidth = 176;
        this.backgroundHeight = 200;

        buttons.add(new Button(49, 79, 18, 18, 176, 0) {
            @Override
            public void setup() {
                this.tooltip = new TranslatableText("customizable_guns.weapons_table.tooltip.combine");
            }

            @Override
            public void onClick() {
                ItemStack stack = handler.getSlot(4).getStack();
                if (!(stack.getItem() instanceof GunItem)) {
                    return;
                }
                PacketByteBuf packet = PacketByteBufs.create();
                NbtCompound tag = new NbtCompound();
                tag.put("stored_gun", stack.writeNbt(new NbtCompound()));
                tag.put("remove_index", new NbtList());
                for (int i = 0; i < handler.getInventory().size() - 1; ++i) {
                    ItemStack tmpStack = handler.getSlot(i).getStack();
                    if (tmpStack.isEmpty() || !(tmpStack.getItem() instanceof AttachmentItem)) {
                        continue;
                    }
                    tag.getList("remove_index", NbtElement.INT_TYPE).add(NbtInt.of(i));

                    ((AttachmentItem)tmpStack.getItem()).addAttachment(stack, tmpStack);

                    handler.setStackInSlot(i, ItemStack.EMPTY);
                }
                packet.writeNbt(tag);
                ClientPlayNetworking.send(Utils.ID("weapons_table_combine"), packet);
            }
        });

        buttons.add(new Button(109, 79, 18, 18, 194, 0) {
            @Override
            public void setup() {
                this.tooltip = new TranslatableText("customizable_guns.weapons_table.tooltip.break_apart");
            }

            @Override
            public void onClick() {
                super.onClick();
            }
        });
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        this.drawMouseoverTooltip(matrices, mouseX, mouseY);
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        this.renderBackground(matrices);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        this.drawTexture(matrices, x, y, 0, 0, this.backgroundWidth, this.backgroundHeight);
        this.renderButtons(matrices, mouseX, mouseY);
        this.renderButtonTooltips(matrices, mouseX, mouseY);
    }

    private void renderButtons(MatrixStack matrices, int mouseX, int mouseY) {
        for (Button button : buttons) {
            if (!button.isVisible() || !button.hasToolTip() || !button.isInBounds(mouseX - this.x, mouseY - this.y)) {
                continue;
            }
            this.renderTooltip(matrices, button.tooltip(), mouseX, mouseY);
        }
    }

    private void renderButtonTooltips(MatrixStack matrices, int mouseX, int mouseY) {
        for (Button button : buttons) {
            if (!button.isVisible()) {
                continue;
            }
            int u = button.getU();
            int v = button.getV();
            if (button.isInBounds(mouseX - this.x, mouseY - this.y)) {
                v += button.getHeight() * (this.mousePressed ? 1 : 2);
            }
            this.drawTexture(matrices, this.x + button.getX(), this.y + button.getY(), u, v, button.getWidth(), button.getHeight());
        }
    }


    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        this.mousePressed = false;
        return super.mouseReleased(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        this.mousePressed = true;
        if (button != 0) {
            return super.mouseClicked(mouseX, mouseY, button);
        }
        for (Button guiButton : buttons) {
            if (!guiButton.isVisible() || !guiButton.isInBounds((int)mouseX - this.x, (int)mouseY - this.y)) {
                continue;
            }
            MinecraftClient.getInstance().getSoundManager().play(PositionedSoundInstance.master(SoundEvents.UI_BUTTON_CLICK, 1.0F));
            guiButton.onClick();
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

}
*/