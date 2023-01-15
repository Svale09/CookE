package com.example.cooke.ui.recipeDetails.mapper

import com.example.cooke.model.RecipeDetails
import com.example.cooke.ui.recipeDetails.RecipeDetailsViewState

class RecipeDetailsMapperImpl : RecipeDetailsMapper {
    override fun toRecipeDetailsViewStateMapper(recipeDetails: RecipeDetails) = RecipeDetailsViewState(
        id = recipeDetails.id,
        title = recipeDetails.title,
        imageUrl = recipeDetails.imageUrl,
        ingridients = recipeDetails.ingridients,
        preparationTime = recipeDetails.preparationTime,
        preparation = recipeDetails.preparation,
        difficulty = recipeDetails.difficulty,
        isFavorite = recipeDetails.isFavorite
    )
}
