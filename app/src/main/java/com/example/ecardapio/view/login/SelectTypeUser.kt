package com.example.ecardapio.view.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.example.ecardapio.ui.theme.OpenSans

@Composable
fun SelectTypeUser(
    administrator: () -> Unit = {},
    register: () -> Unit = {},
) {
    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Header()
        Body(administrator, register)
    }
}

@Composable
fun Header() {
    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color(0xFF99D8CD))
            .padding(start = 22.dp)
    ) {
        Column {
            Spacer(Modifier.height(200.dp))
            Text(
                text = "eCardapio",
                color = Color.White,
                fontSize = 32.sp,
                fontFamily = OpenSans,
                fontWeight = FontWeight.ExtraBold
            )
            Text(
                text = "Seja bem vindo",
                color = Color.Black,
                fontSize = 16.sp,
                fontFamily = OpenSans,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
fun Body(
    administrator: () -> Unit,
    register: () -> Unit,
    ) {
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.4f)
            .clip(shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
            .background(color = Color.White)
            .padding(horizontal = 22.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { administrator() },
            Modifier
                .fillMaxWidth()
                .padding(top = 38.dp)
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

        Button(
            onClick = { register() },
            Modifier
                .fillMaxWidth()
                .padding(top = 25.dp)
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFFEFD051)),
            shape = RoundedCornerShape(15.dp)
        ) {
            Text(
                text = "CADASTRE-SE",
                fontSize = 24.sp,
                fontFamily = OpenSans,
                fontWeight = FontWeight.ExtraBold
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 30.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Algum problema?",
                fontSize = 14.sp,
                fontFamily = OpenSans,
                fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(top = 20.dp)
            )

            Text(
                text = "ecardapio - v0.1",
                fontSize = 12.sp,
                fontFamily = OpenSans,
                fontWeight = FontWeight.Light, modifier = Modifier.padding(top = 5.dp)
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun SelectUserPrev() {
    SelectTypeUser()
}