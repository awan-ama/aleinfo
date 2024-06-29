package com.awanama.aleinfo.ui.register

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
fun RegisterScreen(
    onRegisterSuccess: () -> Unit,
    onLoginClick: () -> Unit,
    modifier: Modifier = Modifier,
    registerViewModel: RegisterViewModel = hiltViewModel()
) {
    val username = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val isRegistered by registerViewModel.isRegistered.collectAsState()
    val registerError by registerViewModel.registerError.collectAsState()

    if (isRegistered) {
        onRegisterSuccess()
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
                value = email.value,
                onValueChange = { email.value = it },
                label = { Text("Email") }
            )
            OutlinedTextField(
                value = password.value,
                onValueChange = { password.value = it },
                label = { Text("Password") }
            )
            Button(
                onClick = { registerViewModel.register(username.value, email.value, password.value) },
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text("Register")
            }
            if (registerError != null) {
                Text(text = registerError ?: "", color = MaterialTheme.colorScheme.error)
            }
            Button(
                onClick = onLoginClick,
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text("Login")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    RegisterScreen(onRegisterSuccess = {}, onLoginClick = {})
}

@Composable
fun RegisterRoute(
    onNavigateClick: (source: String) -> Unit
) {
    RegisterScreen(
        onRegisterSuccess = { onNavigateClick(TopLevelDestination.Login.route) },
        onLoginClick = { onNavigateClick(TopLevelDestination.Login.route) }
    )
}