package name.huakaipo.item.custom;

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
import net.minecraft.particle.ParticleTypes;
import net.minecraft.particle.ParticleUtil;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
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

import java.util.Iterator;

public class GodslayerGunItem extends Item {
    public GodslayerGunItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        DamageSource damageSource = entity.getDamageSources().onFire();
        entity.damage(damageSource, 1.5f);
        entity.setOnFireFor(5);

        stack.damage(1, user, EquipmentSlot.MAINHAND);
        return super.useOnEntity(stack, user, entity, hand);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        BlockHitResult hitResult = raycast(world, playerEntity, RaycastContext.FluidHandling.NONE);
        ParticleUtil.spawnParticles(world, playerEntity.getBlockPos(), ParticleTypes.FLAME, UniformIntProvider.create(5, 10), Direction.UP, () -> Vec3d.fromPolar(playerEntity.getPitch(), playerEntity.getYaw()).multiply(0.3), 0.5);
        playerEntity.playSound(SoundEvents.BLOCK_FIRE_AMBIENT);
        ItemStack itemStack = playerEntity.getStackInHand(hand);
        if(hitResult.getType() == HitResult.Type.MISS){
            return TypedActionResult.pass(itemStack);
        } else {
                if (hitResult.getType() == HitResult.Type.BLOCK) {
                    BlockPos blockPos = hitResult.getBlockPos().up(1);
                    if (AbstractFireBlock.canPlaceAt(world, blockPos, Direction.getFacing(Vec3d.fromPolar(playerEntity.getPitch(), playerEntity.getYaw()).multiply(0.3)))) {
                        world.setBlockState(hitResult.getBlockPos().up(), Blocks.FIRE.getDefaultState());
                    }
                    itemStack.damage(1, playerEntity, EquipmentSlot.MAINHAND);
                    return TypedActionResult.pass(itemStack);
                }
            }
        return TypedActionResult.pass(itemStack);
    }
}
