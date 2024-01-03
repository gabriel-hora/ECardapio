package com.example.ecardapio.view.home

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.ecardapio.ui.theme.ECardapioTheme
import com.example.ecardapio.view.home.composable.HomeState
import com.example.ecardapio.view.home.repository.TabItemNavigationRepository
import com.example.ecardapio.view.home.util.UiState
import com.example.ecardapio.view.home.viewModel.DataHomeViewModel
import com.example.ecardapio.view.home.viewModel.ViewModelHome
import com.example.ecardapio.view.home.viewModel.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {
    private var nameBusiness: String = ""

    private val dataHomeViewModel by viewModels<DataHomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = TabItemNavigationRepository()
        val viewModelFactory = ViewModelProvider(repository)
        val viewModelHome =
            androidx.lifecycle.ViewModelProvider(this, viewModelFactory)[ViewModelHome::class.java]

        dataHomeViewModel.getData()
        dataHomeViewModel.dataPersonal.observe(this) { state ->
            when (state) {
                is UiState.Loading -> {
                    Log.e("firebaseTest", "Loading")
                }

                is UiState.Success -> {
                    Log.e("firebaseTest", state.data)
                }

                is UiState.Failure -> {
                    Log.e("firebaseTest", state.error.toString())
                }

                else -> {}
            }
        }

        setContent {
            ECardapioTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Column(Modifier.fillMaxSize()) {
                        HomeState(viewModelData = dataHomeViewModel, viewModelHome = viewModelHome)
                    }
                }
            }
        }
    }
}
