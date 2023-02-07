package com.example.cooke.ui.home.di

import com.example.cooke.ui.home.HomeViewModel
import com.example.cooke.ui.home.mapper.HomeScreenMapper
import com.example.cooke.ui.home.mapper.HomeScreenMapperImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    viewModel {
        HomeViewModel(
            recipeRepository = get(),
            homeScreenMapper = get()
        )
    }
    single <HomeScreenMapper>{ HomeScreenMapperImpl() }
}
