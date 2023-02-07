package com.example.cooke.ui.favorites

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.cooke.mock.RecipesMock
import com.example.cooke.ui.component.RecipeCard
import com.example.cooke.ui.component.RecipeCardViewState
import com.example.cooke.ui.favorites.di.favoritesModule
import com.example.cooke.ui.favorites.mapper.FavoritesMapper
import com.example.cooke.ui.favorites.mapper.FavoritesMapperImpl
import com.example.cooke.ui.theme.CustomHeader
import com.example.cooke.ui.theme.Spacing

@Composable
fun FavoritesRoute(
    onNavigateToRecipeDetails: (String) -> Unit,
    favoritesViewModel: FavoritesViewModel,
) {

    val favorites: FavoritesViewState by favoritesViewModel.favorites.collectAsState()

    FavoritesScreen(
        favorites = favorites,
        onNavigateToRecipeDetails,
        onToggleFavoriteButton = { recipeCardViewState: RecipeCardViewState ->
            favoritesViewModel.toggleFavorite(recipeCardViewState)
        })
}

@Composable
fun FavoritesScreen(
    favorites: FavoritesViewState,
    onNavigateToRecipeDetails: (String) -> Unit,
    onToggleFavoriteButton: (RecipeCardViewState) -> Unit
) {
    Scaffold(
        content = { padding ->
            FavoritesBody(
                favouriteRecipesViewState = favorites,
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
    onNavigateToRecipeDetails: (String) -> Unit,
    onToggleFavoriteButton: (RecipeCardViewState) -> Unit,
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
    FavoritesScreen(
        onNavigateToRecipeDetails = {},
        onToggleFavoriteButton = {},
        favorites = FavoritesViewState(
            emptyList()
        )
    )
}
