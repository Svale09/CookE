package com.example.cooke.ui.recipeDetails

data class RecipeDetailsViewState(
    val id: Int,
    val title: String,
    val imageUrl: String,
    val ingridients: List<String>,
    val preparation: List<String>,
    val difficulty: String,
    val preparationTime: Float,
    val isFavorite: Boolean
)
