package com.example.ecardapio.view.login.register.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecardapio.view.login.register.FlowRegister
import com.example.ecardapio.view.login.register.RegisterStatus
import com.example.ecardapio.view.login.register.event.RegisterFormState
import com.example.ecardapio.view.login.register.event.RegistrationFormEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class RegisterViewModel() : ViewModel() {

    val registerFlowState = mutableStateOf(FlowRegister())
    var state by mutableStateOf(RegisterFormState())

    private val validationEventChannel = Channel<ValidationEvent>()
    val validationEvents = validationEventChannel.receiveAsFlow()

    fun changeStatusRegister(registerStatus: RegisterStatus) {
        registerFlowState.value = registerFlowState.value.copy(registerStatus = registerStatus)
    }

    fun onEvent(event: RegistrationFormEvent) {
        when (event) {
            is RegistrationFormEvent.NameChanged -> {
                state = state.copy(name = event.name)
            }

            is RegistrationFormEvent.PhoneNumberChanged -> {
                state = state.copy(phoneNumber = event.phoneNumber)
            }

            is RegistrationFormEvent.BirthdayChanged -> {
                state = state.copy(birthday = event.birthday)
            }

            is RegistrationFormEvent.NameBusinessChanged -> {
                state = state.copy(nameBusiness = event.nameBusiness)
            }

            is RegistrationFormEvent.StateChanged -> {
                state = state.copy(state = event.state)
            }

            is RegistrationFormEvent.CityChanged -> {
                state = state.copy(city = event.city)
            }

            is RegistrationFormEvent.EmailChanged -> {
                state = state.copy(email = event.email)
            }

            is RegistrationFormEvent.PasswordChanged -> {
                state = state.copy(password = event.password)
            }

            is RegistrationFormEvent.ConfirmPasswordChanged -> {
                state = state.copy(confirmPassword = event.confirmPassword)
            }

            is RegistrationFormEvent.Submit -> {
                viewModelScope.launch {
                    validationEventChannel.send(ValidationEvent.Success)
                }
            }
        }
    }

    sealed class ValidationEvent {
        object Success : ValidationEvent()
        object Error : ValidationEvent()
    }
}