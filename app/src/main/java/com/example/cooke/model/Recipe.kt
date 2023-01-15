package com.example.cooke.model

data class Recipe(
    val id: Int,
    val title: String,
    val imageUrl: String?,
    val cookTime: Float,
    val difficulty: String
)
