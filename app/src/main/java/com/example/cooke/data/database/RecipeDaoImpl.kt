package com.example.cooke.data.database

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.cooke.data.mapper.SnapshotMapper
import com.example.cooke.model.Recipe
import com.example.cooke.ui.component.RecipeCardViewState
import com.example.cooke.ui.recipeInput.InputRecipe
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await

const val RECIPES_COLLECTION = "recipes"

class RecipeDaoImpl(private val snapshotMapper: SnapshotMapper) : RecipeDao {
    private val db = Firebase.firestore
    private val recipeRef = db.collection(RECIPES_COLLECTION)

    override fun getRecipeById(recipeId: String): Flow<Recipe> {
        return callbackFlow {
            recipeRef.document(recipeId).addSnapshotListener { snapshot, error ->
                if (error != null) {
                    cancel()
                    return@addSnapshotListener
                } else if (snapshot != null) {
                    val data = toRecipe(snapshot)
                    trySend(data)
                }
            }
            awaitClose()
        }
    }

    private fun toRecipe(documentSnapshot: DocumentSnapshot): Recipe = Recipe(
        id = documentSnapshot.id,
        title = documentSnapshot["title"] as String,
        imageURI = documentSnapshot["imageURI"] as String,
        ingridients = documentSnapshot["ingridients"] as List<String>,
        preparation = documentSnapshot["preparation"] as List<String>,
        duration = documentSnapshot["duration"] as Double,
        difficulty = documentSnapshot["difficulty"] as String,
        isFavorite = documentSnapshot["isFavorite"] as Boolean,
        category = documentSnapshot["category"] as String
    )

    @RequiresApi(Build.VERSION_CODES.O)
    override fun getRecipes(): Flow<List<Recipe>> {
        return callbackFlow {
            recipeRef.addSnapshotListener { snapshot, error ->
                if (error != null) {
                    cancel()
                    return@addSnapshotListener
                } else if (snapshot != null) {
                    val data = snapshotMapper.mapToRecipe(snapshot)
                    trySend(data)
                }
            }
            awaitClose()
        }
    }

    override fun getRecipesByCategory(category: String): Flow<List<Recipe>> {
        return callbackFlow {
            recipeRef.whereEqualTo("category", category).addSnapshotListener { snapshot, error ->
                if (error != null) {
                    cancel()
                    return@addSnapshotListener
                } else if (snapshot != null) {
                    val data = snapshotMapper.mapToRecipe(snapshot)
                    trySend(data)
                }
            }
            awaitClose()
        }
    }

    override fun insertRecipe(inputRecipe: InputRecipe) {
        val data = hashMapOf(
            "title" to inputRecipe.title,
            "imageURI" to inputRecipe.imageURI,
            "ingridients" to inputRecipe.ingridients.split("\n").toList(),
            "preparation" to inputRecipe.preparation.split("\n").toList(),
            "isFavorite" to inputRecipe.isFavorite,
            "duration" to inputRecipe.duration.toFloat(),
            "difficulty" to inputRecipe.difficulty,
            "category" to inputRecipe.category
        )
        recipeRef.add(data)
    }

    override fun removeRecipe(recipeId: String) {
        recipeRef.document(recipeId).delete()
    }

    override fun toggleIsFavorite(recipeId: String, isFavorite: Boolean) {
        //recipeRef.document().update("isFavorite", !recipe.isFavorite)
        recipeRef.document(recipeId).update("isFavorite", !isFavorite)
    }
}
