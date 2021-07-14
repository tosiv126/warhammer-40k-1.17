package com.tosiv.warhammer.client;

import com.tosiv.warhammer.util.Utils;
import com.tosiv.warhammer.util.registry.ClientEntityRendererRegistry;
import com.tosiv.warhammer.util.registry.CustomEntityModelLayers;
import com.tosiv.warhammer.util.registry.GunKeyBindingRegistry;
import com.tosiv.warhammer.util.renders.BlockRenders;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;

public class WarhammerClient implements ClientModInitializer {

    private boolean cooldown = false;

    @Override
    public void onInitializeClient(){

        BlockRenders.defineRenders();
        registerEventHandlers();
        GunKeyBindingRegistry.register();
        ClientEntityRendererRegistry.register();
        //GunScreenRegistry.register();
        CustomEntityModelLayers.register();

    }

    private void registerEventHandlers() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (GunKeyBindingRegistry.RELOAD_KEY.isPressed() && !cooldown) {
                ClientPlayNetworking.send(Utils.ID("reload_item"), PacketByteBufs.create());
            }
            cooldown = GunKeyBindingRegistry.RELOAD_KEY.isPressed();
        });
    }
}