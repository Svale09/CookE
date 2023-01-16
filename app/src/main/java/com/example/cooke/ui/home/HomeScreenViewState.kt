package com.example.cooke.ui.home
data class HomeRecipeViewState(
    val id: Int,
    val title: String,
    val imageUrl: String?
)

data class HomeRecipeCategoryViewState(
    val recipeCategories: List<HomeRecipeCategoryViewState>,
    val recipes: List<HomeRecipeViewState>
)
