package com.example.myapplication.lab8

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Task07_SignInScreen(
    uiState: SignInUiState,
    onSignIn: (email: String, password: String) -> Unit,
    modifier: Modifier = Modifier
) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        when (uiState) {
            is SignInUiState.SignedIn -> {
                Text(
                    text = "Welcome, ${uiState.email}",
                    style = MaterialTheme.typography.headlineMedium
                )
            }
            else -> {
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(12.dp))
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { onSignIn(email, password) },
                    enabled = uiState !is SignInUiState.InProgress,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Sign in")
                }
                if (uiState is SignInUiState.InProgress) {
                    Spacer(modifier = Modifier.height(16.dp))
                    CircularProgressIndicator()
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "Signed Out")
@Composable
fun Task07_PreviewSignedOut() {
    Task07_SignInScreen(uiState = SignInUiState.SignedOut, onSignIn = { _, _ -> })
}

@Preview(showBackground = true, name = "In Progress")
@Composable
fun Task07_PreviewInProgress() {
    Task07_SignInScreen(uiState = SignInUiState.InProgress, onSignIn = { _, _ -> })
}

@Preview(showBackground = true, name = "Error")
@Composable
fun Task07_PreviewError() {
    Task07_SignInScreen(uiState = SignInUiState.Error("Wrong email or password"), onSignIn = { _, _ -> })
}

@Preview(showBackground = true, name = "Signed In")
@Composable
fun Task07_PreviewSignedIn() {
    Task07_SignInScreen(uiState = SignInUiState.SignedIn("user@example.com"), onSignIn = { _, _ -> })
}
