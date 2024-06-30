package name.huakaipo.item;

import name.huakaipo.HuakaiPo;
import name.huakaipo.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup HUAKAIPO_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(HuakaiPo.MOD_ID, "huakaipo"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.huakaipo"))
                    .icon(() -> new ItemStack(ModItems.GEM)).entries((displayContext, entries) -> {
                        entries.add(ModItems.GEM);
                        entries.add(ModItems.GODSLAYER_GUN);

                        entries.add(ModItems.HUAKAIMENU_DISC);
                        entries.add(ModItems.TECHNOROOM_DISC);
                        entries.add(ModItems.BLAST_DISC);

                        entries.add(ModBlocks.GEM_BLOCK);
                        entries.add(ModBlocks.PALACE_BRICKS);
                        entries.add(ModBlocks.RED_PALACE_BRICKS);
                        entries.add(ModBlocks.SPIRIT_BRICKS);


                    }).build());
    public static void registerItemGroups()
    {
        HuakaiPo.LOGGER.info("Registering Mod Item Groups for " + HuakaiPo.MOD_ID);
    }
}
