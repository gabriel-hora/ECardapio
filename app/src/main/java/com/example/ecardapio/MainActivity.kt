package com.example.ecardapio

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.ecardapio.ui.theme.ECardapioTheme
import com.example.ecardapio.view.home.HomeActivity
import com.example.ecardapio.view.login.SelectTypeUser
import com.example.ecardapio.view.login.administrator.AdministratorLoginActivity
import com.example.ecardapio.view.login.collaborator.CollaboratorLoginActivity
import com.example.ecardapio.view.login.register.RegisterUserActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        setContent {
            ECardapioTheme {
                SelectTypeUser(
                    { administratorIntent() },
                    { registerIntent() }
                )
            }
        }
    }

    private fun registerIntent() {
        val intent = Intent(this, RegisterUserActivity::class.java)
        startActivity(intent)
    }

    private fun administratorIntent() {
        val intent = Intent(this, AdministratorLoginActivity::class.java)
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if (currentUser != null) {
            val intent = Intent(this, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }
}
