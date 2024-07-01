package name.huakaipo.datagen;

import name.huakaipo.block.ModBlocks;
import name.huakaipo.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static List<ItemConvertible> GEM_SMELTABLES = List.of(Items.COAL_BLOCK);

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerSmelting(exporter, GEM_SMELTABLES, RecipeCategory.MISC, ModItems.GEM, 0.8f, 120, "gem");
        offerBlasting(exporter, GEM_SMELTABLES, RecipeCategory.MISC, ModItems.GEM, 0.8f, 60, "gem");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.GEM, RecipeCategory.DECORATIONS, ModBlocks.GEM_BLOCK);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALACE_BRICKS, Items.POLISHED_DIORITE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALACE_BRICK_PILLAR, ModBlocks.PALACE_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALACE_BRICK_STAIRS, ModBlocks.PALACE_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALACE_BRICK_WALL, ModBlocks.PALACE_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALACE_BRICK_SLAB, ModBlocks.PALACE_BRICKS);

        createStairsRecipe(ModBlocks.PALACE_BRICK_STAIRS, Ingredient.ofItems(ModBlocks.PALACE_BRICKS))
                .criterion(hasItem(ModBlocks.PALACE_BRICKS), conditionsFromItem(ModBlocks.PALACE_BRICKS))
                .criterion(hasItem(ModBlocks.PALACE_BRICK_STAIRS), conditionsFromItem(ModBlocks.PALACE_BRICK_STAIRS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.PALACE_BRICK_STAIRS)));
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALACE_BRICK_WALL, ModBlocks.PALACE_BRICKS);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALACE_BRICK_SLAB, ModBlocks.PALACE_BRICKS);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RED_PALACE_BRICK_STAIRS, ModBlocks.RED_PALACE_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RED_PALACE_BRICK_WALL, ModBlocks.RED_PALACE_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RED_PALACE_BRICK_SLAB, ModBlocks.RED_PALACE_BRICKS);

        createStairsRecipe(ModBlocks.RED_PALACE_BRICK_STAIRS, Ingredient.ofItems(ModBlocks.RED_PALACE_BRICKS))
                .criterion(hasItem(ModBlocks.RED_PALACE_BRICKS), conditionsFromItem(ModBlocks.RED_PALACE_BRICKS))
                .criterion(hasItem(ModBlocks.RED_PALACE_BRICK_STAIRS), conditionsFromItem(ModBlocks.RED_PALACE_BRICK_STAIRS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.RED_PALACE_BRICK_STAIRS)));
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RED_PALACE_BRICK_WALL, ModBlocks.RED_PALACE_BRICKS);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RED_PALACE_BRICK_SLAB, ModBlocks.RED_PALACE_BRICKS);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.PALACE_BRICKS, 4)
                .pattern("##")
                .pattern("##")
                .input('#', Items.POLISHED_DIORITE)
                .criterion(hasItem(Items.DIORITE), conditionsFromItem(Items.DIORITE))
                .criterion(hasItem((ModBlocks.PALACE_BRICKS)), conditionsFromItem(ModBlocks.PALACE_BRICKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.PALACE_BRICKS)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RED_PALACE_BRICKS, 4)
                .pattern("#R")
                .pattern("R#")
                .input('#', Items.POLISHED_DIORITE)
                .input('R', ModItems.GEM)
                .criterion(hasItem((Items.POLISHED_DIORITE)), conditionsFromItem(Items.POLISHED_DIORITE))
                .criterion(hasItem((ModBlocks.RED_PALACE_BRICKS)), conditionsFromItem(ModBlocks.RED_PALACE_BRICKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.RED_PALACE_BRICKS)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.SPIRIT_BRICKS, 4)
                .pattern("#S")
                .pattern("S#")
                .input('#', Items.POLISHED_DIORITE)
                .input('S', Items.SOUL_SAND)
                .criterion(hasItem((Items.POLISHED_DIORITE)), conditionsFromItem(Items.POLISHED_DIORITE))
                .criterion(hasItem((ModBlocks.SPIRIT_BRICKS)), conditionsFromItem(ModBlocks.SPIRIT_BRICKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.SPIRIT_BRICKS)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.PALACE_BRICK_PILLAR, 2)
                .pattern("#")
                .pattern("#")
                .input('#', Items.POLISHED_DIORITE)
                .criterion(hasItem((Items.POLISHED_DIORITE)), conditionsFromItem(Items.POLISHED_DIORITE))
                .criterion(hasItem((ModBlocks.PALACE_BRICK_PILLAR)), conditionsFromItem(ModBlocks.PALACE_BRICK_PILLAR))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.PALACE_BRICK_PILLAR)));
    }
}
