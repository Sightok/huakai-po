package name.huakaipo.item;

import name.huakaipo.HuakaiPo;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item GEM = registerItem("gem", new Item(new Item.Settings()));
    public static final Item GODSLAYER_GUN = registerItem("godslayergun", new Item(new Item.Settings()));

    public static final Item HUAKAIMENU_DISC = registerItem("huakaimenu_disc", new Item(new Item.Settings()));
    public static final Item TECHNOROOM_DISC = registerItem("technoroom_disc", new Item(new Item.Settings()));
    public static final Item BLAST_DISC = registerItem("blast_disc", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(HuakaiPo.MOD_ID, name), item);
    }

    public static void RegisterModItems()
    {
        HuakaiPo.LOGGER.info("Registering Mod Items for " + HuakaiPo.MOD_ID);
    }
}
