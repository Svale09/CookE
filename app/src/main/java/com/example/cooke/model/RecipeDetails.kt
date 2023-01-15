package com.example.cooke.model

data class RecipeDetails(
    val title: String,
    val imageUrl: String,
    val difficulty: String,
    val ingridients: String,
    val preparation: List<String>,
    val cookTime: Float
)
