package com.example.cooke.ui.favorites.mapper

import com.example.cooke.model.Recipe
import com.example.cooke.ui.favorites.FavoritesViewState

interface FavoritesMapper {
    fun tofavoritesViewState(favoriteRecipes: List<Recipe>): FavoritesViewState
}
