package com.jonathan.laterthanwolves.datagen;

import com.jonathan.laterthanwolves.LaterThanWolves;
import com.jonathan.laterthanwolves.block.ModBlocks;
import com.jonathan.laterthanwolves.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
  public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
    super(output, registries);
  }

  @Override
  protected void buildRecipes(RecipeOutput recipeOutput) {
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STEEL_BLOCK.get())
        .pattern("BBB")
        .pattern("BBB")
        .pattern("BBB")
        .define('B', ModItems.STEEL_INGOT.get())
        .unlockedBy("has_bismuth", has(ModItems.STEEL_INGOT)).save(recipeOutput);

    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.STEEL_INGOT.get(), 9)
        .requires(ModBlocks.STEEL_BLOCK)
        .unlockedBy("has_bismuth_block", has(ModBlocks.STEEL_BLOCK)).save(recipeOutput);
  }

  protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                    float pExperience, int pCookingTIme, String pGroup) {
    oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
        pExperience, pCookingTIme, pGroup, "_from_smelting");
  }

  protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                    float pExperience, int pCookingTime, String pGroup) {
    oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
        pExperience, pCookingTime, pGroup, "_from_blasting");
  }

  protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                     List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
    for(ItemLike itemlike : pIngredients) {
      SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
          .save(recipeOutput, LaterThanWolves.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
    }
  }
}