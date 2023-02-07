package com.example.cooke.ui.main.di

import com.example.cooke.ui.home.HomeViewModel
import com.example.cooke.ui.recipeInput.RecipeInputScreen
import com.example.cooke.ui.recipeInput.RecipeInputViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainScreenModule = module {
    viewModel {
        RecipeInputViewModel(
            recipeRepository = get()
        )
        HomeViewModel(
            recipeRepository = get(),
            homeScreenMapper = get()
        )
        RecipeInputViewModel(
            recipeRepository = get()
        )
    }
}
