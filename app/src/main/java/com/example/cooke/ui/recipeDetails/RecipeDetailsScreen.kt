package com.example.cooke.ui.recipeDetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.cooke.mock.RecipesMock
import com.example.cooke.ui.recipeDetails.mapper.RecipeDetailsMapper
import com.example.cooke.ui.recipeDetails.mapper.RecipeDetailsMapperImpl
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.cooke.ui.component.FavouriteButton
import com.example.cooke.ui.theme.Spacing

private val RecipeDetailsScreenMapper: RecipeDetailsMapper = RecipeDetailsMapperImpl()

val RecipeDetailsScreenViewState =
    RecipeDetailsScreenMapper.toRecipeDetailsViewStateMapper(RecipesMock.getRecipeDetails())

@Composable
fun RecipeDetailsRoute() {

}

@Composable
fun RecipeDetailsScreen() {

}

@Composable
fun RecipeDetailsPoster(
    recipeDetailsScreenViewState: RecipeDetailsViewState,
    onFavoriteToggle: (Boolean) -> Unit
) {
    ConstraintLayout {
        val (image, info) = createRefs()
        AsyncImage(
            model = recipeDetailsScreenViewState.imageUrl,
            contentDescription = "Recipe image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(image) {}
                .height(400.dp)
        )
        FavouriteButton(
            isFavourite = recipeDetailsScreenViewState.isFavorite,
            modifier = Modifier.padding(Spacing().medium),
            onFavouriteToggle = onFavoriteToggle
        )
        Box(modifier = Modifier
            .constrainAs(info) {}
            .fillMaxWidth()
            .background(
                Brush.verticalGradient(
                    listOf(Color.Transparent, Color.Black),
                    startY = 0f
                )
            )
        ) {
            Column() {
                Text(text = recipeDetailsScreenViewState.title)
                Row() {
                    Image(
                        painter = painterResource(id = com.example.cooke.R.drawable.preperation_time_icon),
                        contentDescription = "Clock icon"
                    )
                    Text(text = recipeDetailsScreenViewState.preparationTime.toString()+"h")
                }
            }
        }
    }
}

@Preview
@Composable
private fun RecipeDetailsPosterPreview(){
    RecipeDetailsPoster(recipeDetailsScreenViewState = RecipeDetailsScreenViewState, onFavoriteToggle = {})
}



