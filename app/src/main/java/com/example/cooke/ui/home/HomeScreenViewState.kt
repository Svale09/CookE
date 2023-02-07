package com.example.cooke.ui.home

import com.example.cooke.model.Recipe
import com.example.cooke.ui.component.RecipeCardViewState
import com.example.cooke.ui.component.RecipeCategoryLabelViewState

data class HomeScreenViewState(
    val recipeCategories: List<RecipeCategoryLabelViewState>,
    val recipes: List<RecipeCardViewState>
)
