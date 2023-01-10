package com.example.cooke.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


data class InputFieldViewState(
    val title: String,
    val defaultContent: String,
)

@Composable
fun InputField(
    inputFieldViewState: InputFieldViewState,
    modifier: Modifier
){
    Box(
        contentAlignment = Alignment.Center
    ){
        Text(
            text = inputFieldViewState.title,
            modifier = Modifier.align(alignment = Alignment.CenterStart)
        )
        TextField(value = inputFieldViewState.defaultContent, onValueChange = {})
    }
}

@Preview
@Composable
private fun PreviewInputFieldViewState(){
    InputField(inputFieldViewState = InputFieldViewState("Naziv","Mađarica"), modifier = Modifier)
}
