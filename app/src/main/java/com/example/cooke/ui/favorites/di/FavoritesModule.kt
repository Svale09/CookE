package com.example.cooke.ui.favorites.di

import com.example.cooke.ui.favorites.FavoritesViewModel
import com.example.cooke.ui.favorites.mapper.FavoritesMapper
import com.example.cooke.ui.favorites.mapper.FavoritesMapperImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val favoritesModule = module {
    viewModel {
        FavoritesViewModel(
            recipeRepository = get(),
            favoritesMapper = get()
        )
    }
    single <FavoritesMapper>{ FavoritesMapperImpl() }
}
