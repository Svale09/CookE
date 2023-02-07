package com.example.cooke.ui.recipeDetails.di

import com.example.cooke.ui.recipeDetails.RecipeDetailsViewModel
import com.example.cooke.ui.recipeInput.RecipeInputViewModel
import org.koin.androidx.compose.get
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val recipeDetailsModule = module {
    viewModel { (recipeId: String) ->
        RecipeDetailsViewModel(
            recipeRepository = get(),
            recipeId = recipeId
        )
    }
}
