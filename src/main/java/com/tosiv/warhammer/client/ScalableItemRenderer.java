package com.tosiv.warhammer.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.math.Vec3f;
import org.jetbrains.annotations.Nullable;

@Environment(EnvType.CLIENT)
public interface ScalableItemRenderer {

    void setScale(@Nullable Vec3f scale);

    @Nullable Vec3f getScale();

    void clearScale();
}
