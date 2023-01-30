package com.example.cooke.ui.recipeInput

import android.media.Image
import com.example.cooke.ui.component.InputFieldViewState

data class RecipeInputScreenViewState(
    val titleInputFieldState: InputFieldViewState,
    val ingridientsInputFieldViewState: InputFieldViewState,
    val preparationInputFieldViewState: InputFieldViewState,
    val durationInputFieldViewState: InputFieldViewState,
    val difficultyInputFieldViewState: InputFieldViewState,
    val images: List<Image>
)
