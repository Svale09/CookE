package com.example.cooke.ui.component

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


sealed class RecipeCategoryLabelTextViewState {
    data class CategoryStringParam(val value: String) : RecipeCategoryLabelTextViewState()
    data class CategoryStringResource(@StringRes val value: Int) :
        RecipeCategoryLabelTextViewState()
}

data class RecipeCategoryLabelViewState(
    val itemId: Int,
    val isSelected: Boolean,
    val categoryText: RecipeCategoryLabelTextViewState
)

@Composable
fun RecipeCategoryLabel(
    categoryLabelViewState: RecipeCategoryLabelViewState,
    modifier: Modifier = Modifier,
    onClick: (RecipeCategoryLabelViewState) -> Unit
) {
    Box(modifier = modifier.wrapContentSize()) {
        Column(
            modifier = Modifier
                .width(intrinsicSize = IntrinsicSize.Max)
                .clickable { onClick(categoryLabelViewState) }
        ) {
            Text(
                text = when (categoryLabelViewState.categoryText) {
                    is RecipeCategoryLabelTextViewState.CategoryStringParam -> categoryLabelViewState.categoryText.value
                    is RecipeCategoryLabelTextViewState.CategoryStringResource -> stringResource(id = categoryLabelViewState.categoryText.value)
                },
                fontSize = 16.sp,
                fontWeight = if (categoryLabelViewState.isSelected) FontWeight.Bold else FontWeight.Normal,
                color = if (categoryLabelViewState.isSelected) Color.Black else Color.Gray,
            )
            Spacer(modifier = Modifier.height(4.dp))
            if (categoryLabelViewState.isSelected) {
                Box(
                    modifier = Modifier
                        .height(3.dp)
                        .fillMaxWidth()
                        .background(color = Color(0xFF0b253f))
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewMovieCategoryLabel() {
    RecipeCategoryLabel(
        categoryLabelViewState = RecipeCategoryLabelViewState(
            1,
            false,
            RecipeCategoryLabelTextViewState.CategoryStringParam("Chocolate")
        ),
        modifier = Modifier,
        onClick = {}
    )
}
