package com.awanama.aleinfo.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.awanama.aleinfo.ui.components.ErrorItem
import com.awanama.aleinfo.ui.components.LoadingIndicator

@Composable
fun ProfileScreen(
    isLoading: Boolean,
    error: String?,
    modifier: Modifier = Modifier,
) {
    Scaffold {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when {
                isLoading -> LoadingIndicator(modifier = Modifier.fillMaxSize())
                error != null -> ErrorItem(text = error, modifier = Modifier.fillMaxSize())
                else -> {
                    // Profile content goes here
                }
            }
        }
    }
}

@Composable
fun ProfileRoute(
    onNavigateClick: (source: String) -> Unit
) {
    val (isLoading, setIsLoading) = remember { mutableStateOf(false) }  // Set loading state to false initially
    val (error, setError) = remember { mutableStateOf<String?>(null) }

    // Remove the LaunchedEffect block

    ProfileScreen(
        isLoading = isLoading,
        error = error,
    )
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(isLoading = false, error = null)
}
