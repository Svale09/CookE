package com.example.cooke.data.database

import com.example.cooke.model.Recipe
import com.example.cooke.ui.recipeInput.InputRecipe
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.Flow

const val RECIPES_COLLECTION = "recipes"

class RecipeDaoImpl() : RecipeDao {
    private val db = Firebase.firestore
    private val recipeRef = db.collection(RECIPES_COLLECTION)

    override fun getRecipes(): Flow<List<Recipe>> {
        TODO("Not yet implemented")
    }

    override fun getRecipesByCategory(categoryId: String): Flow<List<Recipe>> {
        TODO("Not yet implemented")
    }

    override fun insertRecipe(inputRecipe: InputRecipe) {
        TODO("Not yet implemented")
    }

    override fun removeRecipe(recipeId: String) {
        TODO("Not yet implemented")
    }

    override fun toggleFavoriteRecipe(recipeId: String) {
        TODO("Not yet implemented")
    }
}
