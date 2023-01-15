package com.example.cooke.ui.recipeDetails

import androidx.compose.runtime.Composable
import com.example.cooke.mock.RecipesMock
import com.example.cooke.ui.recipeDetails.mapper.RecipeDetailsMapper
import com.example.cooke.ui.recipeDetails.mapper.RecipeDetailsMapperImpl

private val RecipeDetailsScreenMapper: RecipeDetailsMapper = RecipeDetailsMapperImpl()

val RecipeDetailsScreenViewState = RecipeDetailsScreenMapper.toRecipeDetailsViewStateMapper(RecipesMock.getRecipeDetails())

@Composable
fun RecipeDetailsRoute(){

}

@Composable
fun RecipeDetailsScreen(){

}



