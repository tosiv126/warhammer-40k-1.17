package com.tosiv.warhammer.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.Durations;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.UUID;

public class IgChainswordVillagerEntity extends PathAwareEntity implements IAnimatable, Angerable {
    AnimationFactory factory = new AnimationFactory(this);

    private static final TrackedData<Integer> ANGER_TIME;
    private static final UniformIntProvider ANGER_TIME_RANGE;
    private UUID targetUuid;

    public IgChainswordVillagerEntity(EntityType<? extends PathAwareEntity> type, World world) {
        super(type, world);
    }

    public static DefaultAttributeContainer.Builder createIgChainswordVillagerAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 10D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.5D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 5D);
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (!(lastLimbDistance > -0.10F && lastLimbDistance < 0.10F) && !this.isAttacking()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("ig_chainsword_villager.walk", true));
            return PlayState.CONTINUE;
        }
        if (this.isAttacking() && !(this.dead || this.getHealth() < 0.01 || this.isDead())) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("ig_chainsword_villager.attack", true));
            return PlayState.CONTINUE;
        }
        if ((this.dead || this.getHealth() < 0.01 || this.isDead())) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("ig_chainsword_villager.idle", false));
            return PlayState.CONTINUE;
        }
        event.getController().setAnimation(new AnimationBuilder().addAnimation("ig_chainsword_villager.idle", true));
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(
                new AnimationController<IgChainswordVillagerEntity>(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));

        this.goalSelector.add(5, new MeleeAttackGoal(this, 0.5D, true));

        this.goalSelector.add(8, new WanderAroundFarGoal(this, 1.0D));

        this.goalSelector.add(10, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(10, new LookAroundGoal(this));

        this.targetSelector.add(1, (new RevengeGoal(this, new Class[0])).setGroupRevenge(new Class[0]));
        this.targetSelector.add(2, new FollowTargetGoal<>(this, TauWarriorEntity.class, true));
        this.targetSelector.add(3, new FollowTargetGoal<>(this, ScarabEntity.class, true));
        this.targetSelector.add(4, new FollowTargetGoal<>(this, ZombieEntity.class, true));
        this.targetSelector.add(5, new FollowTargetGoal<>(this, SkeletonEntity.class, true));
        this.targetSelector.add(6, new FollowTargetGoal<>(this, GunDroneEntity.class, true));
        this.targetSelector.add(8, new UniversalAngerGoal(this, true));
    }

    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(ANGER_TIME, 0);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        if (this.hasAngerTime()) {
            return SoundEvents.ENTITY_VILLAGER_NO;
        } else {
            return SoundEvents.ENTITY_VILLAGER_AMBIENT;
        }
    }



    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource_1) {
        return SoundEvents.ENTITY_VILLAGER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_VILLAGER_DEATH;
    }

    protected float getSoundVolume() {
        return 0.4F;
    }

    public boolean damage(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) {
            return false;
        } else {
            Entity entity = source.getAttacker();
            if (entity != null && !(entity instanceof PlayerEntity) && !(entity instanceof PersistentProjectileEntity)) {
                amount = (amount + 1.0F) / 2.0F;
            }

            return super.damage(source, amount);
        }
    }

    public boolean tryAttack(Entity target) {
        boolean bl = target.damage(DamageSource.mob(this), (float)((int)this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE)));
        if (bl) {
            this.applyDamageEffects(this, target);
        }

        return bl;
    }

    public int getLimitPerChunk() {
        return 8;
    }

    public int getAngerTime() {
        return (Integer)this.dataTracker.get(ANGER_TIME);
    }

    public void setAngerTime(int ticks) {
        this.dataTracker.set(ANGER_TIME, ticks);
    }

    public void chooseRandomAngerTime() {
        this.setAngerTime(ANGER_TIME_RANGE.get(this.random));
    }

    @Nullable
    public UUID getAngryAt() {
        return this.targetUuid;
    }

    public void setAngryAt(@Nullable UUID uuid) {
        this.targetUuid = uuid;
    }

    static {
        ANGER_TIME = DataTracker.registerData(WolfEntity.class, TrackedDataHandlerRegistry.INTEGER);
        ANGER_TIME_RANGE = Durations.betweenSeconds(20, 39);
    }
}
