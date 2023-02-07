package com.example.cooke.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.cooke.data.database.RecipeDao
import com.example.cooke.model.Recipe
import com.example.cooke.model.RecipeCategory
import com.example.cooke.ui.component.RecipeCardViewState
import com.example.cooke.ui.recipeInput.InputRecipe
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext

class RecipeRepositoryImpl(
    private val recipeDao: RecipeDao,
    private val bgDispatcher: CoroutineDispatcher
) : RecipeRepository {
    override val recipes: Flow<List<Recipe>> = recipeDao.getRecipes()

    override fun getFavorites(): Flow<List<Recipe>> =
        recipes.map { it.filter { recipe -> recipe.isFavorite } }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun recipesByCategory(category: RecipeCategory): Flow<List<Recipe>> =
        recipes.mapLatest {
            when (category) {
                RecipeCategory.CHOCOLATE -> it.filter { recipe -> recipe.category == "CHOCOLATE" }
                RecipeCategory.COOKIES -> it.filter { recipe -> recipe.category == "COOKIES" }
                RecipeCategory.CREAM -> it.filter { recipe -> recipe.category == "CREAM" }
                RecipeCategory.CAKES -> it.filter { recipe -> recipe.category == "CAKES" }
                RecipeCategory.DRY -> it.filter { recipe -> recipe.category == "DRY" }
                RecipeCategory.FRUIT -> it.filter { recipe -> recipe.category == "FRUIT" }
                RecipeCategory.NUTS -> it.filter { recipe -> recipe.category == "NUTS" }
                else -> it
            }
        }

    override fun recipeById(recipeId: String): Flow<Recipe> = recipeDao.getRecipeById(recipeId)

    override suspend fun addRecipe(inputRecipe: InputRecipe) {
        withContext(bgDispatcher) {
            recipeDao.insertRecipe(inputRecipe)
        }
    }

    override suspend fun deleteRecipe(recipe: Recipe) {
        withContext(bgDispatcher) {
            recipeDao.removeRecipe(recipe.id)
        }
    }

    override suspend fun toggleRecipeFavorite(recipeCardViewState: RecipeCardViewState) {
        withContext(bgDispatcher) {
            recipeDao.toggleIsFavorite(recipeCardViewState.id, recipeCardViewState.isFavorite)
        }
    }
}
