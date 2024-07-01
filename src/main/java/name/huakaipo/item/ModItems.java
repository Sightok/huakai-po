package name.huakaipo.item;

import name.huakaipo.HuakaiPo;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item GEM = registerItem("gem", new Item(new Item.Settings()));
    public static final Item GODSLAYER_GUN = registerItem("godslayergun", new Item(new Item.Settings().maxCount(1)));

    public static final Item TIKI_MASK = registerItem("tiki_mask", new ArmorItem(ArmorMaterials.GOLD, ArmorItem.Type.HELMET, new Item.Settings()));

    public static final Item HUAKAIMENU_DISC = registerItem("huakaimenu_disc", new Item(new Item.Settings()
            .jukeboxPlayable(RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of("huakaipo", "huakaimenu_disc")))));
    public static final Item TECHNOROOM_DISC = registerItem("technoroom_disc", new Item(new Item.Settings()
            .jukeboxPlayable(RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of("huakaipo", "technoroom_disc")))));
    public static final Item BLAST_DISC = registerItem("blast_disc", new Item(new Item.Settings()
            .jukeboxPlayable(RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of("huakaipo", "blast_disc")))));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(HuakaiPo.MOD_ID, name), item);
    }

    public static void RegisterModItems()
    {
        HuakaiPo.LOGGER.info("Registering Mod Items for " + HuakaiPo.MOD_ID);
    }
}
