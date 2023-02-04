package com.example.cooke.ui.recipeDetails.mapper

import com.example.cooke.model.Recipe
import com.example.cooke.ui.recipeDetails.RecipeDetailsViewState

class RecipeDetailsMapperImpl : RecipeDetailsMapper {
    override fun toRecipeDetailsViewStateMapper(recipe: Recipe) = RecipeDetailsViewState(
        id = recipe.id,
        title = recipe.title,
        imageUrl = recipe.imageUrl,
        ingridients = recipe.ingridients,
        preparationTime = recipe.preparationTime,
        preparation = recipe.preparation,
        difficulty = recipe.difficulty,
        isFavorite = recipe.isFavorite
    )
}
