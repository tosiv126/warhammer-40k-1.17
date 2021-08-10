package com.tosiv.warhammer.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.EnumSet;
import java.util.UUID;

public class TauWarriorEntity extends HostileEntity implements IAnimatable, Monster {
    AnimationFactory factory = new AnimationFactory(this);
    private UUID targetUuid;
    private static final TrackedData<Boolean> SHOOTING;
    private int fireballStrength = 1;

    public TauWarriorEntity(EntityType<? extends HostileEntity> type, World world) {
        super(type, world);

        this.experiencePoints = 5;
        this.moveControl = new TauWarriorEntity.GunDroneMoveControl(this);
    }

    public static DefaultAttributeContainer.Builder createTauWarriorAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 10D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.5D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 5D);
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (!(lastLimbDistance > -0.10F && lastLimbDistance < 0.10F) && !this.isAttacking()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("tau_warrior.walk", true));
            return PlayState.CONTINUE;
        }
        if (this.isShooting() && !(this.dead || this.getHealth() < 0.01 || this.isDead())) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("tau_warrior.attack", true));
            return PlayState.CONTINUE;
        }
        if ((this.dead || this.getHealth() < 0.01 || this.isDead())) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("tau_warrior.idle", false));
            return PlayState.CONTINUE;
        }
        event.getController().setAnimation(new AnimationBuilder().addAnimation("tau_warrior.idle", true));
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(
                new AnimationController<TauWarriorEntity>(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    @Override
    protected void initGoals() {

        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new FleeEntityGoal(this, ScarabEntity.class, 6.0F, 1.0D, 1.2D));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 1.0D));
        this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(5, new LookAroundGoal(this));

        this.goalSelector.add(6, new TauWarriorEntity.LookAtTargetGoal(this));
        this.goalSelector.add(7, new TauWarriorEntity.ShootFireballGoal(this));

        this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(9, new LookAroundGoal(this));

        this.targetSelector.add(1, new RevengeGoal(this, new Class[0]));
        this.targetSelector.add(2, new FollowTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(3, new FollowTargetGoal<>(this, ScarabEntity.class, true));
        this.targetSelector.add(3, new FollowTargetGoal<>(this, IgChainswordVillagerEntity.class, true));

    }

    public boolean isShooting() {
        return (Boolean)this.dataTracker.get(SHOOTING);
    }

    public void setShooting(boolean shooting) {
        this.dataTracker.set(SHOOTING, shooting);
    }

    public int getFireballStrength() {
        return this.fireballStrength;
    }

    protected boolean isDisallowedInPeaceful() {
        return true;
    }

    public boolean damage(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) {
            return false;
        } else if (source.getSource() instanceof FireballEntity && source.getAttacker() instanceof PlayerEntity) {
            super.damage(source, 1000.0F);
            return true;
        } else {
            return super.damage(source, amount);
        }
    }

    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(SHOOTING, false);
    }

    public int getLimitPerChunk() {
        return 5;
    }

    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putByte("ExplosionPower", (byte)this.fireballStrength);
    }

    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        if (nbt.contains("ExplosionPower", 3)) {
            this.fireballStrength = nbt.getByte("ExplosionPower");
        }

    }

    static {
        SHOOTING = DataTracker.registerData(TauWarriorEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    }

    static class GunDroneMoveControl extends MoveControl {
        private final TauWarriorEntity gun_drone;
        private int collisionCheckCooldown;

        public GunDroneMoveControl(TauWarriorEntity gun_drone) {
            super(gun_drone);
            this.gun_drone = gun_drone;
        }

        public void tick() {
            if (this.state == State.MOVE_TO) {
                if (this.collisionCheckCooldown-- <= 0) {
                    this.collisionCheckCooldown += this.gun_drone.getRandom().nextInt(5) + 2;
                    Vec3d vec3d = new Vec3d(this.targetX - this.gun_drone.getX(), this.targetY - this.gun_drone.getY(), this.targetZ - this.gun_drone.getZ());
                    double d = vec3d.length();
                    vec3d = vec3d.normalize();
                    if (this.willCollide(vec3d, MathHelper.ceil(d))) {
                        this.gun_drone.setVelocity(this.gun_drone.getVelocity().add(vec3d.multiply(0.1D)));
                    } else {
                        this.state = State.WAIT;
                    }
                }

            }
        }

        private boolean willCollide(Vec3d direction, int steps) {
            Box box = this.gun_drone.getBoundingBox();

            for(int i = 1; i < steps; ++i) {
                box = box.offset(direction);
                if (!this.gun_drone.world.isSpaceEmpty(this.gun_drone, box)) {
                    return false;
                }
            }

            return true;
        }
    }

    static class LookAtTargetGoal extends Goal {
        private final TauWarriorEntity gun_drone;

        public LookAtTargetGoal(TauWarriorEntity gun_drone) {
            this.gun_drone = gun_drone;
            this.setControls(EnumSet.of(Control.LOOK));
        }

        public boolean canStart() {
            return true;
        }

        public void tick() {
            if (this.gun_drone.getTarget() == null) {
                Vec3d vec3d = this.gun_drone.getVelocity();
                this.gun_drone.setYaw(-((float)MathHelper.atan2(vec3d.x, vec3d.z)) * 57.295776F);
                this.gun_drone.bodyYaw = this.gun_drone.getYaw();
            } else {
                LivingEntity livingEntity = this.gun_drone.getTarget();
                double d = 64.0D;
                if (livingEntity.squaredDistanceTo(this.gun_drone) < 4096.0D) {
                    double e = livingEntity.getX() - this.gun_drone.getX();
                    double f = livingEntity.getZ() - this.gun_drone.getZ();
                    this.gun_drone.setYaw(-((float)MathHelper.atan2(e, f)) * 57.295776F);
                    this.gun_drone.bodyYaw = this.gun_drone.getYaw();
                }
            }

        }
    }

    private static class ShootFireballGoal extends Goal {
        private final TauWarriorEntity gun_drone;
        public int cooldown;

        public ShootFireballGoal(TauWarriorEntity gun_drone) {
            this.gun_drone = gun_drone;
        }

        public boolean canStart() {
            return this.gun_drone.getTarget() != null;
        }

        public void start() {
            this.cooldown = 0;
        }

        public void stop() {
            this.gun_drone.setShooting(false);
        }

        public void tick() {
            LivingEntity livingEntity = this.gun_drone.getTarget();
            double d = 64.0D;
            if (livingEntity.squaredDistanceTo(this.gun_drone) < 4096.0D && this.gun_drone.canSee(livingEntity)) {
                World world = this.gun_drone.world;
                ++this.cooldown;
                if (this.cooldown == 10 && !this.gun_drone.isSilent()) {
                    world.syncWorldEvent((PlayerEntity)null, 1015, this.gun_drone.getBlockPos(), 0);
                }

                if (this.cooldown == 20) {
                    double e = 4.0D;
                    Vec3d vec3d = this.gun_drone.getRotationVec(1.0F);
                    double f = livingEntity.getX() - (this.gun_drone.getX() + vec3d.x * 4.0D);
                    double g = livingEntity.getBodyY(0.5D) - (0.5D + this.gun_drone.getBodyY(0.5D));
                    double h = livingEntity.getZ() - (this.gun_drone.getZ() + vec3d.z * 4.0D);
                    if (!this.gun_drone.isSilent()) {
                        world.syncWorldEvent((PlayerEntity)null, 1016, this.gun_drone.getBlockPos(), 0);
                    }

                    FireballEntity fireballEntity = new FireballEntity(world, this.gun_drone, f, g, h, this.gun_drone.getFireballStrength());
                    fireballEntity.setPosition(this.gun_drone.getX() + vec3d.x * 4.0D, this.gun_drone.getBodyY(0.5D) + 0.5D, fireballEntity.getZ() + vec3d.z * 4.0D);
                    world.spawnEntity(fireballEntity);
                    this.cooldown = -40;
                }
            } else if (this.cooldown > 0) {
                --this.cooldown;
            }

            this.gun_drone.setShooting(this.cooldown > 10);
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_ELDER_GUARDIAN_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource_1) {
        return SoundEvents.ENTITY_ELDER_GUARDIAN_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_ELDER_GUARDIAN_DEATH;
    }


}
