package com.example.cooke.data.mapper

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.cooke.model.Recipe
import com.google.firebase.firestore.QuerySnapshot

class SnapshotMapperImpl: SnapshotMapper{
    @RequiresApi(Build.VERSION_CODES.O)
    override fun mapToRecipe(snapshot: QuerySnapshot): List<Recipe> {
        val data = snapshot.documents.map { documentSnapshot ->
            Recipe(
                id = documentSnapshot.id,
                title = documentSnapshot["title"] as String,
                imageURI = documentSnapshot["imageURI"] as String,
                ingridients = documentSnapshot["ingridients"] as List<String>,
                preparation = documentSnapshot["preparation"] as List<String>,
                duration = documentSnapshot["duration"] as Double,
                difficulty = documentSnapshot["difficulty"] as String,
                isFavorite = documentSnapshot["isFavorite"] as Boolean
            )
        }
        return data
    }
}
