package mobiusstudios.recipeace.data.client.recipes;

import com.google.gson.JsonObject;
import mobiusstudios.recipeace.Recipeace;
import mobiusstudios.recipeace.data.client.items.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.data.*;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.nio.file.Path;
import java.util.function.Consumer;

public class RecipeaceProvider extends RecipeProvider {
    public RecipeaceProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

    private final String BLUEPRINT_GROUP = Recipeace.MOD_ID + ":blueprint/";

    @Override
    public void act(@Nonnull DirectoryCache cache) throws IOException {
        super.act(cache);
    }

    @Override
    protected void saveRecipeAdvancement(@Nonnull DirectoryCache cache, @Nonnull JsonObject cache2, @Nonnull Path advancementJson) {
        super.saveRecipeAdvancement(cache, cache2, advancementJson);
    }

    @Override
    @Nonnull
    public String getName() {
        return "Recipeace - Recipes";
    }

    @Override
    protected void registerRecipes(@Nonnull Consumer<IFinishedRecipe> consumer) {
        registerShapelessRecipes(consumer);
        registerShapedRecipes(consumer);
        registerStoneCutterRecipes(consumer);
        registerSmokingRecipes(consumer);
        registerBlastingRecipes(consumer);
        registerSmeltingRecipes(consumer);
    }

    private void registerShapelessRecipes(Consumer<IFinishedRecipe> consumer) {

        ShapelessRecipeBuilder.shapelessRecipe(Items.SPIDER_EYE, 5)
                .setGroup(BLUEPRINT_GROUP + "spider_eye")
                .addIngredient(Items.NETHER_WART)
                .build(consumer);

        ShapelessRecipeBuilder.shapelessRecipe(Items.ROTTEN_FLESH)
                .setGroup(BLUEPRINT_GROUP + "rotten_flesh")
                .addIngredient(Items.BEEF)
                .addIngredient(Items.SUGAR)
                .addIngredient(Blocks.BROWN_MUSHROOM)
                .build(consumer);

        ShapelessRecipeBuilder.shapelessRecipe(Items.ROTTEN_FLESH)
                .setGroup(BLUEPRINT_GROUP + "rotten_flesh")
                .addIngredient(Items.BEEF)
                .addIngredient(Items.SUGAR)
                .addIngredient(Blocks.RED_MUSHROOM)
                .build(consumer);

        ShapelessRecipeBuilder.shapelessRecipe(Items.STRING, 4)
                .setGroup(BLUEPRINT_GROUP + "string")
                .addIngredient(Items.WHITE_WOOL)
                .build(consumer);

        ShapelessRecipeBuilder.shapelessRecipe(Items.SLIME_BALL, 4)
                .setGroup(BLUEPRINT_GROUP + "slime_ball")
                .addIngredient(Ingredient.fromItems(Blocks.BROWN_MUSHROOM), 7)
                .addIngredient(Ingredient.fromItems(Items.WATER_BUCKET))
                .addIngredient(Ingredient.fromItems(Items.GREEN_DYE))
                .build(consumer);

        ShapelessRecipeBuilder.shapelessRecipe(Items.SLIME_BALL, 4)
                .setGroup(BLUEPRINT_GROUP + "slime_ball")
                .addIngredient(Ingredient.fromItems(Blocks.RED_MUSHROOM), 7)
                .addIngredient(Ingredient.fromItems(Items.WATER_BUCKET))
                .addIngredient(Ingredient.fromItems(Items.GREEN_DYE))
                .build(consumer);

//        ShapelessRecipeBuilder.shapelessRecipe()
//                .setGroup(BLUEPRINT_GROUP + "")
//                .addIngredient()
//                .build(consumer);
    }

    private void registerShapedRecipes(Consumer<IFinishedRecipe> consumer) {

        ShapedRecipeBuilder.shapedRecipe(ModItems.GOLD_ROD.get())
                .setGroup(BLUEPRINT_GROUP + "gold_rod")
                .key('i', Ingredient.fromItems(Items.GOLD_INGOT))
                .patternLine("  i")
                .patternLine(" i ")
                .patternLine("i  ")
                .build(consumer);
    }

    private void registerStoneCutterRecipes(Consumer<IFinishedRecipe> consumer) {

    }

    private void registerSmeltingRecipes(Consumer<IFinishedRecipe> consumer) {

//        CookingRecipeBuilder.smeltingRecipe(
//                    Ingredient.fromItems(),
//                    Items.,
//                    1.0F,
//                    200)
//                .build(consumer);
    }

    private void registerSmokingRecipes(Consumer<IFinishedRecipe> consumer) {

    }

    private void registerBlastingRecipes(Consumer<IFinishedRecipe> consumer) {
        CookingRecipeBuilder.blastingRecipe(
                Ingredient.fromItems(ModItems.GOLD_ROD.get()),
                Items.BLAZE_ROD,
                1.0F,
                100)
                .build(consumer);
    }
}
