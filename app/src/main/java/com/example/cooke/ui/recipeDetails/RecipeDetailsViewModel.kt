package com.example.cooke.ui.recipeDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cooke.data.repository.RecipeRepository
import com.example.cooke.model.Recipe
import com.example.cooke.ui.component.RecipeCardViewState
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class RecipeDetailsViewModel(
    private val recipeRepository: RecipeRepository,
    recipeId: String
) : ViewModel() {

    val recipe: StateFlow<Recipe> = recipeRepository.recipeById(recipeId).stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        Recipe("", "", "", "", "", emptyList(), emptyList(), 0.0, false)
    )

    fun toggleFavorite(recipeCardViewState: RecipeCardViewState) {
        viewModelScope.launch {
            recipeRepository.toggleRecipeFavorite(recipeCardViewState)
        }
    }
}
