package com.example.cooke.ui.recipeInput

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.cooke.data.repository.RecipeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.internal.LockFreeLinkedListNode
import kotlinx.coroutines.launch

class RecipeInputViewModel(
    private val recipeRepository: RecipeRepository,
) : ViewModel() {
    var inputRecipe by mutableStateOf(InputRecipe())
        private set

    fun onTitleChange(title: String) {
        inputRecipe = inputRecipe.copy(title = title)
    }

    fun onDifficultyChange(difficulty: String) {
        inputRecipe = inputRecipe.copy(difficulty = difficulty)
    }

    fun onIngridientsChange(ingridients: String) {
        inputRecipe = inputRecipe.copy(ingridients = ingridients)
    }

    fun onPreparationChange(preparation: String) {
        inputRecipe = inputRecipe.copy(preparation = preparation)
    }

    fun onDurationChange(duration: String) {
        inputRecipe = inputRecipe.copy(duration = duration)
    }

    fun onImageURIChange(imageURI: String) {
        inputRecipe = inputRecipe.copy(imageURI = imageURI)
    }

    fun onCateogryChange(category: String) {
        inputRecipe = inputRecipe.copy(category = category)
    }

    fun addRecipe() {
        viewModelScope.launch {
            recipeRepository.addRecipe(inputRecipe)
        }
    }
}
