package com.tosiv.warhammer.client;

import com.tosiv.warhammer.Warhammer;
import com.tosiv.warhammer.client.renderer.GunDroneRenderer;
import com.tosiv.warhammer.client.renderer.IgChainswordVillagerRenderer;
import com.tosiv.warhammer.client.renderer.ScarabRenderer;
import com.tosiv.warhammer.client.renderer.TauWarriorRenderer;
import com.tosiv.warhammer.screen.FabricationBenchScreen;
import com.tosiv.warhammer.util.Utils;
import com.tosiv.warhammer.util.registry.*;
import com.tosiv.warhammer.util.renders.BlockRenders;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;

public class WarhammerClient implements ClientModInitializer {

    private boolean cooldown = false;

    @Override
    public void onInitializeClient(){

        EntityRendererRegistry.INSTANCE.register(EntityRegistry.SCARAB, ScarabRenderer::new);
        EntityRendererRegistry.INSTANCE.register(EntityRegistry.GUN_DRONE, GunDroneRenderer::new);
        EntityRendererRegistry.INSTANCE.register(EntityRegistry.TAU_WARRIOR, TauWarriorRenderer::new);
        EntityRendererRegistry.INSTANCE.register(EntityRegistry.IG_CHAINSWORD_VILLAGER, IgChainswordVillagerRenderer::new);

        BlockRenders.defineRenders();
        registerEventHandlers();
        GunKeyBindingRegistry.register();
        ClientEntityRendererRegistry.register();
        //GunScreenRegistry.register();
        CustomEntityModelLayers.register();
        ScreenRegistry.register(Warhammer.IMPERIAL_FABRICATION_BENCH, FabricationBenchScreen::new);

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
