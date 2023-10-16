package com.example.ecardapio.view.login.register.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ecardapio.ui.theme.OpenSans
import com.example.ecardapio.view.login.register.header_register.HeaderRegisterUser
import com.example.ecardapio.view.login.register.viewmodel.RegisterViewModel

@Composable
fun PersonalRegister(
    navController: NavController,
    registerViewModel: RegisterViewModel
) {
    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        HeaderRegisterUser(navController, registerViewModel)
        BodyRegisterUser(navController)
    }
}

@Composable
fun BodyRegisterUser(navController: NavController) {
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.8f)
            .clip(shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
            .background(color = Color.White)
    ) {
        Column(Modifier.padding(start = 22.dp)) {
            Text(
                text = "Dados pessoais",
                fontSize = 32.sp,
                fontFamily = OpenSans,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(top = 52.dp)
            )

            Text(
                text = "Primeiro cadastre seus dados pessoais\n" +
                        "como administrador do restaurante",
                fontSize = 14.sp,
                fontFamily = OpenSans,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
        }

        Column(Modifier.padding(start = 22.dp)) {
            Text(
                text = "Nome completo",
                fontSize = 14.sp,
                fontFamily = OpenSans,
                fontWeight = FontWeight.Thin,
                modifier = Modifier.padding(top = 25.dp)
            )


        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun RegisterUserPrev() {
    PersonalRegister(rememberNavController(), registerViewModel = RegisterViewModel())
}