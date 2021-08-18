package com.tosiv.warhammer.network;

import com.tosiv.warhammer.Warhammer;
import com.tosiv.warhammer.crafting.FabricationBenchRecipe;
import com.tosiv.warhammer.screen.FabricationBenchScreenHandler;
import io.netty.buffer.Unpooled;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public class SetFabricationBenchRecipeC2SPacket {

    public static Identifier ID = Warhammer.MOD_ID("fabrication_bench_select_recipe");

    @Environment(EnvType.CLIENT)
    public static void send(FabricationBenchRecipe recipe, int syncID) {
        PacketByteBuf buffer = new PacketByteBuf(Unpooled.buffer());
        buffer.writeVarInt(syncID);
        buffer.writeIdentifier(recipe.getId());
        ClientPlayNetworking.send(ID, buffer);
    }

    public static void onPacket(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler networkHandler, PacketByteBuf byteBuf, PacketSender packetSender) {
        int syncID = byteBuf.readVarInt();
        Identifier recipeID = byteBuf.readIdentifier();
        server.execute(() -> {
            if(player.currentScreenHandler instanceof FabricationBenchScreenHandler container && player.currentScreenHandler.syncId == syncID) {
                server.getRecipeManager().get(recipeID).filter(FabricationBenchRecipe.class::isInstance).map(FabricationBenchRecipe.class::cast).ifPresent(container::select);
            }
        });
    }
}
