package com.example.cooke.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cooke.ui.theme.CustomHeader
import com.example.cooke.ui.theme.SectionTitle

@Composable
fun NumberInputField(inputFieldViewState: InputFieldViewState, modifier: Modifier) {
    var text by rememberSaveable { mutableStateOf("") }
    Column(modifier = modifier) {
        Text(
            text = "Vrijeme pripreme",
            modifier = Modifier.padding(horizontal = 16.dp),
            style = SectionTitle
        )
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            placeholder = { Text(text = inputFieldViewState.placeholder) },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .padding(vertical = 5.dp, horizontal = 10.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color(0xffcc8d9d),
                backgroundColor = Color.White
            )
        )
    }
}

@Preview
@Composable
private fun NumberInputFielPreview() {
    NumberInputField(
        inputFieldViewState = InputFieldViewState(
            title = "Vrijeme pripreme (hh:mm)",
            "Unesi vrijeme pripreme",
            text = ""
        ),
        modifier = Modifier.padding(6.dp)
    )
}
