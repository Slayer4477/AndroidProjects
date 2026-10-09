package com.example.myapplication.lab8

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NameField(
    name: String,
    onNameChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = name,
        onValueChange = onNameChange,
        label = { Text("Name") },
        modifier = modifier
    )
}

@Composable
fun Task03(modifier: Modifier = Modifier) {
    var name by rememberSaveable { mutableStateOf("") }

    Column(modifier = modifier.padding(24.dp)) {
        NameField(
            name = name,
            onNameChange = { name = it }
        )
        Text("Hello, $name!")
    }
}

@Preview(showBackground = true)
@Composable
fun Task03Preview() {
    NameField(name = "Amin", onNameChange = {})
}
