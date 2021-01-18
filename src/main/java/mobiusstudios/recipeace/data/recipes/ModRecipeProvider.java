package mobiusstudios.recipeace.data.recipes;

import mobiusstudios.recipeace.Recipeace;
import mobiusstudios.recipeace.setup.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.data.*;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.SingleItemRecipe;
import net.minecraftforge.common.Tags;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

    private final String BLUEPRINT_GROUP = Recipeace.MOD_PREFIX + "blueprints/";

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
                .addCriterion("has_item", hasItem(Items.NETHER_WART))
                .build(consumer);

        ShapelessRecipeBuilder.shapelessRecipe(Items.ROTTEN_FLESH)
                .setGroup(BLUEPRINT_GROUP + "rotten_flesh")
                .addIngredient(Items.BEEF)
                .addIngredient(Items.SUGAR)
                .addIngredient(Tags.Items.MUSHROOMS)
                .addCriterion("has_item", hasItem(Items.BEEF))
                .addCriterion("has_item2", hasItem(Tags.Items.MUSHROOMS))
                .build(consumer);

        ShapelessRecipeBuilder.shapelessRecipe(Items.STRING, 4)
                .setGroup(BLUEPRINT_GROUP + "string")
                .addIngredient(Items.WHITE_WOOL)
                .addCriterion("has_item", hasItem(Items.WHITE_WOOL))
                .build(consumer);

        ShapelessRecipeBuilder.shapelessRecipe(Items.SLIME_BALL, 4)
                .setGroup(BLUEPRINT_GROUP + "slime_ball")
                .addIngredient(Ingredient.fromTag(Tags.Items.MUSHROOMS), 4)
                .addIngredient(Ingredient.fromItems(Items.WATER_BUCKET))
                .addIngredient(Ingredient.fromItems(Items.GREEN_DYE))
                .addCriterion("has_item", hasItem(Tags.Items.MUSHROOMS))
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
                .addCriterion("has_item", hasItem(Items.GOLD_INGOT))
                .build(consumer, ModItems.GOLD_ROD.getId());
    }

    private void registerStoneCutterRecipes(Consumer<IFinishedRecipe> consumer) {
        SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(Items.WHITE_WOOL), Items.STRING, 4)
                .addCriterion("has_item", hasItem(Items.WHITE_WOOL))
                .build(consumer, "string__stonecutter");
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
        CookingRecipeBuilder.cookingRecipe(
                Ingredient.fromItems(Items.COOKED_BEEF),
                Items.ROTTEN_FLESH,
                1.0F,
                200,
                IRecipeSerializer.SMOKING)
                .addCriterion("has_item", hasItem(Items.COOKED_BEEF))
                .build(consumer, "rotten_flesh__smoker");

    }

    private void registerBlastingRecipes(Consumer<IFinishedRecipe> consumer) {
        CookingRecipeBuilder.blastingRecipe(
                Ingredient.fromItems(ModItems.GOLD_ROD.get()),
                Items.BLAZE_ROD,
                1.0F,
                100)
                .addCriterion("has_item", hasItem(ModItems.GOLD_ROD.get()))
                .build(consumer);
    }
}
