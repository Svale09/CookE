package com.example.cooke.ui.favorites.mapper

import com.example.cooke.model.Recipe
import com.example.cooke.ui.component.RecipeCardViewState
import com.example.cooke.ui.favorites.FavoritesViewState

class FavoritesMapperImpl : FavoritesMapper{
    override fun tofavoritesViewState(favoriteRecipes: List<Recipe>) =
        FavoritesViewState(favoritesRecipeViewStates(favoriteRecipes))


    private fun favoritesRecipeViewStates(favoriteRecipes: List<Recipe>) =
        favoriteRecipes.map {
            RecipeCardViewState(
                id = it.id,
                title = it.title,
                imageUrl = it.imageURI,
                isFavorite = it.isFavorite
            )
        }
}
