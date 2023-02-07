package com.example.cooke.ui.recipeDetails

data class RecipeDetailsViewState(
    val id: String,
    val title: String,
    val imageUrl: String,
    val ingridients: List<String>,
    val preparation: List<String>,
    val difficulty: String,
    val preparationTime: Double,
    val isFavorite: Boolean
)
