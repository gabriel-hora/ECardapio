package com.example.ecardapio

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.ecardapio.ui.theme.ECardapioTheme
import com.example.ecardapio.view.login.SelectTypeUser
import com.example.ecardapio.view.login.register.RegisterUserActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ECardapioTheme {
                SelectTypeUser(
                    { administratorIntent() },
                    { collaboratorIntent() },
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
        val intent = Intent(this, RegisterUserActivity::class.java)
        startActivity(intent)
    }

    private fun collaboratorIntent() {
        val intent = Intent(this, RegisterUserActivity::class.java)
        startActivity(intent)
    }
}
