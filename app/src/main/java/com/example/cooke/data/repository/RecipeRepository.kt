package com.example.cooke.data.repository

import com.example.cooke.model.Recipe
import com.example.cooke.model.RecipeCategory
import com.example.cooke.ui.component.RecipeCardViewState
import com.example.cooke.ui.recipeInput.InputRecipe
import kotlinx.coroutines.flow.Flow


interface RecipeRepository {
    val recipes: Flow<List<Recipe>>

    fun getFavorites() : Flow<List<Recipe>>
    fun recipesByCategory(category: RecipeCategory): Flow<List<Recipe>>
    fun recipeById(recipeId: String): Flow<Recipe>
    suspend fun addRecipe(inputRecipe: InputRecipe)
    suspend fun deleteRecipe(recipe: Recipe)
    suspend fun toggleRecipeFavorite (recipeCardViewState: RecipeCardViewState)
}
