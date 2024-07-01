package name.huakaipo.datagen;

import name.huakaipo.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.GEM_BLOCK);
        addDrop(ModBlocks.PALACE_BRICKS);
        addDrop(ModBlocks.PALACE_BRICK_STAIRS);
        addDrop(ModBlocks.PALACE_BRICK_WALL);
        addDrop(ModBlocks.PALACE_BRICK_SLAB, slabDrops(ModBlocks.PALACE_BRICK_SLAB));
        addDrop(ModBlocks.RED_PALACE_BRICKS);
        addDrop(ModBlocks.RED_PALACE_BRICK_STAIRS);
        addDrop(ModBlocks.RED_PALACE_BRICK_WALL);
        addDrop(ModBlocks.RED_PALACE_BRICK_SLAB, slabDrops(ModBlocks.RED_PALACE_BRICK_SLAB));
        addDrop(ModBlocks.SPIRIT_BRICKS);
        addDrop(ModBlocks.PALACE_BRICK_PILLAR);
    }
}
