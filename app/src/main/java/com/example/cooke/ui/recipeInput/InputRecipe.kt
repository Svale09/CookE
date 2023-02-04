package com.example.cooke.ui.recipeInput

data class InputRecipe(
    var title: String = "",
    var difficulty: String = "",
    var ingridients: List<String> = emptyList(),
    var preparation: List<String> = emptyList(),
    var isFavorite: Boolean = false,
    var duration: Float = -1.toFloat(),
    var imageURI: String = "",
    var category: String = ""
)
