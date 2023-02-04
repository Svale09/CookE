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
import com.example.cooke.model.RecipeCategory
import com.example.cooke.ui.component.RecipeCard
import com.example.cooke.ui.component.RecipeCardViewState
import com.example.cooke.ui.component.RecipeCategoryLabel
import com.example.cooke.ui.component.RecipeCategoryLabelViewState
import com.example.cooke.ui.home.mapper.HomeScreenMapper
import com.example.cooke.ui.home.mapper.HomeScreenMapperImpl
import com.example.cooke.ui.theme.Spacing

private val homeScreenMapper: HomeScreenMapper = HomeScreenMapperImpl()

val recipesByCategoryViewState = homeScreenMapper.toHomeRecipeCategoryViewState(
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
    onNavigateToRecipeDetails: (RecipeCardViewState) -> Unit
) {
    var recipesByCategory by remember { mutableStateOf(recipesByCategoryViewState) }
    HomeScreen(
        recipeCategories = recipesByCategory,
        onNavigateToRecipeDetails = onNavigateToRecipeDetails,
        onCategoryClick = {
            when (it.itemId) {
                RecipeCategory.FRUIT.ordinal,
                RecipeCategory.NUTS.ordinal,
                RecipeCategory.DRY.ordinal,
                RecipeCategory.CREAM.ordinal,
                RecipeCategory.COOKIES.ordinal,
                RecipeCategory.CAKES.ordinal -> recipesByCategory =
                    homeScreenMapper.toHomeRecipeCategoryViewState(
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
        onFavoriteToggle = {}
    )
}

@Composable
fun HomeScreen(
    recipeCategories: HomeRecipeCategoryViewState,
    onNavigateToRecipeDetails: (RecipeCardViewState) -> Unit,
    onFavoriteToggle: (Boolean) -> Unit,
    onCategoryClick: (RecipeCategoryLabelViewState) -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = { padding ->
            HomeScreenBody(
                recipeCategories = recipeCategories,
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
        recipeCategories = recipesByCategoryViewState,
        onNavigateToRecipeDetails = {},
        onCategoryClick = {},
        onFavoriteToggle = {}
    )
}

@Composable
fun HomeScreenBody(
    recipeCategories: HomeRecipeCategoryViewState,
    onCategoryClick: (RecipeCategoryLabelViewState) -> Unit,
    onNavigateToRecipeDetails: (RecipeCardViewState) -> Unit,
    onFavoriteToggle: (Boolean) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .heightIn(2000.dp)
    ) {
        HomeScreenCategoryList(
            categories = recipesByCategoryViewState,
            onCategoryClick = onCategoryClick
        )
        HomeScreenCategoryRecipeList(
            recipeCategory = recipeCategories,
            onNavigateToRecipeDetails = onNavigateToRecipeDetails,
            onFavoriteToggle = onFavoriteToggle
        )
    }
}

@Preview
@Composable
private fun HomeScreenBodyPreview() {
    HomeScreenBody(
        recipeCategories = recipesByCategoryViewState,
        onCategoryClick = {},
        onNavigateToRecipeDetails = {},
        onFavoriteToggle = {}
    )
}

@Composable
fun HomeScreenCategoryList(
    categories: HomeRecipeCategoryViewState,
    onCategoryClick: (RecipeCategoryLabelViewState) -> Unit
) {
    LazyRow(
        modifier = Modifier
            .padding(vertical = Spacing().small)
            .fillMaxWidth(),
    ) {
        items(categories.recipeCategories.count()) { item ->
            RecipeCategoryLabel(
                categoryLabelViewState = recipesByCategoryViewState.recipeCategories[item],
                modifier = Modifier.padding(horizontal = Spacing().small),
                onClick = onCategoryClick
            )
        }
    }
}

@Preview
@Composable
private fun HomeScreenCategoryListPreview() {
    HomeScreenCategoryList(categories = recipesByCategoryViewState, onCategoryClick = {})
}

@Composable
fun HomeScreenCategoryRecipeList(
    recipeCategory: HomeRecipeCategoryViewState,
    onFavoriteToggle: (Boolean) -> Unit,
    onNavigateToRecipeDetails: (RecipeCardViewState) -> Unit
) {
    val recipes = recipeCategory.recipes
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(recipes.count()) { item ->
            RecipeCard(
                recipeCardViewState = RecipeCardViewState(
                    id = recipes[item].id,
                    title = recipes[item].title,
                    imageUrl = recipes[item].imageUrl,
                    isFavorite = recipes[item].isFavorite
                ),
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
        recipeCategory = recipesByCategoryViewState,
        onFavoriteToggle = {},
        onNavigateToRecipeDetails = {}
    )
}
