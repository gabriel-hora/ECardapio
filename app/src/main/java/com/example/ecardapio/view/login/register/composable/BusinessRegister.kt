package com.example.ecardapio.view.login.register.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ecardapio.view.login.register.header_register.HeaderRegisterUser
import com.example.ecardapio.view.login.register.viewmodel.RegisterViewModel

@Composable
fun BusinessRegister(
    navController: NavController,
    registerViewModel: RegisterViewModel
) {
    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        HeaderRegisterUser(navController, registerViewModel)
    }
}

@Preview
@Composable
fun BusinessRegisterPrev() {
    BusinessRegister(rememberNavController(), registerViewModel = RegisterViewModel())
}