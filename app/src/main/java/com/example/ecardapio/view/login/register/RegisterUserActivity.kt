package com.example.ecardapio.view.login.register

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ecardapio.ui.theme.ECardapioTheme
import com.example.ecardapio.view.login.register.composable.BusinessRegister
import com.example.ecardapio.view.login.register.composable.PersonalRegister
import com.example.ecardapio.view.login.register.composable.UserRegister
import com.example.ecardapio.view.login.register.viewmodel.RegisterViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class RegisterUserActivity : ComponentActivity() {

    private val registerViewModel by viewModels<RegisterViewModel>()
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ECardapioTheme {
                auth = Firebase.auth
                val database = Firebase.database
                val myRef = database.getReferenceFromUrl("https://e-cardapio-d67c6-default-rtdb.firebaseio.com/")
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
                        UserRegister()
                        registerViewModel.changeStatusRegister(RegisterStatus.USER)
                    }
                }
                val email = "gabriel@quintoacesso.com"
                auth.createUserWithEmailAndPassword(email, "123456")
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            task.result.user?.uid?.let { myRef.child("users").child(it).child("personal").child("fullName").setValue("Gabriel Hora") }
                            task.result.user?.uid?.let { myRef.child("users").child(it).child("personal").child("phone").setValue("11977527475") }
                            task.result.user?.uid?.let { myRef.child("users").child(it).child("personal").child("birthday").setValue("12-05-1997") }

                            task.result.user?.uid?.let { myRef.child("users").child(it).child("business").child("nameBusiness").setValue("Buteco seu Zé") }
                            task.result.user?.uid?.let { myRef.child("users").child(it).child("business").child("Estado").setValue("São Paulo") }
                            task.result.user?.uid?.let { myRef.child("users").child(it).child("business").child("Cidade").setValue("Poá") }
                        } else {
                            Log.e("register", "failed")
                        }
                    }
            }
        }
    }
}