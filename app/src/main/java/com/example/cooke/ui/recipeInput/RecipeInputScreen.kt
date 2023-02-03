package com.example.cooke.ui.recipeInput

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cooke.R
import com.example.cooke.model.RecipeCategory
import com.example.cooke.ui.component.InputField
import com.example.cooke.ui.component.InputFieldViewState
import com.example.cooke.ui.component.NumberInputField
import com.example.cooke.ui.recipeInput.mapper.DropdownMenuViewState
import com.example.cooke.ui.recipeInput.mapper.RecipeInputScreenMapper
import com.example.cooke.ui.recipeInput.mapper.RecipeInputScreenMapperImpl
import com.example.cooke.ui.theme.SectionTitle
import com.example.cooke.ui.theme.Spacing
import com.example.cooke.ui.component.DropdownMenu

private val RecipeInputViewStateMapper: RecipeInputScreenMapper = RecipeInputScreenMapperImpl()

val RecipeInputViewState = RecipeInputViewStateMapper.toRecipeInputScreenViewState(
    InputFieldViewState("Naziv", "Unesi naziv kolača", ""),
    InputFieldViewState("Sastojci", "Unesi sve potrebne sastojke", ""),
    InputFieldViewState("Koraci pripreme", "Unesi korake pripreme", ""),
    InputFieldViewState("Vrijeme pripreme", "Unesi vrijeme pripreme", ""),
    DropdownMenuViewState(listOf("Amateur", "Home Chef", "Pro")),
    emptyList()
)

data class inputRecipe(
    var title: String,
    var difficulty: String,
    var ingridients: List<String>,
    var preparation: List<String>,
    val isFavorite: Boolean,
    val preparationTime: Float,
)

@Composable
fun RecipeInputRoute() {
    RecipeInputScreen()
}

@Composable
fun RecipeInputScreen() {
    Scaffold(
        content = { padding ->
            Box(modifier = Modifier.fillMaxSize()) {
                RecipeInputScreenBody()
                Button(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                        .padding(Spacing().small),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xfff06292))
                ) {
                    Text(
                        text = "Dodaj recept",
                        modifier = Modifier.padding(10.dp),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
        })
}


@Preview
@Composable
private fun RecipeInputScreenPreview() {
    RecipeInputScreen()
}

@Composable
fun RecipeInputScreenBody(
    /*onSaveRecipe: (Recipe) -> Unit*/
) {
    var chosenDifficulty: String
    var expanded by remember {
        mutableStateOf(false)
    }
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .verticalScroll(state = scrollState)
            .fillMaxHeight(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceBetween
    )
    {
        InputField(
            inputFieldViewState = RecipeInputViewState.titleInputFieldState,
            modifier = Modifier.padding(vertical = 6.dp)
        )
        InputField(
            inputFieldViewState = RecipeInputViewState.ingridientsInputFieldViewState,
            modifier = Modifier.padding(vertical = 6.dp)
        )
        InputField(
            inputFieldViewState = RecipeInputViewState.preparationInputFieldViewState,
            modifier = Modifier.padding(vertical = 6.dp)
        )
        NumberInputField(
            inputFieldViewState = RecipeInputViewState.durationInputFieldViewState,
            modifier = Modifier.padding(vertical = 6.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            userScrollEnabled = false,
            modifier = Modifier.heightIn(max = 300.dp)
        ) {
            item {
                TitledDropdownMenu(
                    modifier = Modifier,
                    title = "Težina pripreme",
                    pickOptions = RecipeInputViewState.difficultyDropdownMenuViewState.options
                )
            }
            item {
                TitledDropdownMenu(
                    modifier = Modifier,
                    title = "Kategorija",
                    pickOptions = listOf(
                        RecipeCategory.FRUIT.toString(),
                        RecipeCategory.NUTS.toString(),
                        RecipeCategory.DRY.toString(),
                        RecipeCategory.CREAM.toString(),
                        RecipeCategory.COOKIES.toString(),
                        RecipeCategory.CAKES.toString()
                    )
                )
            }
        }
        Text(
            text = "Slike",
            style = SectionTitle,
            modifier = Modifier.padding(horizontal = 18.dp),
            color = Color(0xff3f001b)
        )
        Button(
            onClick = { },
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .padding(end = 10.dp, start = 10.dp, top = 10.dp, bottom = 80.dp)
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xfff3dde1)),
            content = {
                Row(
                    modifier = Modifier.wrapContentWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_plus),
                        contentDescription = "Plus icon",
                        modifier = Modifier.padding(4.dp)
                    )
                    Text(
                        text = "Dodaj slike",
                        color = Color(0xff3f001b),
                        modifier = Modifier.padding(4.dp),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        )
    }
}

@Composable
fun TitledDropdownMenu(
    modifier: Modifier,
    title: String,
    pickOptions: List<String>
) {
    Column(modifier = modifier) {
        Text(
            text = title,
            style = SectionTitle,
            modifier = Modifier.padding(horizontal = 18.dp),
            color = Color(0xff3f001b)
        )
        DropdownMenu(
            items = pickOptions,
            modifier = Modifier.padding(vertical = 6.dp)
        )
    }
}

@Preview
@Composable
private fun TitledDropdownMenuPreview() {
    TitledDropdownMenu(modifier = Modifier, "", listOf(""))
}
