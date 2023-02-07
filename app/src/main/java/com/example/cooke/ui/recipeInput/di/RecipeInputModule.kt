package com.example.cooke.ui.recipeInput.di

import com.example.cooke.ui.recipeInput.RecipeInputViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val recipeInputModule = module {
    viewModel{
        RecipeInputViewModel(
            recipeRepository = get()
        )
    }
}
