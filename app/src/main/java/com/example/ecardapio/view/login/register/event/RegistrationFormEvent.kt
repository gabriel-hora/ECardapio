package com.example.ecardapio.view.login.register.event

sealed class RegistrationFormEvent() {
    data class NameChanged(val name: String) : RegistrationFormEvent()
    data class PhoneNumberChanged(val phoneNumber: String) : RegistrationFormEvent()
    data class BirthdayChanged(val birthday: String) : RegistrationFormEvent()
    data class NameBusinessChanged(val nameBusiness: String) : RegistrationFormEvent()
    data class StateChanged(val state: String) : RegistrationFormEvent()
    data class CityChanged(val city: String) : RegistrationFormEvent()
    data class EmailChanged(val email: String) : RegistrationFormEvent()
    data class PasswordChanged(val password: String) : RegistrationFormEvent()
    data class ConfirmPasswordChanged(val confirmPassword: String) : RegistrationFormEvent()

    object Submit : RegistrationFormEvent()
}
