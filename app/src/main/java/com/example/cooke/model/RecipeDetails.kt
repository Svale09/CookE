package com.example.cooke.model

data class Recipe(
    val id: String,
    val title: String,
    val category: String,
    val imageURI: String,
    val difficulty: String,
    val ingridients: List<String>,
    val preparation: List<String>,
    val duration: Double,
    val isFavorite: Boolean
)
