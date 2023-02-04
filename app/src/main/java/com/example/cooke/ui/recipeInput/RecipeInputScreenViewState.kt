package com.example.cooke.ui.recipeInput

import android.media.Image
import com.example.cooke.ui.component.InputFieldViewState
import com.example.cooke.ui.recipeInput.mapper.DropdownMenuViewState

data class RecipeInputScreenViewState(
    val titleInputFieldState: InputFieldViewState,
    val ingridientsInputFieldViewState: InputFieldViewState,
    val preparationInputFieldViewState: InputFieldViewState,
    val durationInputFieldViewState: InputFieldViewState,
    val difficultyDropdownMenuViewState: DropdownMenuViewState,
    val categoryDropdownMenuViewState: DropdownMenuViewState,
    val images: List<Image>
)
