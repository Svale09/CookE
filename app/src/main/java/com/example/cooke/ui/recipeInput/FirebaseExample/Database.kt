package com.example.cooke.ui.recipeInput.FirebaseExample

import android.util.Log
import com.example.cooke.ui.recipeInput.InputRecipe
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

private val recipeCollectionRef = Firebase.firestore.collection("test")

fun saveRecipe(inputRecipe: InputRecipe) = CoroutineScope(Dispatchers.IO).launch {
    try {
        recipeCollectionRef.add(inputRecipe).await()
        withContext(Dispatchers.Main) {
            Log.d("Firebase add", "Success")
        }
    } catch (e: Exception) {
        Log.d("Firebase add", e.message.toString())
    }
}
