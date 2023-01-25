package com.example.cooke.ui.home.mapper

import com.example.cooke.model.Recipe
import com.example.cooke.model.RecipeCategory
import com.example.cooke.ui.home.HomeRecipeCategoryViewState

interface HomeScreenMapper {
    fun toHomeRecipeCategoryViewState(
        recipeCategories: List<RecipeCategory>,
        selectedRecipeCategory: RecipeCategory,
        recipes: List<Recipe>
    ): HomeRecipeCategoryViewState
}
