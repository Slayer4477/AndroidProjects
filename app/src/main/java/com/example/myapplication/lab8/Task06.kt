package com.example.myapplication.lab8

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Task06ViewModel : ViewModel() {
    private val _uiState = mutableStateOf<SignInUiStateModel>(SignInUiStateModel.SignedOut)
    val uiState: State<SignInUiStateModel> get() = _uiState

    fun onSignIn(email: String, password: String) {
        if (_uiState.value is SignInUiStateModel.InProgress) return
        _uiState.value = SignInUiStateModel.InProgress

        viewModelScope.launch {
            delay(1500)
            if (password == "kotlin123") {
                _uiState.value = SignInUiStateModel.SignedIn(email)
            } else {
                _uiState.value = SignInUiStateModel.Error("Wrong email or password")
            }
        }
    }

    fun onErrorShown() {
        if (_uiState.value is SignInUiStateModel.Error) {
            _uiState.value = SignInUiStateModel.SignedOut
        }
    }
}
