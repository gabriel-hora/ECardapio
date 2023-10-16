package com.example.ecardapio.view.login.register.event

data class RegisterFormState(
    val name: String = "",
    val nameError: String? = null,
    val phoneNumber: String = "",
    val phoneNumberError: String? = null,
    val birthday: String = "",
    val birthdayError: String? = null,
    val nameBusiness: String = "",
    val nameBusinessError: String? = null,
    val state: String = "",
    val stateError: String? = null,
    val city: String = "",
    val cityError: String? = null,
    val email: String = "",
    val emailError: String? = null,
    val password: String = "",
    val passwordError: String? = null,
    val confirmPassword: String = "",
    val confirmPasswordError: String? = null,

    val btnSubmitStatus: Boolean = false
)
