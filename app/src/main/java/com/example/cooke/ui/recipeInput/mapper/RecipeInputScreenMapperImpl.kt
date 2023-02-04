package com.example.cooke.ui.recipeInput.mapper

import android.media.Image
import com.example.cooke.ui.component.InputFieldViewState
import com.example.cooke.ui.recipeInput.RecipeInputScreenViewState

class RecipeInputScreenMapperImpl : RecipeInputScreenMapper {
    override fun toRecipeInputScreenViewState(
        titleInputFieldViewState: InputFieldViewState,
        ingridientsInputFieldViewState: InputFieldViewState,
        preparationInputFieldViewState: InputFieldViewState,
        durationInputFieldViewState: InputFieldViewState,
        difficultyDropdownMenuViewState: DropdownMenuViewState,
        categoryDropdownMenuViewState: DropdownMenuViewState,
        images: List<Image>
    ) = RecipeInputScreenViewState(
        InputFieldViewState(
            titleInputFieldViewState.title,
            titleInputFieldViewState.placeholder,
            ""
        ),
        InputFieldViewState(
            ingridientsInputFieldViewState.title,
            ingridientsInputFieldViewState.placeholder,
            ""
        ),
        InputFieldViewState(
            preparationInputFieldViewState.title,
            preparationInputFieldViewState.placeholder,
            ""
        ),
        InputFieldViewState(
            durationInputFieldViewState.title,
            durationInputFieldViewState.placeholder,
            ""
        ),
        DropdownMenuViewState(difficultyDropdownMenuViewState.options, ""),
        DropdownMenuViewState(categoryDropdownMenuViewState.options, ""),
        emptyList()
    )
}
