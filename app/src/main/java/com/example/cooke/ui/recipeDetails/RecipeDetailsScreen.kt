package com.example.cooke.ui.recipeDetails

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.example.cooke.mock.RecipesMock
import com.example.cooke.ui.component.FavouriteButton
import com.example.cooke.ui.recipeDetails.mapper.RecipeDetailsMapper
import com.example.cooke.ui.recipeDetails.mapper.RecipeDetailsMapperImpl
import com.example.cooke.ui.theme.CustomHeader
import com.example.cooke.ui.theme.SectionTitle
import com.example.cooke.ui.theme.Spacing

private val RecipeDetailsScreenMapper: RecipeDetailsMapper = RecipeDetailsMapperImpl()

val RecipeDetailsScreenViewState =
    RecipeDetailsScreenMapper.toRecipeDetailsViewStateMapper(RecipesMock.getRecipeDetails())

@Composable
fun RecipeDetailsRoute(
    onFavoriteToggle: (Boolean) -> Unit
) {
    RecipeDetailsScreen(
        recipeDetailsScreenViewState = RecipeDetailsScreenViewState,
        onFavoriteToggle = onFavoriteToggle
    )
}

@Composable
fun RecipeDetailsScreen(
    recipeDetailsScreenViewState: RecipeDetailsViewState,
    onFavoriteToggle: (Boolean) -> Unit
) {
    val scrollState = rememberScrollState()
    Scaffold(
        content = { padding ->
            Column(
                modifier = Modifier
                    .verticalScroll(scrollState)
                    .fillMaxSize()
                    .wrapContentHeight()
                    .padding(Spacing().default)
            ) {
                RecipeDetailsPoster(
                    recipeDetailsScreenViewState = recipeDetailsScreenViewState,
                    onFavoriteToggle = onFavoriteToggle
                )
                IngridientsList(ingridients = recipeDetailsScreenViewState.ingridients)
                InstructionsList(instructions = recipeDetailsScreenViewState.preparation)
            }
        }
    )
}

@Preview
@Composable
private fun RecipeDetailsScreenPreview() {
    RecipeDetailsScreen(
        recipeDetailsScreenViewState = RecipeDetailsScreenViewState,
        onFavoriteToggle = {}
    )
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
            modifier = Modifier.padding(Spacing().small),
            onFavouriteToggle = onFavoriteToggle
        )
        Box(modifier = Modifier
            .constrainAs(info) { bottom.linkTo(image.bottom) }
            .fillMaxWidth()
            .wrapContentHeight()
            .background(
                Brush.verticalGradient(
                    listOf(Color.Transparent, Color.Black),
                    startY = 0f
                )
            )
        ) {

            Column(
                modifier = Modifier
                    .padding(Spacing().medium)
                    .wrapContentHeight(),
                horizontalAlignment = Alignment.Start
            ) {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                )
                Text(
                    text = recipeDetailsScreenViewState.title,
                    style = CustomHeader,
                    color = Color.White
                )
                Row(
                    modifier = Modifier
                        .padding(vertical = Spacing().small)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = painterResource(id = com.example.cooke.R.drawable.clock_icon_white),
                        contentDescription = "Clock icon",
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = recipeDetailsScreenViewState.preparationTime.toString() + "h",
                        color = Color.White
                    )
                }
                Text(
                    text = "Difficulty: " + recipeDetailsScreenViewState.difficulty, //Umjesto teksta će ići ikona
                    color = Color.White
                )
            }
        }
    }
}

@Preview
@Composable
private fun RecipeDetailsPosterPreview() {
    RecipeDetailsPoster(
        recipeDetailsScreenViewState = RecipeDetailsScreenViewState,
        onFavoriteToggle = {})
}

@Composable
fun IngridientsList(
    ingridients: List<String>
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        userScrollEnabled = false,
        modifier = Modifier
            .heightIn(max = 500.dp)
            .padding(top = Spacing().small)
    ) {
        item {
            Text(
                text = "Ingridients",
                style = SectionTitle,
                modifier = Modifier.padding(Spacing().small)
            )
        }
        items(ingridients) {
            Row(Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
                Canvas(
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp)
                        .size(6.dp)
                ) {
                    drawCircle(Color.Black)
                }
                Text(text = it)
            }
        }
    }
}

@Preview
@Composable
private fun IngridientsListPreview() {
    IngridientsList(ingridients = RecipeDetailsScreenViewState.ingridients)
}

@Composable
fun InstructionsList(
    instructions: List<String>
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        userScrollEnabled = false,
        modifier = Modifier
            .heightIn(max = 1000.dp)
            .padding(top = Spacing().small)
    ) {
        item {
            Text(
                text = "Preparation",
                style = SectionTitle,
                modifier = Modifier.padding(Spacing().small)
            )
        }
        items(instructions) {
            Row(Modifier.padding(8.dp)) {
                Text(
                    text = (instructions.indexOf(it) + 1).toString() + ".",
                    modifier = Modifier.padding(end = 4.dp)
                )
                Text(text = it)
            }
        }
    }
}

@Preview
@Composable
private fun InstructionsListPreview() {
    InstructionsList(instructions = RecipeDetailsScreenViewState.preparation)
}



