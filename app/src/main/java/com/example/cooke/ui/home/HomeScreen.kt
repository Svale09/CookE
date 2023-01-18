package com.example.cooke.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
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

val recipeCategoriesViewState = homeScreenMapper.toHomeRecipeCategoryViewState(
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
    onNavigateToRecipeDetails: (HomeRecipeViewState) -> Unit
) {
    var recipeCategories by remember { mutableStateOf(recipeCategoriesViewState) }
}

@Composable
fun HomeScreen(
    recipeCategories: HomeRecipeCategoryViewState,
    onCategoryClick: (RecipeCategoryLabelViewState) -> Unit,
    onNavigateToRecipeDetails: (HomeRecipeViewState) -> Unit,
    padding: Spacing = Spacing()
) {

}

@Composable
fun HomeScreenCategoryList(
    categories: HomeRecipeCategoryViewState,
    onCategoryClick: (RecipeCategoryLabelViewState) -> Unit
) {
    LazyRow(
        modifier = Modifier.padding(horizontal = Spacing().medium, vertical = Spacing().small),
        horizontalArrangement = Arrangement.spacedBy(Spacing().large)
    ) {
        items(categories.recipeCategories.count()) { item ->
            RecipeCategoryLabel(
                categoryLabelViewState = recipeCategoriesViewState.recipeCategories[item],
                modifier = Modifier,
                onClick = onCategoryClick
            )
        }
    }
}

@Composable
fun HomeScreenCategoryRecipeList(
    movieCategory: HomeRecipeCategoryViewState,
    onFavoriteToggle: (Boolean) -> Unit,
    onNavigateToRecipeDetails: (HomeRecipeViewState) -> Unit
) {
    val recipes = recipeCategoriesViewState.recipes
    LazyRow(modifier = Modifier.padding(Spacing().small)) {
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
