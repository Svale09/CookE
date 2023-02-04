package com.example.cooke.model

data class Recipe(
    val id: String,
    val title: String,
    val imageURI: String,
    val difficulty: String,
    val ingridients: List<String>,
    val preparation: List<String>,
    val duration: Float,
    val isFavorite: Boolean
)
