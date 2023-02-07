package com.example.cooke.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cooke.R
import com.example.cooke.model.Recipe

@Composable
fun FavouriteButton(
    recipeCardViewState: RecipeCardViewState,
    modifier: Modifier = Modifier,
    onFavouriteToggle: (RecipeCardViewState) -> Unit = { },
) {
    Box(
        modifier
            .padding(5.dp)
            .size(37.dp)
            .clip(shape = CircleShape)
            .background(Color(0xFFF06292).copy(alpha = 0.6F))
            .clickable {
                onFavouriteToggle(recipeCardViewState)
            },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(
                id = if (recipeCardViewState.isFavorite) R.drawable.favuoirte_icon_selected else R.drawable.favourite_icon_unselected
            ),
            contentDescription = "Favourite Icon",
        )
    }
}


/*@Preview
@Composable
private fun PreviewFavouriteButton() {
    FavouriteButton(false)
}*/
