package com.example.cooke.data

import com.example.cooke.mock.RecipesMock
import com.example.cooke.model.Recipe
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class RecipeRepository {
    val recipes: MutableStateFlow<List<Recipe>> = MutableStateFlow( RecipesMock.getRecipesList())

    fun AddRecipe(recipe: Recipe){
        recipes.update { it + recipe }
    }
}
