package name.huakaipo.item.custom;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.*;
import net.minecraft.command.CommandAction;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.particle.ParticleUtil;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import java.util.Iterator;
import java.util.Objects;

public class GodslayerGunItem extends Item {
    public GodslayerGunItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        DamageSource damageSource = entity.getDamageSources().onFire();
        Vec3d vec3d = entity.getRotationVec(0).normalize();
        entity.damage(damageSource, 1.5f);
        entity.setOnFireFor(5);

        stack.damage(1, user, EquipmentSlot.MAINHAND);
        return super.useOnEntity(stack, user, entity, hand);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        if (!world.isClient) {
            FireParticles(world, playerEntity);
        }
        return super.use(world, playerEntity, hand);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity playerEntity = context.getPlayer();
        World world = context.getWorld();
        FireParticles(world, playerEntity);
        BlockPos blockPos = context.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
        if (!CampfireBlock.canBeLit(blockState) && !CandleBlock.canBeLit(blockState) && !CandleCakeBlock.canBeLit(blockState)) {
            BlockPos blockPos2 = blockPos.offset(context.getSide());
            if (AbstractFireBlock.canPlaceAt(world, blockPos2, context.getHorizontalPlayerFacing())) {
                BlockState blockState2 = AbstractFireBlock.getState(world, blockPos2);
                world.setBlockState(blockPos2, blockState2, Block.NOTIFY_ALL_AND_REDRAW);
                world.emitGameEvent(playerEntity, GameEvent.BLOCK_PLACE, blockPos);
                ItemStack itemStack = context.getStack();
                if (playerEntity instanceof ServerPlayerEntity) {
                    Criteria.PLACED_BLOCK.trigger((ServerPlayerEntity)playerEntity, blockPos2, itemStack);
                    itemStack.damage(1, playerEntity, LivingEntity.getSlotForHand(context.getHand()));
                }

                return useOnBlock(context);
            } else {
                return ActionResult.FAIL;
            }
        } else {
            world.setBlockState(blockPos, blockState.with(Properties.LIT, Boolean.valueOf(true)), Block.NOTIFY_ALL_AND_REDRAW);
            world.emitGameEvent(playerEntity, GameEvent.BLOCK_CHANGE, blockPos);
            context.getStack().damage(1, playerEntity, LivingEntity.getSlotForHand(context.getHand()));
            return ActionResult.success(world.isClient());
        }
    }

    private void FireParticles(World world, LivingEntity entity) {
        Vec3d vec3d = entity.getRotationVec(0).normalize();

        ServerWorld serverWorld = (ServerWorld) world;
        serverWorld
                .spawnParticles(
                        ParticleTypes.FLAME,
                        entity.getX() + vec3d.x * 1,
                        entity.getBodyY(.6) + vec3d.y,
                        entity.getZ() + vec3d.z * 1,
                        5,
                        0.0,
                        0.0,
                        0.0,
                .3
                );
        world.playSound(null, entity.getBlockPos(),SoundEvents.BLOCK_FIRE_AMBIENT, SoundCategory.PLAYERS);
    }
}
