package com.example.myapplication.lab8

sealed interface SignInUiStateModel {
    data object SignedOut : SignInUiStateModel
    data object InProgress : SignInUiStateModel
    data class Error(val message: String) : SignInUiStateModel
    data class SignedIn(val email: String) : SignInUiStateModel
}
