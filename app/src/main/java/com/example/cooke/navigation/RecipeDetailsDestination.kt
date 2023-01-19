package com.example.cooke.navigation

const val RECIPE_DETAILS_ROUTE = "RecipeDetails"
const val RECIPE_ID_KEY = "recipeId"
const val RECIPE_DETAILS_ROUTE_WITH_PARAMS = "$RECIPE_DETAILS_ROUTE/{$RECIPE_ID_KEY}"

object RecipeDetailsDestination : CookEDestination(RECIPE_DETAILS_ROUTE_WITH_PARAMS) {
    fun createNavigationRoute(recipeId: Int): String = "$RECIPE_DETAILS_ROUTE/$recipeId"
}
