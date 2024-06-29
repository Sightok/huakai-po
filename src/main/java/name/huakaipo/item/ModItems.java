package name.huakaipo.item;

import name.huakaipo.HuakaiPo;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item HUAKAI_GEM = registerItem("huakai-gem", new Item(new Item.Settings()));

    private static void addItemstoItemGroup(FabricItemGroupEntries entries)
    {
        entries.add(HUAKAI_GEM);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(HuakaiPo.MOD_ID, name), item);
    }

    public static void RegisterModItems()
    {
        HuakaiPo.LOGGER.info("Registering Mod Items for " + HuakaiPo.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemstoItemGroup);
    }
}
