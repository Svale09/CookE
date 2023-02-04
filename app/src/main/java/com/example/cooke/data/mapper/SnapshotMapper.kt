package com.example.cooke.data.mapper

import com.example.cooke.model.Recipe
import com.google.firebase.firestore.QuerySnapshot

interface SnapshotMapper {
    fun mapToRecipe(snapshot: QuerySnapshot): List<Recipe>
}
