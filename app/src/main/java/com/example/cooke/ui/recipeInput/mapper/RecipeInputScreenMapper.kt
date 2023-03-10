package com.example.cooke.ui.recipeInput.mapper

import android.media.Image
import com.example.cooke.ui.component.InputFieldViewState
import com.example.cooke.ui.recipeInput.RecipeInputScreenViewState

interface RecipeInputScreenMapper {
    fun toRecipeInputScreenViewState(
        titleInputFieldViewState: InputFieldViewState,
        ingridientsInputFieldViewState: InputFieldViewState,
        preparationInputFieldViewState: InputFieldViewState,
        durationInputFieldViewState: InputFieldViewState,
        difficultyDropdownMenuViewState: DropdownMenuViewState,
        categoryDropdownMenuViewState: DropdownMenuViewState,
        images: List<Image>
    ): RecipeInputScreenViewState
}
