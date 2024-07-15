package com.example.myapplication.state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

class LoginState
    (initInput: String, initAlert: Boolean) {
    var email by mutableStateOf(initInput)
    var password by mutableStateOf(initInput)
    var showDialog by mutableStateOf(initAlert)

}

@Composable
fun loginStateRemember(
    modifier: Modifier = Modifier, initInput: String, initAlert: Boolean
): LoginState = remember {
    LoginState(initInput, initAlert)
}