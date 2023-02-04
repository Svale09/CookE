package com.example.cooke.ui.favorites

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.cooke.mock.RecipesMock
import com.example.cooke.ui.component.RecipeCard
import com.example.cooke.ui.component.RecipeCardViewState
import com.example.cooke.ui.favorites.mapper.FavoritesMapper
import com.example.cooke.ui.favorites.mapper.FavoritesMapperImpl
import com.example.cooke.ui.theme.CustomHeader
import com.example.cooke.ui.theme.Spacing

private val FavoritesViewStateMapper: FavoritesMapper = FavoritesMapperImpl()

val FavoriteRecipesViewState =
    FavoritesViewStateMapper.tofavoritesViewState(RecipesMock.getRecipesList())

@Composable
fun FavoritesRoute(
    onNavigateToRecipeDetails: (RecipeCardViewState) -> Unit,
    onToggleFavoriteButton: (Boolean) -> Unit
) {
    FavoritesScreen(onNavigateToRecipeDetails,onToggleFavoriteButton)
}

@Composable
fun FavoritesScreen(
    onNavigateToRecipeDetails: (RecipeCardViewState) -> Unit,
    onToggleFavoriteButton: (Boolean) -> Unit
) {
    Scaffold(
        content = { padding ->
            FavoritesBody(
                favouriteRecipesViewState = FavoriteRecipesViewState,
                onNavigateToRecipeDetails = onNavigateToRecipeDetails,
                onToggleFavoriteButton = onToggleFavoriteButton,
                padding = Spacing()
            )
        }
    )
}

@Composable
fun FavoritesBody(
    favouriteRecipesViewState: FavoritesViewState,
    onNavigateToRecipeDetails: (RecipeCardViewState) -> Unit,
    onToggleFavoriteButton: (Boolean) -> Unit,
    padding: Spacing
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize(),
        content = {
            item(span = { GridItemSpan(currentLineSpan = maxCurrentLineSpan) }) {
                Text(
                    text = "Favorites",
                    style = CustomHeader,
                    modifier = Modifier.padding(horizontal = Spacing().small)
                )
            }
            items(favouriteRecipesViewState.favoriteRecipes.size) { index ->
                RecipeCard(
                    recipeCardViewState = favouriteRecipesViewState.favoriteRecipes[index],
                    modifier = Modifier,
                    onToggleFavoriteButton,
                    onNavigateToRecipeDetails
                )
            }
        }
    )
}

@Preview
@Composable
private fun FavoritesScreenPreview() {
    FavoritesScreen(onNavigateToRecipeDetails = {}, onToggleFavoriteButton = {})
}
