package com.tosiv.warhammer;

import com.tosiv.warhammer.item.ReloadableItem;
import com.tosiv.warhammer.network.SetFabricationBenchRecipeC2SPacket;
import com.tosiv.warhammer.screen.FabricationBenchScreenHandler;
import com.tosiv.warhammer.util.Utils;
import com.tosiv.warhammer.util.registry.*;
import com.tosiv.warhammer.util.registry.item.CartridgeRegistry;
import com.tosiv.warhammer.util.registry.item.GunRegistry;
import com.tosiv.warhammer.util.registry.item.MagazineRegistry;
import com.tosiv.warhammer.world.OreGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class Warhammer implements ModInitializer {

    public static final String MOD_ID = "warhammer";

    public static final ItemGroup GENERAL_GROUP = FabricItemGroupBuilder.create(
            new Identifier("warhammer", "general"))
            .icon(() -> new ItemStack(ModItems.NUTRIENT_PASTE)).build();
    public static final ItemGroup WIP_GROUP = FabricItemGroupBuilder.create(
            new Identifier("warhammer", "wip"))
            .icon(() -> new ItemStack(ModItems.LHO_STICK)).build();
    public static Identifier MOD_ID(String path) {
        return new Identifier(Warhammer.MOD_ID, path);
    }

    public static ScreenHandlerType<FabricationBenchScreenHandler> IMPERIAL_FABRICATION_BENCH = ScreenHandlerRegistry.registerSimple(new Identifier(MOD_ID, "imperial_fabrication_bench"), FabricationBenchScreenHandler::new);

    @Override
    public void onInitialize() {
        ModBlocks.registerBlocks();
        ModItems.registerItems();
        ModSounds.registerSounds();
        OreGeneration.register();
        registerPacketHandlers();
        GunRegistry.register();
        MagazineRegistry.register();
        CartridgeRegistry.register();
        //AttachmentRegistry.register();
        //GunScreenHandlerRegistry.register();
        //BlockRegistry.register();
        EntityRegistry.register();
        SpawnRegistry.register();
        ModRecipes.register();
        ServerPlayNetworking.registerGlobalReceiver(SetFabricationBenchRecipeC2SPacket.ID, SetFabricationBenchRecipeC2SPacket::onPacket);
    }

    private void registerPacketHandlers() {
        ServerPlayNetworking.registerGlobalReceiver(Utils.ID("reload_item"), (server, player, handler, packet, sender) -> {
            ItemStack stack = player.getMainHandStack();
            if (stack.getItem() instanceof ReloadableItem) {
                ((ReloadableItem) stack.getItem()).reload(player, stack);
            }
        });
    }
}
