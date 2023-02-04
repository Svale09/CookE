package com.example.cooke.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.cooke.data.database.RecipeDao
import com.example.cooke.model.Recipe
import com.example.cooke.ui.recipeInput.InputRecipe
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

class RecipeRepositoryImpl(
    private val recipeDao: RecipeDao,
    private val bgDispatcher: CoroutineDispatcher
) : RecipeRepository {
    override val recipes: Flow<List<Recipe>> = recipeDao.getRecipes()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun recipesByCategory(category: String): Flow<List<Recipe>> =
        recipeDao.getRecipesByCategory(category).flowOn(bgDispatcher)

    override suspend fun addRecipe(inputRecipe: InputRecipe) {
        withContext(bgDispatcher){
            recipeDao.insertRecipe(inputRecipe)
        }
    }

    override suspend fun deleteRecipe(recipe: Recipe) {
        withContext(bgDispatcher){
            recipeDao.removeRecipe(recipe.id)
        }
    }

    override suspend fun toggleRecipeFavorite(recipe: Recipe) {
        withContext(bgDispatcher){
            recipeDao.toggleIsFavorite(recipe)
        }
    }
}
