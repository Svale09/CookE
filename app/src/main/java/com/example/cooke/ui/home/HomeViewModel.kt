package com.example.cooke.ui.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cooke.data.repository.RecipeRepository
import com.example.cooke.model.Recipe
import com.example.cooke.model.RecipeCategory
import com.example.cooke.ui.component.RecipeCardViewState
import com.example.cooke.ui.home.mapper.HomeScreenMapper
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class HomeViewModel(
    private val recipeRepository: RecipeRepository,
    private val homeScreenMapper: HomeScreenMapper
) : ViewModel() {

    val data: StateFlow<HomeScreenViewState> = recipeRepository.recipes.map { recipes ->
        homeScreenMapper.toHomeScreenViewState(
            recipeCategories = listOf(
                RecipeCategory.FRUIT,
                RecipeCategory.NUTS,
                RecipeCategory.DRY,
                RecipeCategory.CREAM,
                RecipeCategory.COOKIES,
                RecipeCategory.CAKES
            ),
            recipes = recipes,
            selectedRecipeCategory = RecipeCategory.CHOCOLATE
        )
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        initialValue = HomeScreenViewState(
            recipeCategories = emptyList(),
            recipes = emptyList()
        )
    )


    fun toggleFavorite(recipeCardViewState: RecipeCardViewState) {
        viewModelScope.launch {
            recipeRepository.toggleRecipeFavorite(recipeCardViewState)
        }
    }
}
