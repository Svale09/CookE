package com.example.cooke.ui.recipeInput

data class InputRecipe(
    var title: String = "",
    var difficulty: String = "",
    var ingridients: String = "",
    var preparation: String = "",
    var isFavorite: Boolean = false,
    var duration: String = "",
    var imageURI: String = "",
    var category: String = ""
)
