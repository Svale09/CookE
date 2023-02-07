package com.example.cooke.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cooke.model.RecipeCategory
import com.example.cooke.ui.component.RecipeCard
import com.example.cooke.ui.component.RecipeCardViewState
import com.example.cooke.ui.component.RecipeCategoryLabel
import com.example.cooke.ui.theme.Spacing

@Composable
fun HomeRoute(
    onNavigateToRecipeDetails: (String) -> Unit,
    homeViewModel: HomeViewModel
) {
    val homeScreenViewState: HomeScreenViewState by homeViewModel.data.collectAsState()
    HomeScreen(
        homeScreenViewState = homeScreenViewState,
        onNavigateToRecipeDetails = onNavigateToRecipeDetails,
        onFavoriteToggle = { recipe -> homeViewModel.toggleFavorite(recipe) },
        onCategoryClick = {category:RecipeCategory -> homeViewModel.changeCategory(category)}
    )
}

@Composable
fun HomeScreen(
    homeScreenViewState: HomeScreenViewState,
    onNavigateToRecipeDetails: (String) -> Unit,
    onFavoriteToggle: (RecipeCardViewState) -> Unit,
    onCategoryClick: (RecipeCategory) -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = { padding ->
            HomeScreenBody(
                homeScreenViewState = homeScreenViewState,
                onNavigateToRecipeDetails = onNavigateToRecipeDetails,
                onFavoriteToggle = onFavoriteToggle,
                onCategoryClick = onCategoryClick
            )
        }
    )
}

/*@Preview
@Composable
private fun HomescreenPreview() {
    HomeScreen(
        homeScreenViewState = recipesByCategoryViewState,
        onNavigateToRecipeDetails = {},
        onCategoryClick = {},
        onFavoriteToggle = {}
    )
}*/

@Composable
fun HomeScreenBody(
    homeScreenViewState: HomeScreenViewState,
    onCategoryClick: (RecipeCategory) -> Unit,
    onNavigateToRecipeDetails: (String) -> Unit,
    onFavoriteToggle: (RecipeCardViewState) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .heightIn(2000.dp)
    ) {
        HomeScreenCategoryList(
            homeScreenViewState = homeScreenViewState,
            onCategoryClick = onCategoryClick
        )
        HomeScreenCategoryRecipeList(
            recipes = homeScreenViewState.recipes,
            onNavigateToRecipeDetails = onNavigateToRecipeDetails,
            onFavoriteToggle = onFavoriteToggle
        )
    }
}

/*@Preview
@Composable
private fun HomeScreenBodyPreview() {
    HomeScreenBody(
        homeScreenViewState = recipesByCategoryViewState,
        onCategoryClick = {},
        onNavigateToRecipeDetails = {},
        onFavoriteToggle = {}
    )
}*/

@Composable
fun HomeScreenCategoryList(
    homeScreenViewState: HomeScreenViewState,
    onCategoryClick: (RecipeCategory) -> Unit
) {
    LazyRow(
        modifier = Modifier
            .padding(vertical = Spacing().small)
            .fillMaxWidth(),
    ) {
        items(homeScreenViewState.recipeCategories.count()) { item ->
            RecipeCategoryLabel(
                categoryLabelViewState = homeScreenViewState.recipeCategories[item],
                modifier = Modifier.padding(horizontal = Spacing().small),
                onClick = onCategoryClick
            )
        }
    }
}

/*@Preview
@Composable
private fun HomeScreenCategoryListPreview() {
    HomeScreenCategoryList(homeScreenViewState = recipesByCategoryViewState, onCategoryClick = {})
}*/

@Composable
fun HomeScreenCategoryRecipeList(
    recipes: List<RecipeCardViewState>,
    onFavoriteToggle: (RecipeCardViewState) -> Unit,
    onNavigateToRecipeDetails: (String) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(recipes.count()) { item ->
            RecipeCard(
                recipeCardViewState = recipes[item],
                onNavigateToRecipeDetails = onNavigateToRecipeDetails,
                onFavoriteToggle = onFavoriteToggle,
                modifier = Modifier
                    .height(200.dp)
                    .width(180.dp)
            )
        }
    }
}

/*@Preview
@Composable
private fun HomeScreenCategoryRecipeListPreview() {
    HomeScreenCategoryRecipeList(
        recipes = recipesByCategoryViewState.recipes,
        onFavoriteToggle = {},
        onNavigateToRecipeDetails = {}
    )
}*/
