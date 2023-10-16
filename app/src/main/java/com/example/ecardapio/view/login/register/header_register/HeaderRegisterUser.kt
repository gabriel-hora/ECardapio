package com.example.ecardapio.view.login.register.header_register

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ecardapio.ui.theme.OpenSans

@Composable
fun HeaderRegisterUser(navController: NavController) {
    Column(
        Modifier
            .background(Color(0xFF99D8CD))
            .fillMaxSize()
            .padding(top = 35.dp, start = 22.dp)
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Image Button Arrow Back",
            tint = Color.White,
            modifier = Modifier.size(35.dp).clickable {
                navController.popBackStack()
            }
        )

        Text(
            text = "Cadastrar",
            fontFamily = OpenSans,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 32.sp,
            color = Color.White,
            modifier = Modifier.padding(top = 20.dp)
        )

        Text(
            text = "eCardapio",
            fontFamily = OpenSans,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            color = Color.Black
        )
    }
}