package name.huakaipo;

import name.huakaipo.block.ModBlocks;
import name.huakaipo.entity.ModEntities;
import name.huakaipo.entity.custom.GodslayerEntity;
import name.huakaipo.entity.custom.TikiManEntity;
import name.huakaipo.item.ModItemGroups;
import name.huakaipo.item.ModItems;
import name.huakaipo.sound.ModSounds;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HuakaiPo implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "huakaipo";
    public static final Logger LOGGER = LoggerFactory.getLogger("huakai-po");

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.RegisterModItems();
		ModBlocks.registerModBlocks();
		ModSounds.registerSounds();

		ModEntities.registerModEntities();
		FabricDefaultAttributeRegistry.register(ModEntities.TIKI_MAN, TikiManEntity.createTikiManEntityAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.GODSLAYER, GodslayerEntity.createGodslayerAttributes());
	}
}