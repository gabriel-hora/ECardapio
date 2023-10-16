package com.example.ecardapio.view.login.register.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.ecardapio.view.login.register.FlowRegister
import com.example.ecardapio.view.login.register.RegisterStatus

class RegisterViewModel() : ViewModel() {

    val registerFlowState = mutableStateOf(FlowRegister())

    fun changeStatusRegister(registerStatus: RegisterStatus) {
        registerFlowState.value = registerFlowState.value.copy(registerStatus = registerStatus)
    }

}