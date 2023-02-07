package com.example.cooke.data.database

import com.example.cooke.model.Recipe
import com.example.cooke.ui.recipeInput.InputRecipe
import kotlinx.coroutines.flow.Flow

interface RecipeDao {
    fun getRecipes(): Flow<List<Recipe>>
    fun getRecipesByCategory(category: String): Flow<List<Recipe>>
    fun insertRecipe(inputRecipe: InputRecipe)
    fun removeRecipe(recipeId: String)
    fun toggleIsFavorite(recipeId: String, isFavorite: Boolean)
}
