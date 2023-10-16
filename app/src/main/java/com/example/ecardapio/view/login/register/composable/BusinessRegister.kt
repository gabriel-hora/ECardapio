package com.example.ecardapio.view.login.register.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ecardapio.ui.theme.OpenSans
import com.example.ecardapio.view.login.register.event.RegistrationFormEvent
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
        BodyRegisterBusiness(registerViewModel, navController)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BodyRegisterBusiness(registerViewModel: RegisterViewModel, navController: NavController) {
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.8f)
            .clip(shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
            .background(color = Color.White)
    ) {
        Column(Modifier.padding(start = 22.dp)) {
            Text(
                text = "Restaurante",
                fontSize = 32.sp,
                fontFamily = OpenSans,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(top = 52.dp)
            )

            Text(
                text = "Cadastre os dados do seu restaurante",
                fontSize = 14.sp,
                fontFamily = OpenSans,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
        }

        Column(Modifier.padding(horizontal = 30.dp)) {
            Text(
                text = "Nome do Restaurante",
                fontSize = 14.sp,
                fontFamily = OpenSans,
                fontWeight = FontWeight.Thin,
                modifier = Modifier.padding(top = 25.dp, start = 8.dp)
            )

            OutlinedTextField(
                value = registerViewModel.state.nameBusiness,
                onValueChange = { registerViewModel.onEvent(RegistrationFormEvent.NameBusinessChanged(it)) },
                modifier = Modifier
                    .fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color(0xFFEEEEEE),
                    unfocusedBorderColor = Color(0xFFD7D7D7),
                    cursorColor = Color.Black,
                    focusedBorderColor = Color(0xFFC5C5C5)
                ),
                placeholder = { Text(text = "Restaurante do Zé", color = Color(0x664A4F55)) }
            )
        }

        Column(Modifier.padding(horizontal = 30.dp)) {
            Text(
                text = "Estado",
                fontSize = 14.sp,
                fontFamily = OpenSans,
                fontWeight = FontWeight.Thin,
                modifier = Modifier.padding(top = 25.dp, start = 8.dp)
            )

            OutlinedTextField(
                value = registerViewModel.state.state,
                onValueChange = {
                    registerViewModel.onEvent(
                        RegistrationFormEvent.StateChanged(
                            it
                        )
                    )
                },
                modifier = Modifier
                    .fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color(0xFFEEEEEE),
                    unfocusedBorderColor = Color(0xFFD7D7D7),
                    cursorColor = Color.Black,
                    focusedBorderColor = Color(0xFFC5C5C5)
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                ),
                placeholder = { Text(text = "São Paulo", color = Color(0x664A4F55)) }
            )
        }

        Column(Modifier.padding(horizontal = 30.dp)) {
            Text(
                text = "Cidade",
                fontSize = 14.sp,
                fontFamily = OpenSans,
                fontWeight = FontWeight.Thin,
                modifier = Modifier.padding(top = 25.dp, start = 8.dp)
            )

            OutlinedTextField(
                value = registerViewModel.state.city,
                onValueChange = {
                    registerViewModel.onEvent(
                        RegistrationFormEvent.CityChanged(it)
                    )
                },
                modifier = Modifier
                    .fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color(0xFFEEEEEE),
                    unfocusedBorderColor = Color(0xFFD7D7D7),
                    cursorColor = Color.Black,
                    focusedBorderColor = Color(0xFFC5C5C5)
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                ),
                placeholder = { Text(text = "Mogi das Cruzes", color = Color(0x664A4F55)) }
            )
        }

        Button(
            onClick = { navController.navigate("userRegister") },
            Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp, top = 60.dp)
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFFEFD051)),
            shape = RoundedCornerShape(15.dp)
        ) {
            Text(
                text = "PRÓXIMO",
                fontSize = 24.sp,
                fontFamily = OpenSans,
                fontWeight = FontWeight.ExtraBold
            )
        }
    }
}

@Preview
@Composable
fun BusinessRegisterPrev() {
    BusinessRegister(rememberNavController(), registerViewModel = RegisterViewModel())
}