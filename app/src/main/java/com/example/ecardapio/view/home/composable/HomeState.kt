package com.example.ecardapio.view.home.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ecardapio.view.home.util.ScreenState
import com.example.ecardapio.view.home.util.UiState
import com.example.ecardapio.view.home.viewModel.DataHomeViewModel
import com.example.ecardapio.view.home.viewModel.ViewModelHome

@Composable
fun HomeState(viewModelData: DataHomeViewModel, viewModelHome: ViewModelHome) {
    val state = viewModelData.screenState.value

    when (state.screenState) {
        ScreenState.LOADING -> {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Text(text = "LOADING")
            }
        }

        ScreenState.SUCCESS -> {
            val name = viewModelData.dataPersonal.value as UiState.Success
            TabNavigation(viewModelHome = viewModelHome, nameBusiness = name.data)
        }

        else -> {}
    }
}

@Preview
@Composable
fun HomeStatePrev() {

}