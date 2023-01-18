package com.example.cooke.ui.recipeInput

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cooke.R
import com.example.cooke.ui.component.InputField
import com.example.cooke.ui.component.InputFieldViewState
import com.example.cooke.ui.recipeInput.mapper.RecipeInputScreenMapper
import com.example.cooke.ui.recipeInput.mapper.RecipeInputScreenMapperImpl
import com.example.cooke.ui.theme.SectionTitle
import com.example.cooke.ui.theme.Spacing

private val RecipeInputViewStateMapper: RecipeInputScreenMapper = RecipeInputScreenMapperImpl()

val RecipeInputViewState = RecipeInputViewStateMapper.toRecipeInputScreenViewState(
    InputFieldViewState("Naziv", "Unesi naziv kolača"),
    InputFieldViewState("Sastojci", "Unesi sve potrebne sastojke"),
    InputFieldViewState("Koraci pripreme", "Unesi korake pripreme"),
    emptyList()
)

@Composable
fun RecipeInputScreenRoute(){
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
fun RecipeInputScreenBody() {
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
        Text(
            text = "Slike",
            style = SectionTitle,
            modifier = Modifier.padding(horizontal = 18.dp),
            color = Color(0xff3f001b)
        )
        Button(
            onClick = { /*TODO*/ },
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

