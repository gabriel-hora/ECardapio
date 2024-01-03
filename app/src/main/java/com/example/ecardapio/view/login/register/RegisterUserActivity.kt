package com.example.ecardapio.view.login.register

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ecardapio.ui.theme.ECardapioTheme
import com.example.ecardapio.view.login.administrator.AdministratorLoginActivity
import com.example.ecardapio.view.login.register.composable.BusinessRegister
import com.example.ecardapio.view.login.register.composable.PersonalRegister
import com.example.ecardapio.view.login.register.composable.UserRegister
import com.example.ecardapio.view.login.register.viewmodel.RegisterViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.delay

class RegisterUserActivity : ComponentActivity() {

    private val registerViewModel by viewModels<RegisterViewModel>()
    private lateinit var auth: FirebaseAuth
    private lateinit var myRef: DatabaseReference
    private val database = Firebase.database

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ECardapioTheme {
                auth = Firebase.auth
                myRef =
                    database.getReferenceFromUrl("https://e-cardapio-d67c6-default-rtdb.firebaseio.com/")

                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "personalUser") {
                    composable(route = "personalUser") {
                        PersonalRegister(navController, registerViewModel)
                        registerViewModel.changeStatusRegister(RegisterStatus.PERSONAL)
                    }

                    composable(route = "businessRegister") {
                        BusinessRegister(navController, registerViewModel)
                        registerViewModel.changeStatusRegister(RegisterStatus.BUSINESS)
                    }

                    composable(route = "userRegister") {
                        UserRegister(navController, registerViewModel)
                        registerViewModel.changeStatusRegister(RegisterStatus.USER)
                    }
                }

                LaunchedEffect(key1 = this) {
                    registerViewModel.validationEvents.collect { event ->
                        when (event) {
                            is RegisterViewModel.ValidationEvent.Success -> {
                                registerUser()
                                Toast.makeText(
                                    applicationContext,
                                    "REGISTRADO COM SUCESSO",
                                    Toast.LENGTH_LONG
                                ).show()
                                delay(2000L)
                                val intent = Intent(applicationContext, AdministratorLoginActivity::class.java)
                                startActivity(intent)
                            }

                            is RegisterViewModel.ValidationEvent.Error -> {
                                Log.e("register", "failed")
                            }
                        }
                    }
                }
            }
        }
    }

    private fun registerUser() {
        val state = registerViewModel.state
        auth.createUserWithEmailAndPassword(state.email, state.password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    task.result.user?.uid?.let {
                        myRef.child("users").child(it).child("personal").child("name")
                            .setValue(state.name)

                        myRef.child("users").child(it).child("personal").child("phone")
                            .setValue(state.phoneNumber)

                        myRef.child("users").child(it).child("personal").child("birthday")
                            .setValue(state.birthday)

                        myRef.child("users").child(it).child("business").child("nameBusiness")
                            .setValue(state.nameBusiness)

                        myRef.child("users").child(it).child("business").child("estado")
                            .setValue(state.state)

                        myRef.child("users").child(it).child("business").child("cidade")
                            .setValue(state.city)

                        myRef.child("users").child(it).child("codeCollaborator").child("code")
                            .setValue(generateCodeCollaborator())
                    }
                } else {
                    Log.e("register", "failed")
                }
            }
    }

    private fun generateCodeCollaborator(): String {
        val caracteres = ('A'..'Z') + ('0'..'9')
        return (1..7).map { caracteres.random() }.joinToString("")
    }
}