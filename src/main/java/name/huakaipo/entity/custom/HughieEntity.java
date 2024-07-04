package name.huakaipo.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.world.World;

public class HughieEntity extends WolfEntity {
    public HughieEntity(EntityType<? extends WolfEntity> entityType, World world) {
        super(entityType, world);
    }
}
