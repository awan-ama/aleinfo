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
fun RegisterScreen(
    onLoginClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val email = remember { mutableStateOf("") }
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
                value = email.value,
                onValueChange = { email.value = it },
                label = { Text(text = "Email") },
            )

            OutlinedTextField(
                value = username.value,
                onValueChange = { username.value = it },
                label = { Text(text = "Username")},
                modifier = Modifier.padding(vertical = 5.dp)
            )

            OutlinedTextField(
                value = password.value,
                onValueChange = { password.value = it },
                label = { Text(text = "Password") },
                modifier = Modifier.padding(vertical = 5.dp)
            )

            Button(onClick = onLoginClick,
                modifier = Modifier.padding(vertical = 5.dp)) {
                Text(text = "Create Account")
            }

            Button(onClick = onLoginClick,
                colors = ButtonDefaults.buttonColors(Green50),
                modifier = Modifier.padding(vertical = 5.dp)){
                Text(text = "Go To Login")
            }
        }
    }
}

@Composable
fun RegisterRoute(
    onNavigateClick: (source: String) -> Unit
) {
    RegisterScreen(
        onLoginClick = { onNavigateClick(TopLevelDestination.Login.route) }
    )
}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    RegisterScreen(onLoginClick = {})
}