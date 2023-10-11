package com.example.ecardapio.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable
fun SelectTypeUser(navController: NavController) {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "ADMINISTRADOR", Modifier.clickable {
            navController.navigate("loginAdministrator")
        })
        Text(text = "COLABORADOR", Modifier.clickable {
            navController.navigate("loginCollaborator")
        })
    }
}

@Preview(showBackground = true)
@Composable
fun SelectUserPrev() {

}