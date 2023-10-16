package com.example.ecardapio.view.login.administrator

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ecardapio.ui.theme.OpenSans
import com.example.ecardapio.view.login.administrator.event.LoginAdministratorFormEvent
import com.example.ecardapio.view.login.administrator.viewmodel.LoginAdministratorViewModel
import com.example.ecardapio.view.login.register.event.RegistrationFormEvent
import com.example.ecardapio.view.login.register.viewmodel.RegisterViewModel

@Composable
fun LoginAdministrator(loginAdministratorViewModel: LoginAdministratorViewModel) {
    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        HeaderLoginAdministrator()
        BodyRegisterUser(loginAdministratorViewModel)

    }
}

@Composable
fun HeaderLoginAdministrator() {
    val activity = (LocalContext.current as? Activity)

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
            modifier = Modifier
                .size(35.dp)
                .clickable {
                    activity?.finish()
                }
        )

        Text(
            text = "Administrador",
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BodyRegisterUser(loginAdministratorViewModel: LoginAdministratorViewModel) {
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.8f)
            .clip(shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
            .background(color = Color.White)
    ) {
        Column(Modifier.padding(start = 22.dp)) {
            Text(
                text = "Login",
                fontSize = 32.sp,
                fontFamily = OpenSans,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(top = 52.dp)
            )

            Text(
                text = "Faça login para ter acesso \n" +
                        "ao conteúdo do seu restaurante",
                fontSize = 14.sp,
                fontFamily = OpenSans,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
        }

        Column(Modifier.padding(horizontal = 30.dp)) {
            Text(
                text = "Email",
                fontSize = 14.sp,
                fontFamily = OpenSans,
                fontWeight = FontWeight.Thin,
                modifier = Modifier.padding(top = 25.dp, start = 8.dp)
            )

            OutlinedTextField(
                value = loginAdministratorViewModel.state.email,
                onValueChange = {
                    loginAdministratorViewModel.onEvent(
                        LoginAdministratorFormEvent.EmailChanged(
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
                placeholder = { Text(text = "ecardapio@gmail.com", color = Color(0x664A4F55)) }
            )
        }

        Column(Modifier.padding(horizontal = 30.dp)) {
            Text(
                text = "Senha",
                fontSize = 14.sp,
                fontFamily = OpenSans,
                fontWeight = FontWeight.Thin,
                modifier = Modifier.padding(top = 25.dp, start = 8.dp)
            )

            OutlinedTextField(
                value = loginAdministratorViewModel.state.password,
                onValueChange = {
                    if (it.length <= 14) loginAdministratorViewModel.onEvent(
                        LoginAdministratorFormEvent.PasswordChanged(
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
                    keyboardType = KeyboardType.Number
                )
            )
        }


        Button(
            onClick = { loginAdministratorViewModel.onEvent(LoginAdministratorFormEvent.Submit) },
            Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp, top = 60.dp)
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFFEFD051)),
            shape = RoundedCornerShape(15.dp)
        ) {
            Text(
                text = "LOGIN",
                fontSize = 24.sp,
                fontFamily = OpenSans,
                fontWeight = FontWeight.ExtraBold
            )
        }
    }
}

@Preview
@Composable
fun HeaderLoginAdministratorPrev() {
    HeaderLoginAdministrator()
}
