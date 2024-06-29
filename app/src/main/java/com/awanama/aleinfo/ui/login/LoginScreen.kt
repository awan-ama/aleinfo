package com.awanama.aleinfo.ui.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.awanama.aleinfo.navigation.TopLevelDestination

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    onRegisterClick: () -> Unit,
    modifier: Modifier = Modifier,
    loginViewModel: LoginViewModel = hiltViewModel()
) {
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val isLoggedIn by loginViewModel.isLoggedIn.collectAsState()
    val loginError by loginViewModel.loginError.collectAsState()

    if (isLoggedIn) {
        onLoginSuccess()
    }

    Scaffold {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = username.value,
                onValueChange = { username.value = it },
                label = { Text("Username") }
            )
            OutlinedTextField(
                value = password.value,
                onValueChange = { password.value = it },
                label = { Text("Password") }
            )
            Button(
                onClick = { loginViewModel.login(username.value, password.value) },
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text("Login")
            }
            if (loginError != null) {
                Text(text = loginError ?: "", color = MaterialTheme.colorScheme.error)
            }
            Button(
                onClick = onRegisterClick,
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text("Register")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(onLoginSuccess = {}, onRegisterClick = {})
}


@Composable
fun LoginRoute(
    onNavigateClick: (source: String) -> Unit
) {
    LoginScreen(
        onLoginSuccess = { onNavigateClick(TopLevelDestination.Home.route) },
        onRegisterClick = { onNavigateClick(TopLevelDestination.Register.route) }
    )
}