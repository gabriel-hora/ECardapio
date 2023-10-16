package com.example.ecardapio.view.login.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ecardapio.view.login.register.header_register.HeaderRegisterUser

@Composable
fun RegisterUser(navController: NavController) {
    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        HeaderRegisterUser(navController)
        BodyRegisterUser()
    }
}

@Composable
fun BodyRegisterUser() {
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.8f)
            .clip(shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
            .background(color = Color.White)
    ) {

    }
}

@Preview(
    showBackground = true
)
@Composable
fun RegisterUserPrev() {
    RegisterUser(rememberNavController())
}