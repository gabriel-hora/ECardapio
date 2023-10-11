package com.example.ecardapio.view.login

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.example.ecardapio.ui.theme.OpenSans

@Composable
fun LoginAdministrator(navController: NavController) {
    Text(text = "LoginAdministrator", fontFamily = OpenSans, fontWeight = FontWeight.SemiBold)
}