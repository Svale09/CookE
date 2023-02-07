package com.example.cooke.data.di

import com.example.cooke.data.database.RecipeDao
import com.example.cooke.data.database.RecipeDaoImpl
import com.example.cooke.data.mapper.SnapshotMapper
import com.example.cooke.data.mapper.SnapshotMapperImpl
import com.example.cooke.data.repository.RecipeRepository
import com.example.cooke.data.repository.RecipeRepositoryImpl
import com.example.cooke.ui.home.mapper.HomeScreenMapper
import com.example.cooke.ui.home.mapper.HomeScreenMapperImpl
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val dataModule = module {

    single<SnapshotMapper> {
        SnapshotMapperImpl()
    }
    single<RecipeDao> {
        RecipeDaoImpl(snapshotMapper = get())
    }
    single<RecipeRepository> {
        RecipeRepositoryImpl(
            recipeDao = get(),
            bgDispatcher = Dispatchers.IO
        )
    }
}
