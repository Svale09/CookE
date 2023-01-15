package com.example.cooke.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


data class InputFieldViewState(
    val title: String,
    val placeholder: String
)

@Composable
fun InputField(
    inputFieldViewState: InputFieldViewState,
    modifier: Modifier
) {
    var text by rememberSaveable { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text(text = inputFieldViewState.title) },
        placeholder = { Text(text = inputFieldViewState.placeholder) },
        modifier = modifier
            .padding(vertical = 5.dp, horizontal = 10.dp)
            .fillMaxWidth()
    )
}

@Preview
@Composable
private fun PreviewInputFieldViewState() {
    InputField(
        inputFieldViewState = InputFieldViewState(
            "Naziv",
            "Unesi naziv kolača"
        ),
        modifier = Modifier
    )
}
