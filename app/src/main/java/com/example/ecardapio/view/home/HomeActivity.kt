package com.example.ecardapio.view.home

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.example.ecardapio.ui.theme.ECardapioTheme
import com.example.ecardapio.view.home.composable.TabNavigation
import com.example.ecardapio.view.home.repository.TabItemNavigationRepository
import com.example.ecardapio.view.home.viewModel.ViewModelHome
import com.example.ecardapio.view.home.viewModel.ViewModelProvider

class HomeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = TabItemNavigationRepository()
        val viewModelFactory = ViewModelProvider(repository)
        val viewModelHome =
            androidx.lifecycle.ViewModelProvider(this, viewModelFactory)[ViewModelHome::class.java]

        setContent {
            ECardapioTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Column(Modifier.fillMaxSize()) {
                        TabNavigation(viewModelHome)
                    }
                }
            }
        }
    }
}
