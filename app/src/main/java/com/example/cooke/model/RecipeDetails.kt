package com.example.cooke.model

data class RecipeDetails(
    val id: Int,
    val title: String,
    val imageUrl: String,
    val difficulty: String,
    val ingridients: List<String>,
    val preparation: List<String>,
    val preparationTime: Float,
    val isFavorite: Boolean
)
