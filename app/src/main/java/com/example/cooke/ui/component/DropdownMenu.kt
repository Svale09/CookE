package com.example.cooke.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cooke.ui.recipeInput.RecipeInputViewState

@Composable
fun DropdownMenu(items: List<String>, modifier: Modifier) {
    var expanded by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableStateOf(0) }
    Box(
        modifier = modifier
            .padding(horizontal = 10.dp)
            .fillMaxWidth()
            .border(BorderStroke(1.dp, Color.Gray), shape = RoundedCornerShape(15.dp))
    ) {
        Text(
            items[selectedIndex],
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .clickable(onClick = { expanded = true }),
            fontSize = 16.sp
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .background(
                    Color(0xfff3dde1)
                )
                .padding(horizontal = 18.dp)

        ) {
            items.forEachIndexed { index, s ->
                DropdownMenuItem(onClick = {
                    selectedIndex = index
                    expanded = false
                }) {

                    Text(text = s)
                }
            }
        }
    }
}

@Preview
@Composable
private fun DropdownMenuPreview() {
    com.example.cooke.ui.component.DropdownMenu(
        items = RecipeInputViewState.difficultyDropdownMenuViewState.options,
        modifier = Modifier
    )
}
