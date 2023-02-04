package com.example.cooke.ui.recipeInput

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.cooke.R
import com.example.cooke.model.RecipeCategory
import com.example.cooke.ui.component.*
import com.example.cooke.ui.recipeInput.FirebaseExample.saveRecipe
import com.example.cooke.ui.recipeInput.mapper.DropdownMenuViewState
import com.example.cooke.ui.recipeInput.mapper.RecipeInputScreenMapper
import com.example.cooke.ui.recipeInput.mapper.RecipeInputScreenMapperImpl
import com.example.cooke.ui.theme.SectionTitle
import com.example.cooke.ui.theme.Spacing

private val RecipeInputViewStateMapper: RecipeInputScreenMapper = RecipeInputScreenMapperImpl()

val RecipeInputViewState = RecipeInputViewStateMapper.toRecipeInputScreenViewState(
    InputFieldViewState("Naziv", "Unesi naziv kolača", ""),
    InputFieldViewState("Sastojci", "Unesi sve potrebne sastojke", ""),
    InputFieldViewState("Koraci pripreme", "Unesi korake pripreme", ""),
    InputFieldViewState("Vrijeme pripreme", "Unesi vrijeme pripreme", ""),
    DropdownMenuViewState(listOf("Amateur", "Home Chef", "Pro"), ""),
    DropdownMenuViewState(
        listOf(
            RecipeCategory.FRUIT.toString(),
            RecipeCategory.NUTS.toString(),
            RecipeCategory.DRY.toString(),
            RecipeCategory.CREAM.toString(),
            RecipeCategory.COOKIES.toString(),
            RecipeCategory.CAKES.toString()
        ), ""
    ),
    emptyList()
)

@Composable
fun RecipeInputRoute() {
    RecipeInputScreen(InputRecipe())
}

@Composable
fun RecipeInputScreen(inputRecipe: InputRecipe) {
    Scaffold(
        content = { padding ->
            Box(modifier = Modifier.fillMaxSize()) {
                RecipeInputScreenBody(inputRecipe)
                Button(
                    onClick = {
                        inputRecipe.title = RecipeInputViewState.titleInputFieldState.text
                        inputRecipe.ingridients =
                            RecipeInputViewState.ingridientsInputFieldViewState.text.split(",").toList()
                        inputRecipe.duration =
                            RecipeInputViewState.durationInputFieldViewState.text.toFloat()
                        inputRecipe.preparation =
                            RecipeInputViewState.preparationInputFieldViewState.text.split("\n").toList()
                        inputRecipe.isFavorite = false
                        inputRecipe.difficulty =
                            RecipeInputViewState.difficultyDropdownMenuViewState.pickedOption
                        inputRecipe.category =
                            RecipeInputViewState.categoryDropdownMenuViewState.pickedOption
                        saveRecipe(inputRecipe)
                    },
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
    RecipeInputScreen(inputRecipe = InputRecipe())
}

@Composable
fun RecipeInputScreenBody(
    inputRecipe: InputRecipe,
) {
    var selectedImage by remember { mutableStateOf(inputRecipe.imageURI) }
    val galleryLauncher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri ->
            selectedImage = uri.toString()
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
                    dropdownMenuViewState = RecipeInputViewState.difficultyDropdownMenuViewState
                )
            }
            item {
                TitledDropdownMenu(
                    modifier = Modifier,
                    title = "Kategorija",
                    dropdownMenuViewState = RecipeInputViewState.categoryDropdownMenuViewState
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
            onClick = {
                galleryLauncher.launch("image/*")
                inputRecipe.imageURI = selectedImage
            },
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .padding(10.dp)
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
        Image(
            painter = rememberAsyncImagePainter(model = selectedImage),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .padding(bottom = 80.dp)
                .size(200.dp)
                .clip(RoundedCornerShape(10.dp))
        )
    }
    inputRecipe.imageURI = selectedImage
}
