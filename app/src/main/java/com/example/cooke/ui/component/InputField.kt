package com.example.cooke.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cooke.ui.theme.SectionTitle


data class InputFieldViewState(
    val title: String,
    val placeholder: String,
)

@Composable
fun InputField(
    inputFieldViewState: InputFieldViewState,
    onValueChange: (value: String) -> Unit,
    text: String,
    modifier: Modifier
) {
    Column(
        modifier.wrapContentSize(),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = inputFieldViewState.title,
            style = SectionTitle,
            modifier = Modifier.padding(horizontal = 18.dp),
            color = Color(0xff3f001b)
        )
        OutlinedTextField(
            value = text,
            onValueChange = { onValueChange(it) },
            placeholder = { Text(text = inputFieldViewState.placeholder) },
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
private fun PreviewInputField() {
    InputField(
        inputFieldViewState = InputFieldViewState(
            "Naziv",
            "Unesi naziv kolača",
        ),
        modifier = Modifier,
        onValueChange = {},
        text = ""
    )
}
