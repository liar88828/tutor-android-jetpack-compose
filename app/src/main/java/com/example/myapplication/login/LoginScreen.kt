package com.example.myapplication.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.R
import com.example.myapplication.state.LoginState
import com.example.myapplication.state.loginStateRemember
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun LoginScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    state: LoginState = loginStateRemember(initInput = "", initAlert = false),
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
//        Logo
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null,
            modifier = modifier
                .size(100.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = modifier.height(16.dp))
        //Email
        OutlinedTextField(
            value = state.email, onValueChange = { state.email = it },
            label = { Text(text = "Email") },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Email, contentDescription = "Email")
            },
            modifier = modifier
                .fillMaxWidth()
                .onFocusChanged { focusState ->
                    {

                    }
                },
        )
        Spacer(modifier = modifier.height(16.dp))

        //Password
        OutlinedTextField(
            value = state.password, onValueChange = { state.password = it },
            label = { Text(text = "Password") },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Lock, contentDescription = "Password")
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {

                }
            ),
            visualTransformation = PasswordVisualTransformation(),
            modifier = modifier
                .fillMaxWidth()
                .onFocusChanged { focusState ->
                    {

                    }
                },
        )

        Spacer(modifier = modifier.height(16.dp))

//        Login
        Button(
            modifier = modifier.fillMaxWidth(),
            onClick = {
                if (state.email == "" || state.password == "") {
                    state.showDialog = true
                } else {
                    navController.navigate("home")
                }
            },
        ) {
            Text(text = "Login")
        }

//        Dialog
        if (state.showDialog) {
            AlertDialog(onDismissRequest = {
                // Dismiss the dialog
                state.showDialog = false
            },

                title = {
                    Text(text = "User Information")
                },
                text = {
                    Column {
                        Text(text = "Email ${state.email}")
                        Text(text = "Password ${state.password}")
                    }
                },
                confirmButton = {
                    Button(onClick = {
//                        Dismiss the dialog
                        state.showDialog = false


                    }) {
                        Text(text = "OK")
                    }


                })
        }

    }

}


@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    val navController = rememberNavController()
    MyApplicationTheme {
        LoginScreen(navController)
    }
}