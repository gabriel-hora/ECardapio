package com.example.ecardapio.view.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.ecardapio.ui.theme.ECardapioTheme
import com.example.ecardapio.view.home.composable.HomeScreen

class HomeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ECardapioTheme {
                HomeScreen()
            }
        }
    }
}
