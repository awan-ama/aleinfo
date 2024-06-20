package com.awanama.aleinfo.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.awanama.aleinfo.navigation.TopLevelDestination
import com.awanama.aleinfo.ui.components.ErrorItem
import com.awanama.aleinfo.ui.components.LoadingIndicator

@Composable
fun LoginScreen(
    isLoading: Boolean,
    error: String?,
    onLoginClick: () -> Unit,
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
                modifier = Modifier
                    .padding(vertical = 20.dp)
            )

            OutlinedTextField(
                value = password.value,
                onValueChange = { password.value = it },
                label = { Text(text = "Password") },
                modifier = Modifier
                    .padding(vertical = 20.dp)
            )

            Button(onClick = onLoginClick) {
                Text(text = "Login")
            }

            when {
                isLoading -> LoadingIndicator(modifier = Modifier.fillMaxSize())
                error != null -> ErrorItem(text = error, modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun LoginRoute(
    onNavigateClick: (source: String) -> Unit
) {
    val isLoading by remember { mutableStateOf(false) }
    val error by remember { mutableStateOf<String?>(null) }

    LoginScreen(
        isLoading = isLoading,
        error = error,
        onLoginClick = { onNavigateClick(TopLevelDestination.Home.route) }
    )
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(isLoading = false, error = null, onLoginClick = {})
}