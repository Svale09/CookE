package com.example.cooke.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cooke.mock.RecipesMock
import com.example.cooke.model.Recipe
import com.example.cooke.model.RecipeCategory
import com.example.cooke.ui.component.RecipeCard
import com.example.cooke.ui.component.RecipeCardViewState
import com.example.cooke.ui.component.RecipeCategoryLabel
import com.example.cooke.ui.component.RecipeCategoryLabelViewState
import com.example.cooke.ui.home.mapper.HomeScreenMapper
import com.example.cooke.ui.home.mapper.HomeScreenMapperImpl
import com.example.cooke.ui.theme.Spacing

private val homeScreenMapper: HomeScreenMapper = HomeScreenMapperImpl()

val recipesByCategoryViewState = homeScreenMapper.toHomeScreenViewState(
    listOf(
        RecipeCategory.CHOCOLATE,
        RecipeCategory.FRUIT,
        RecipeCategory.NUTS,
        RecipeCategory.DRY,
        RecipeCategory.CREAM,
        RecipeCategory.COOKIES,
        RecipeCategory.CAKES
    ),
    RecipeCategory.CHOCOLATE,
    RecipesMock.getRecipesList()
)

@Composable
fun HomeRoute(
    onNavigateToRecipeDetails: (RecipeCardViewState) -> Unit,
    homeViewModel: HomeViewModel
) {
    val homeScreenViewState: HomeScreenViewState by homeViewModel.data.collectAsState()
    //var recipesByCategory by remember { mutableStateOf(recipesByCategoryViewState) }
    HomeScreen(
        homeScreenViewState = homeScreenViewState,
        onNavigateToRecipeDetails = onNavigateToRecipeDetails,
        onFavoriteToggle = { recipe -> homeViewModel.toggleFavorite(recipe) },
        onCategoryClick = {}
        /*recipeCategories = recipesByCategory,
        onNavigateToRecipeDetails = onNavigateToRecipeDetails,
        onCategoryClick = {
            when (it.itemId) {
                RecipeCategory.FRUIT.ordinal,
                RecipeCategory.NUTS.ordinal,
                RecipeCategory.DRY.ordinal,
                RecipeCategory.CREAM.ordinal,
                RecipeCategory.COOKIES.ordinal,
                RecipeCategory.CAKES.ordinal -> recipesByCategory =
                    homeScreenMapper.toHomeScreenViewState(
                        listOf(
                            RecipeCategory.FRUIT,
                            RecipeCategory.NUTS,
                            RecipeCategory.DRY,
                            RecipeCategory.CREAM,
                            RecipeCategory.COOKIES,
                            RecipeCategory.CAKES
                        ),
                        RecipeCategory.values()[it.itemId],
                        RecipesMock.getRecipesList()
                    )
            }
        },
        onFavoriteToggle = {}*/
    )
}

@Composable
fun HomeScreen(
    homeScreenViewState: HomeScreenViewState,
    onNavigateToRecipeDetails: (RecipeCardViewState) -> Unit,
    onFavoriteToggle: (RecipeCardViewState) -> Unit,
    onCategoryClick: (RecipeCategoryLabelViewState) -> Unit
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

@Preview
@Composable
private fun HomescreenPreview() {
    HomeScreen(
        homeScreenViewState = recipesByCategoryViewState,
        onNavigateToRecipeDetails = {},
        onCategoryClick = {},
        onFavoriteToggle = {}
    )
}

@Composable
fun HomeScreenBody(
    homeScreenViewState: HomeScreenViewState,
    onCategoryClick: (RecipeCategoryLabelViewState) -> Unit,
    onNavigateToRecipeDetails: (RecipeCardViewState) -> Unit,
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

@Preview
@Composable
private fun HomeScreenBodyPreview() {
    HomeScreenBody(
        homeScreenViewState = recipesByCategoryViewState,
        onCategoryClick = {},
        onNavigateToRecipeDetails = {},
        onFavoriteToggle = {}
    )
}

@Composable
fun HomeScreenCategoryList(
    homeScreenViewState: HomeScreenViewState,
    onCategoryClick: (RecipeCategoryLabelViewState) -> Unit
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

@Preview
@Composable
private fun HomeScreenCategoryListPreview() {
    HomeScreenCategoryList(homeScreenViewState = recipesByCategoryViewState, onCategoryClick = {})
}

@Composable
fun HomeScreenCategoryRecipeList(
    recipes: List<RecipeCardViewState>,
    onFavoriteToggle: (RecipeCardViewState) -> Unit,
    onNavigateToRecipeDetails: (RecipeCardViewState) -> Unit
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

@Preview
@Composable
private fun HomeScreenCategoryRecipeListPreview() {
    HomeScreenCategoryRecipeList(
        recipes = recipesByCategoryViewState.recipes,
        onFavoriteToggle = {},
        onNavigateToRecipeDetails = {}
    )
}
