package com.example.cooke.ui.recipeDetails.mapper

import com.example.cooke.model.Recipe
import com.example.cooke.ui.recipeDetails.RecipeDetailsViewState

interface RecipeDetailsMapper{
    fun toRecipeDetailsViewStateMapper(recipe: Recipe): RecipeDetailsViewState
}
