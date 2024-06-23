package com.awanama.aleinfo.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.awanama.aleinfo.navigation.TopLevelDestination
import com.awanama.aleinfo.ui.theme.Green50

@Composable
fun LoginScreen(
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

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
                label = { Text(text = "Username") },
            )

            OutlinedTextField(
                value = password.value,
                onValueChange = { password.value = it },
                label = { Text(text = "Password") },
                modifier = Modifier.padding(vertical = 10.dp)
            )

            Button(onClick = onLoginClick,
                modifier = Modifier.padding(vertical = 5.dp)) {
                Text(text = "Login")
            }

            Button(onClick = onRegisterClick,
                colors = ButtonDefaults.buttonColors(Green50),
                modifier = Modifier.padding(vertical = 5.dp)){
                Text(text = "Register Account")
            }
        }
    }
}

@Composable
fun LoginRoute(
    onNavigateClick: (source: String) -> Unit
) {
    LoginScreen(
        onLoginClick = { onNavigateClick(TopLevelDestination.Home.route) },
        onRegisterClick = { onNavigateClick(TopLevelDestination.Register.route) }
    )
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(onLoginClick = {}, onRegisterClick = {})
}