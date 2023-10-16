package com.example.ecardapio.view.login.administrator.event

sealed class LoginAdministratorFormEvent {
    data class EmailChanged(val email: String) : LoginAdministratorFormEvent()
    data class PasswordChanged(val password: String) : LoginAdministratorFormEvent()
    object Submit : LoginAdministratorFormEvent()
}
