package com.example.ecardapio.view.login.administrator.event

data class LoginAdministratorFormState(
    val email : String = "",
    val emailError : String? = null,
    val password : String = "",
    val passwordError : String? = null
)