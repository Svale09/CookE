package com.example.cooke.ui.home

import com.example.cooke.ui.component.RecipeCardViewState
import com.example.cooke.ui.component.RecipeCategoryLabelViewState

data class HomeRecipeCategoryViewState(
    val recipeCategories: List<RecipeCategoryLabelViewState>,
    val recipes: List<RecipeCardViewState>
)
