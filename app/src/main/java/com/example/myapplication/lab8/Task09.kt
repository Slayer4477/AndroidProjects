package com.example.myapplication.lab8

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Task09(
    modifier: Modifier = Modifier,
    viewModel: Task06ViewModel = viewModel()
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val uiState = viewModel.uiState.value

    LaunchedEffect(uiState) {
        if (uiState is SignInUiStateModel.Error) {
            snackbarHostState.showSnackbar(uiState.message)
            viewModel.onErrorShown()
        }
    }

    Scaffold(
        modifier = modifier,
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { innerPadding ->
        Task07(
            uiState = uiState,
            onSignIn = viewModel::onSignIn,
            modifier = Modifier.padding(innerPadding)
        )
    }
}
