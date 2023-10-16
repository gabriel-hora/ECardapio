package com.example.ecardapio.view.login.register

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ecardapio.ui.theme.ECardapioTheme
import com.example.ecardapio.view.login.register.composable.BusinessRegister
import com.example.ecardapio.view.login.register.composable.PersonalRegister
import com.example.ecardapio.view.login.register.composable.UserRegister
import com.example.ecardapio.view.login.register.viewmodel.RegisterViewModel

class RegisterUserActivity : ComponentActivity() {

    private val registerViewModel by viewModels<RegisterViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ECardapioTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "personalUser") {
                    composable(route = "personalUser") {
                        PersonalRegister(navController, registerViewModel)
                        registerViewModel.changeStatusRegister(RegisterStatus.PERSONAL)
                    }

                    composable(route = "businessRegister") {
                        BusinessRegister(navController, registerViewModel)
                        registerViewModel.changeStatusRegister(RegisterStatus.BUSINESS)
                    }

                    composable(route = "userRegister") {
                        UserRegister()
                        registerViewModel.changeStatusRegister(RegisterStatus.USER)
                    }
                }
            }
        }
    }
}