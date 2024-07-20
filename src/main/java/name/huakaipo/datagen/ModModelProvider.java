package name.huakaipo.datagen;

import name.huakaipo.block.ModBlocks;
import name.huakaipo.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool palaceBricks = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.PALACE_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GEM_BLOCK);
        BlockStateModelGenerator.BlockTexturePool redPalaceBricks = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.RED_PALACE_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SPIRIT_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PALACE_BRICK_PILLAR);

        palaceBricks.stairs(ModBlocks.PALACE_BRICK_STAIRS);
        palaceBricks.wall(ModBlocks.PALACE_BRICK_WALL);
        palaceBricks.slab(ModBlocks.PALACE_BRICK_SLAB);

        redPalaceBricks.stairs(ModBlocks.RED_PALACE_BRICK_STAIRS);
        redPalaceBricks.wall(ModBlocks.RED_PALACE_BRICK_WALL);
        redPalaceBricks.slab(ModBlocks.RED_PALACE_BRICK_SLAB);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.GEM, Models.GENERATED);

        itemModelGenerator.register(ModItems.TIKI_MASK, Models.GENERATED);

        itemModelGenerator.register(ModItems.GODSLAYER_GUN, Models.GENERATED);

        itemModelGenerator.register(ModItems.HUAKAIMENU_DISC, Models.GENERATED);
        itemModelGenerator.register(ModItems.TECHNOROOM_DISC, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLAST_DISC, Models.GENERATED);

        itemModelGenerator.register(ModItems.TIKI_MAN_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(ModItems.GODSLAYER_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(ModItems.HUGHIE_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(ModItems.BALTHAZAR_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(ModItems.LATVIAN_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));
    }
}
