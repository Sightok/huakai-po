package name.huakaipo;

import name.huakaipo.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HuakaiPo implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "huakai-po";
    public static final Logger LOGGER = LoggerFactory.getLogger("huakai-po");

	@Override
	public void onInitialize() {
		ModItems.RegisterModItems();
	}
}