package com.example.ecardapio.view.login.administrator

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.LaunchedEffect
import com.example.ecardapio.ui.theme.ECardapioTheme
import com.example.ecardapio.view.home.HomeActivity
import com.example.ecardapio.view.login.administrator.viewmodel.LoginAdministratorViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class AdministratorLoginActivity : ComponentActivity() {

    private val loginAdministratorViewModel by viewModels<LoginAdministratorViewModel>()
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ECardapioTheme {
                auth = Firebase.auth

                LoginAdministrator(loginAdministratorViewModel)

                LaunchedEffect(key1 = applicationContext) {
                    loginAdministratorViewModel.validationEvents.collect() { event ->
                        loginUser()
                    }
                }
            }
        }
    }

    private fun loginUser() {
        val state = loginAdministratorViewModel.state
        auth.signInWithEmailAndPassword(state.email, state.password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                } else {
                    Log.e("Login", "Error")
                }
            }
    }
}