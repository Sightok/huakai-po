package name.huakaipo.item;

import name.huakaipo.HuakaiPo;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup HUAKAIPO_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(HuakaiPo.MOD_ID, "huakaipo"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.huakaipo"))
                    .icon(() -> new ItemStack(ModItems.HUAKAI_GEM)).entries((displayContext, entries) -> {
                        entries.add(ModItems.HUAKAI_GEM);
                        entries.add(ModItems.GODSLAYER_GUN);

                        entries.add(Items.ANGLER_POTTERY_SHERD);


                    }).build());
    public static void registerItemGroups()
    {
        HuakaiPo.LOGGER.info("Registering Mod Item Groups for " + HuakaiPo.MOD_ID);
    }
}
