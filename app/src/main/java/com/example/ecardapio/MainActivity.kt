package com.example.ecardapio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ecardapio.ui.theme.ECardapioTheme
import com.example.ecardapio.view.login.LoginAdministrator
import com.example.ecardapio.view.login.LoginCollaborator
import com.example.ecardapio.view.login.RegisterUser
import com.example.ecardapio.view.login.SelectTypeUser

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ECardapioTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "selectUser") {
                    composable(route = "selectUser") {
                        SelectTypeUser(navController)
                    }

                    composable(route = "loginAdministrator") {
                        LoginAdministrator(navController)
                    }

                    composable(route = "loginCollaborator") {
                        LoginCollaborator(navController)
                    }

                    composable(route = "registerUser") {
                        RegisterUser(navController)
                    }

                }
            }
        }
    }
}
