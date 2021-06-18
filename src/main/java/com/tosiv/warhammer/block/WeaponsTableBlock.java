
package com.tosiv.warhammer.block;
/*
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class WeaponsTableBlock extends BlockWithEntity {

    public WeaponsTableBlock(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new WeaponsTableBlockEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        BlockEntity entity = world.getBlockEntity(pos);
        if (!world.isClient) {
            if (!(entity instanceof WeaponsTableBlockEntity)) {
                return ActionResult.FAIL;
            }
            NamedScreenHandlerFactory screenHandlerFactory = this.createScreenHandlerFactory(state, world, pos);
            if (screenHandlerFactory != null) {
                player.openHandledScreen((NamedScreenHandlerFactory) (world.getBlockEntity(pos)));
            } else {
                return ActionResult.FAIL;
            }
            entity.markDirty();
        }
        return ActionResult.SUCCESS;
    }


}
 */