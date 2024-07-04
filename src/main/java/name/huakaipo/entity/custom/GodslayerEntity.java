package name.huakaipo.entity.custom;

import name.huakaipo.item.ModItems;
import name.huakaipo.sound.ModSounds;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.RangedWeaponItem;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;

public class GodslayerEntity extends HostileEntity implements RangedAttackMob {
    public final AnimationState idleAnimationState = new AnimationState();
    private final float MAX_SHOOT_RANGE = 2;
    private int idleanimationTimeout = 0;
    public GodslayerEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    private void setupAnimationState() {
        if (this.idleanimationTimeout <= 0) {
            this.idleanimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleanimationTimeout;
        }
    }
    @Override
    protected void updateLimbs(float posDelta) {
        float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0f, 1.0f) : 0.0f;
        this.limbAnimator.updateLimbs(f, 0.2f);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getWorld().isClient()) {
            setupAnimationState();
        }
    }

    public static DefaultAttributeContainer.Builder createGodslayerAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 15.0)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 15)
                .add(EntityAttributes.GENERIC_ARMOR, 2.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3.5)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 2)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.5);
    }

    @Override
    protected void initGoals() {
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(0, new ActiveTargetGoal<>(this, TikiManEntity.class, true));
        this.goalSelector.add(2, new ProjectileAttackGoal(this, 1, 1, MAX_SHOOT_RANGE));
        this.goalSelector.add(2, new WanderAroundFarGoal(this, 0.4));
        this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(3, new LookAroundGoal(this));
    }

    @Override
    protected void initEquipment(Random random, LocalDifficulty localDifficulty) {
        super.initEquipment(random, localDifficulty);
        this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(ModItems.GODSLAYER_GUN));
    }
    @Override
    public boolean canUseRangedWeapon(RangedWeaponItem weapon) {
        return weapon == ModItems.GODSLAYER_GUN;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_VILLAGER_HURT;
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_VILLAGER_HURT;
    }
    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.TIKI_MAN_DEATH_SFX;
    }

    @Override
    public boolean onKilledOther(ServerWorld world, LivingEntity other) {
        this.playSound(ModSounds.TIKI_MAN_AMBIENT_SFX, 1.0F, 1.0F);
        return super.onKilledOther(world, other);
    }

    @Override
    public void shootAt(LivingEntity target, float pullProgress) {
        ItemStack itemStack = this.getStackInHand(ProjectileUtil.getHandPossiblyHolding(this, ModItems.GODSLAYER_GUN));
        Vec3d vec3d = this.getRotationVec(0).normalize();
        ServerWorld serverWorld = (ServerWorld) this.getWorld();
        if (target.distanceTo(this) < MAX_SHOOT_RANGE) {
            serverWorld
                    .spawnParticles(
                            ParticleTypes.FLAME,
                            this.getX() + vec3d.x * 0.5,
                            this.getBodyY(.6) + vec3d.y,
                            this.getZ() + vec3d.z * 0.5,
                            1,
                            vec3d.x,
                            vec3d.y,
                            vec3d.z,
                            .3
                    );
            DamageSource damageSource = this.getDamageSources().onFire();
            target.damage(damageSource, 3f);
            target.setOnFireFor(5);
        }

        itemStack.damage(1, this, EquipmentSlot.MAINHAND);
    }

    @Override
    public boolean isFireImmune() {
        return true;
    }
}
