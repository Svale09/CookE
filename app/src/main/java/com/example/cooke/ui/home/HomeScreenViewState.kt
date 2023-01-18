package com.example.cooke.ui.home

import com.example.cooke.ui.component.RecipeCategoryLabelViewState

data class HomeRecipeViewState(
    val id: Int,
    val title: String,
    val imageUrl: String?,
    val isFavorite: Boolean
)

data class HomeRecipeCategoryViewState(
    val recipeCategories: List<RecipeCategoryLabelViewState>,
    val recipes: List<HomeRecipeViewState>
)
