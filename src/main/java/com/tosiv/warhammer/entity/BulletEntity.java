package com.tosiv.warhammer.entity;

import com.tosiv.warhammer.util.registry.EntityRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class BulletEntity extends ProjectileEntity {

    private boolean explodes;
    private float damage = 4.0F;
    private Vec3d originalPos;
    private double blockLifespan;
    private boolean hasGravity = false;

    public BulletEntity(EntityType<? extends ProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public BulletEntity(World world, LivingEntity owner, float damage, boolean explodes) {
        super(EntityRegistry.BULLET, world);
        this.setOwner(owner);
        this.originalPos = owner.getPos();
        this.explodes = explodes;
        double x = originalPos.getX();
        double y = originalPos.getY() + 1.5D;
        double z = originalPos.getZ();
        this.refreshPositionAndAngles(x, y, z, this.getYaw(), this.getPitch());
        this.damage = damage;
    }

    @Override
    protected void initDataTracker() {

    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putDouble("old_x", this.originalPos.x);
        nbt.putDouble("old_y", this.originalPos.y);
        nbt.putDouble("old_z", this.originalPos.z);
        nbt.putDouble("block_lifespan", this.blockLifespan);
    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.originalPos = new Vec3d(nbt.getDouble("old_x"), nbt.getDouble("old_y"), nbt.getDouble("old_z"));
        this.blockLifespan = nbt.getDouble("block_lifespan");
    }

    public void setGravity(boolean gravity) {
        this.hasGravity = gravity;
        setNoGravity(!gravity);
    }

    @Override
    public boolean hasNoGravity() {
        return !hasGravity;
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        if (hitResult.getType() == HitResult.Type.ENTITY && ((EntityHitResult)hitResult).getEntity() instanceof BulletEntity) return;
        super.onCollision(hitResult);
        if (explodes) explode();
        this.discard();
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
    }

    private void explode() {
        Vec3d pos = getPos();
        double x = pos.x;
        double y = pos.y;
        double z = pos.z;
        float radius = 2;
        for (Entity entity : world.getOtherEntities(this, new Box(x - radius, y - radius, z - radius, x + radius, y + radius, z + radius))) {
            if (entity.isImmuneToExplosion()) {
                continue;
            }
            Entity owner = getOwner();
            if (!(owner instanceof PlayerEntity)) {
                owner = null;
            }
            entity.damage(DamageSource.explosion((LivingEntity) owner), damage * 5);
        }
        ((ServerWorld)this.world).spawnParticles(ParticleTypes.EXPLOSION, x, y, z, 4, 0.2D, 0.2D, 0.2D, 0.0D);
        this.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 1.0F, 1.0F);
    }

    @Override
    public boolean collides() {
        return true;
    }

    protected void onEntityHit(EntityHitResult entityHitResult) {
        Entity hitEntity = entityHitResult.getEntity();
        if (hitEntity instanceof BulletEntity) {
            return;
        }
        super.onEntityHit(entityHitResult);
        Entity owner = this.getOwner();
        LivingEntity livingEntity = owner instanceof LivingEntity ? (LivingEntity)owner : null;
        hitEntity.damage(DamageSource.mobProjectile(this, livingEntity).setProjectile(), this.damage);
    }

    @Override
    protected boolean canHit(Entity entity) {
        return super.canHit(entity) && !entity.noClip;
    }

    @Override
    public boolean isOnFire() {
        return false;
    }

    @Override
    public boolean shouldRender(double distance) {
        return distance < 16384.0D;
    }

    @Override
    public void tick() {
        if (this.originalPos != null && getPos().distanceTo(this.originalPos) > this.blockLifespan) {
            ((ServerWorld)this.world).spawnParticles(ParticleTypes.EXPLOSION, this.getX(), this.getY(), this.getZ(), 2, 0.2D, 0.2D, 0.2D, 0.0D);
            this.playSound(SoundEvents.ENTITY_SHULKER_BULLET_HIT, 1.0F, 1.0F);
            this.discard();
            return;
        }

        Vec3d vec3d = this.getVelocity();
        if (hasGravity) {
            this.addVelocity(0, -0.03, 0);
        }

        if (!this.world.isClient) {
            HitResult hitResult = ProjectileUtil.getCollision(this, this::canHit);
            if (hitResult.getType() != HitResult.Type.MISS) {
                this.onCollision(hitResult);
            }
        }

        this.checkBlockCollision();
        this.setPosition(this.getX() + vec3d.x, this.getY() + vec3d.y, this.getZ() + vec3d.z);
        ProjectileUtil.method_7484(this, 0.5F);
        super.tick();
    }

    public void setBlockLifespan(double blockLifespan) {
        this.blockLifespan = blockLifespan;
    }

}
