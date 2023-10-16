package com.example.ecardapio.view.login.administrator.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecardapio.view.login.administrator.event.LoginAdministratorFormEvent
import com.example.ecardapio.view.login.administrator.event.LoginAdministratorFormState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class LoginAdministratorViewModel : ViewModel() {

    var state by mutableStateOf(LoginAdministratorFormState())

    private val validationEventChannel = Channel<ValidationEvent>()
    val validationEvents = validationEventChannel.receiveAsFlow()

    fun onEvent(event : LoginAdministratorFormEvent) {
        when (event) {
            is LoginAdministratorFormEvent.EmailChanged -> {
                state = state.copy(email = event.email)
            }

            is LoginAdministratorFormEvent.PasswordChanged -> {
                state = state.copy(password = event.password)
            }

            is LoginAdministratorFormEvent.Submit -> {
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