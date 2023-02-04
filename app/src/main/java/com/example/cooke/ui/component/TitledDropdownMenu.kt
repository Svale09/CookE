package com.example.cooke.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cooke.ui.recipeInput.RecipeInputViewState
import com.example.cooke.ui.recipeInput.mapper.DropdownMenuViewState
import com.example.cooke.ui.theme.SectionTitle

@Composable
fun TitledDropdownMenu(
    modifier: Modifier,
    title: String,
    dropdownMenuViewState: DropdownMenuViewState
) {
    Column(modifier = modifier) {
        Text(
            text = title,
            style = SectionTitle,
            modifier = Modifier.padding(horizontal = 18.dp),
            color = Color(0xff3f001b)
        )
        DropdownMenu(
            dropdownMenuViewState = dropdownMenuViewState,
            modifier = Modifier.padding(vertical = 6.dp),
        )
    }
}

@Preview
@Composable
private fun TitledDropdownMenuPreview() {
    TitledDropdownMenu(modifier = Modifier, "", RecipeInputViewState.categoryDropdownMenuViewState)
}
