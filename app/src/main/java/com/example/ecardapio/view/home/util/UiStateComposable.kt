package com.example.ecardapio.view.home.util

data class UiStateComposable(
    var screenState : ScreenState = ScreenState.LOADING
)

enum class ScreenState {
    LOADING, SUCCESS, ERROR
}