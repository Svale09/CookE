package com.example.cooke.ui.recipeInput.FirebaseExample

import com.example.cooke.model.Recipe
import com.example.cooke.model.RecipeDetails
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

private val recipeCollectionRef = Firebase.firestore.collection("recipes")

private fun saveRecipe(recipeDetails: RecipeDetails) = CoroutineScope(Dispatchers.IO).launch {
    try {
        recipeCollectionRef.add(recipeDetails).await()
    } catch (e: Exception){
    }
}
