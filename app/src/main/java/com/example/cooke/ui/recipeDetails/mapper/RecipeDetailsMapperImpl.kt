package com.example.cooke.ui.recipeDetails.mapper

import com.example.cooke.model.Recipe
import com.example.cooke.ui.recipeDetails.RecipeDetailsViewState

class RecipeDetailsMapperImpl : RecipeDetailsMapper {
    override fun toRecipeDetailsViewStateMapper(recipe: Recipe) = RecipeDetailsViewState(
        id = recipe.id,
        title = recipe.title,
        imageUrl = recipe.imageURI,
        ingridients = recipe.ingridients,
        preparationTime = recipe.duration,
        preparation = recipe.preparation,
        difficulty = recipe.difficulty,
        isFavorite = recipe.isFavorite
    )
}
