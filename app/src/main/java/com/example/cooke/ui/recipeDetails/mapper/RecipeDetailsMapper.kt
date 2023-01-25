package com.example.cooke.ui.recipeDetails.mapper

import com.example.cooke.model.RecipeDetails
import com.example.cooke.ui.recipeDetails.RecipeDetailsViewState

interface RecipeDetailsMapper{
    fun toRecipeDetailsViewStateMapper(recipeDetails: RecipeDetails): RecipeDetailsViewState
}
