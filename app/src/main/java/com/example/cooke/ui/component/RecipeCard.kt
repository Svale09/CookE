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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage


data class RecipeCardViewState(
    val title: String,
    val imageUrl: String?,
    val isFavorite: Boolean
)

@Composable
fun RecipeCard(
    recipeCardViewState: RecipeCardViewState,
    modifier: Modifier
) {
    Card(
        modifier
            .size(200.dp, 180.dp)
            .padding(10.dp)
            .clickable { },
        elevation = 10.dp
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),

            )
        {
            AsyncImage(
                //modifier.fillMaxWidth(),
                model = recipeCardViewState.imageUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            FavouriteButton(isFavourite = recipeCardViewState.isFavorite)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(40.dp)
                    .background(Color.White/*(0xF06292).copy(1F)*/)
                    .align(Alignment.BottomCenter),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.padding(5.dp),
                    text = recipeCardViewState.title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview
@Composable
private fun RecipeCardPreview() {
    RecipeCard(
        recipeCardViewState = RecipeCardViewState(
            title = "Mađarica",
            imageUrl = "https://podravkaiovariations.azureedge.net/b592273e-63bb-11eb-a9a0-0242ac120018/v/f2b1f6a6-64bc-11eb-b6c2-0242ac130010/1024x768-f2b21802-64bc-11eb-a115-0242ac130010.webp",
            isFavorite = false,
        ),
        modifier = Modifier
    )
}
