package name.huakaipo.datagen;

import name.huakaipo.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.GEM_BLOCK)
                .add(ModBlocks.PALACE_BRICKS)
                .add(ModBlocks.RED_PALACE_BRICKS)
                .add(ModBlocks.SPIRIT_BRICKS)
                .add(ModBlocks.PALACE_BRICK_PILLAR);
        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.GEM_BLOCK)
                .add(ModBlocks.PALACE_BRICKS)
                .add(ModBlocks.RED_PALACE_BRICKS)
                .add(ModBlocks.SPIRIT_BRICKS)
                .add(ModBlocks.PALACE_BRICK_PILLAR);
        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.PALACE_BRICK_WALL)
                .add(ModBlocks.RED_PALACE_BRICK_WALL);
        getOrCreateTagBuilder(BlockTags.SOUL_SPEED_BLOCKS)
                .add(ModBlocks.SPIRIT_BRICKS);
        getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS)
                .add(ModBlocks.GEM_BLOCK);
        getOrCreateTagBuilder(BlockTags.SOUL_FIRE_BASE_BLOCKS)
                .add(ModBlocks.SPIRIT_BRICKS);
    }
}
