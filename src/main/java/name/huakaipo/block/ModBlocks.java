package name.huakaipo.block;

import name.huakaipo.HuakaiPo;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block GEM_BLOCK = registerBlock("gem_block",
            new Block(AbstractBlock.Settings.copy(Blocks.EMERALD_BLOCK).mapColor(MapColor.RED).instrument(NoteBlockInstrument.BIT)));

    public static final Block PALACE_BRICKS = registerBlock("palace_bricks",
            new Block(AbstractBlock.Settings.copy(Blocks.BRICKS).mapColor(MapColor.WHITE)));

    public static final Block RED_PALACE_BRICKS = registerBlock("red_palace_bricks",
            new Block(AbstractBlock.Settings.copy(Blocks.BRICKS)));
    public static final Block SPIRIT_BRICKS = registerBlock("spirit_palace_bricks",
            new Block(AbstractBlock.Settings.copy(Blocks.BRICKS).mapColor(MapColor.LIGHT_BLUE).breakInstantly()));

    private static Block registerBlock(String name, Block block)
    {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(HuakaiPo.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block)
    {
        return Registry.register(Registries.ITEM, Identifier.of(HuakaiPo.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks()
    {
        HuakaiPo.LOGGER.info("Registering Mod Blocks for " + HuakaiPo.MOD_ID);
    }
}
