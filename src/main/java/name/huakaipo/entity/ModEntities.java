package name.huakaipo.entity;

import name.huakaipo.HuakaiPo;
import name.huakaipo.entity.custom.BalthazarEntity;
import name.huakaipo.entity.custom.GodslayerEntity;
import name.huakaipo.entity.custom.HughieEntity;
import name.huakaipo.entity.custom.TikiManEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<TikiManEntity> TIKI_MAN = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(HuakaiPo.MOD_ID, "tiki_man"),
            EntityType.Builder.create(TikiManEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.5f,2)
                    .build());
    public static final EntityType<GodslayerEntity> GODSLAYER = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(HuakaiPo.MOD_ID, "godslayer"),
            EntityType.Builder.create(GodslayerEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.5f,2)
                    .build());
    public static final EntityType<HughieEntity> MASTER_HUGHIE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(HuakaiPo.MOD_ID, "master_hughie"),
            EntityType.Builder.create(HughieEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.5f,0.5f)
                    .build());
    public static final EntityType<BalthazarEntity> BALTHAZAR_ENTITY = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(HuakaiPo.MOD_ID, "balthazar"),
            EntityType.Builder.create(BalthazarEntity::new, SpawnGroup.MISC)
                    .dimensions(1f,3f)
                    .build());


    public static void registerModEntities() {
        HuakaiPo.LOGGER.info("Registering Entities for " + HuakaiPo.MOD_ID);
    }
}
