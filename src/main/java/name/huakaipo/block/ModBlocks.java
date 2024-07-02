package name.huakaipo.block;

import name.huakaipo.HuakaiPo;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block GEM_BLOCK = registerBlock("gem_block",
            new Block(AbstractBlock.Settings.copy(Blocks.EMERALD_BLOCK).mapColor(MapColor.RED)));

    public static final Block PALACE_BRICKS = registerBlock("palace_bricks",
            new Block(AbstractBlock.Settings.copy(Blocks.POLISHED_DIORITE)));

    public static final Block PALACE_BRICK_STAIRS = registerBlock("palace_brick_stairs",
            new StairsBlock(ModBlocks.PALACE_BRICKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.POLISHED_DIORITE)));
    public static final Block PALACE_BRICK_WALL = registerBlock("palace_brick_wall",
            new WallBlock(AbstractBlock.Settings.copy(Blocks.POLISHED_DIORITE)));
    public static final Block PALACE_BRICK_SLAB = registerBlock("palace_brick_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.POLISHED_DIORITE)));

    public static final Block RED_PALACE_BRICKS = registerBlock("red_palace_bricks",
            new Block(AbstractBlock.Settings.copy(Blocks.POLISHED_DIORITE).mapColor(MapColor.RED)));

    public static final Block RED_PALACE_BRICK_STAIRS = registerBlock("red_palace_brick_stairs",
            new StairsBlock(ModBlocks.RED_PALACE_BRICKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.POLISHED_DIORITE).mapColor(MapColor.RED)));
    public static final Block RED_PALACE_BRICK_WALL = registerBlock("red_palace_brick_wall",
            new WallBlock(AbstractBlock.Settings.copy(Blocks.POLISHED_DIORITE).mapColor(MapColor.RED)));
    public static final Block RED_PALACE_BRICK_SLAB = registerBlock("red_palace_brick_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.POLISHED_DIORITE).mapColor(MapColor.RED)));


    public static final Block SPIRIT_BRICKS = registerBlock("spirit_palace_bricks",
            new Block(AbstractBlock.Settings.copy(Blocks.BRICKS).mapColor(MapColor.LIGHT_BLUE).breakInstantly()));
    public static final Block PALACE_BRICK_PILLAR = registerBlock("palace_brick_pillar",
            new Block(AbstractBlock.Settings.copy(Blocks.BRICKS).mapColor(MapColor.WHITE)));

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
