package com.example.ecardapio.view.login.register

data class FlowRegister(
    var registerStatus: RegisterStatus = RegisterStatus.PERSONAL
)

enum class RegisterStatus {
    PERSONAL, BUSINESS, USER
}
