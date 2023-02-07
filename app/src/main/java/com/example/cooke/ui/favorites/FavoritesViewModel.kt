package com.example.cooke.ui.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cooke.data.repository.RecipeRepository
import com.example.cooke.ui.component.RecipeCardViewState
import com.example.cooke.ui.favorites.mapper.FavoritesMapper
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class FavoritesViewModel(
    private val recipeRepository: RecipeRepository,
    private val favoritesMapper: FavoritesMapper
) : ViewModel() {
    val favorites: StateFlow<FavoritesViewState> = recipeRepository.getFavorites().map {
        favoritesMapper.tofavoritesViewState(it)
    }.stateIn(
        viewModelScope, SharingStarted.WhileSubscribed(5000),
        FavoritesViewState(emptyList())
    )

    fun toggleFavorite(recipeCardViewState: RecipeCardViewState) {
        viewModelScope.launch {
            recipeRepository.toggleRecipeFavorite(recipeCardViewState)
        }
    }
}
