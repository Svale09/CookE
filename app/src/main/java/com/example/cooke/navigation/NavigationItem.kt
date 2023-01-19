package com.example.cooke.navigation

import com.example.cooke.R
import com.example.cooke.navigation.CookEDestination

const val HOME_ROUTE = "Home"
const val FAVORITES_ROUTE = "Favorites"
const val RECIPE_INPUT_ROUTE = "RecipeInput"

sealed class NavigationItem(
    override val route: String,
    val selectedIconId: Int,
    val unselectedIconId: Int,
    val labelId: Int,
) : CookEDestination(route) {
    object HomeDestination : NavigationItem(
        route = HOME_ROUTE,
        selectedIconId = R.drawable.home_icon_selected,
        unselectedIconId = R.drawable.home_icon_unselected,
        labelId = R.string.home,
    )

    object FavoritesDestination : NavigationItem(
        route = FAVORITES_ROUTE,
        selectedIconId = R.drawable.favuoirte_icon_selected,
        unselectedIconId = R.drawable.favourite_icon_unselected,
        labelId = R.string.favorites,
    )

    object RecipeInputDestination : NavigationItem(
        route = RECIPE_INPUT_ROUTE,
        selectedIconId = R.drawable.icon_plus,
        unselectedIconId = R.drawable.icon_plus,
        labelId = R.string.recipe_input
    )
}
