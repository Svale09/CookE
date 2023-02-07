package com.example.cooke.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.material.Card
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.cooke.model.Recipe


data class RecipeCardViewState(
    val id: String,
    val title: String,
    val imageUrl: String?,
    val isFavorite: Boolean
)

@Composable
fun RecipeCard(
    recipeCardViewState: RecipeCardViewState,
    modifier: Modifier,
    onFavoriteToggle: (RecipeCardViewState) -> Unit,
    onNavigateToRecipeDetails: (String) -> Unit
) {
    Card(
        modifier
            .size(200.dp, 180.dp)
            .padding(10.dp)
            .clickable { onNavigateToRecipeDetails(recipeCardViewState.id) },
        elevation = 10.dp
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),

            )
        {
            AsyncImage(
                model = recipeCardViewState.imageUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )
            FavouriteButton(recipeCardViewState, onFavouriteToggle = onFavoriteToggle)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .background(Color(0xffffd9e1).copy(alpha = 1f))
                    .align(Alignment.BottomCenter),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    modifier = Modifier.padding(vertical = 4.dp, horizontal = 6.dp),
                    text = recipeCardViewState.title,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = Color(0xff3f001b)
                )
            }
        }
    }
}

/*@Preview
@Composable
private fun RecipeCardPreview() {
    RecipeCard(
        recipeCardViewState = RecipeCardViewState(
            id = "1",
            title = "Black forrest gato cake",
            imageUrl = "https://podravkaiovariations.azureedge.net/b592273e-63bb-11eb-a9a0-0242ac120018/v/f2b1f6a6-64bc-11eb-b6c2-0242ac130010/1024x768-f2b21802-64bc-11eb-a115-0242ac130010.webp",
            isFavorite = false,
        ),
        modifier = Modifier,
        {}
    ) {}
}*/
