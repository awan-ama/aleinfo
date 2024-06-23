package com.awanama.aleinfo.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(
    navController: NavHostController,
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
            BeerListScreen(navController = navController)
        }
    }
}

@Composable
fun HomeRoute(
    navController: NavHostController,
    onNavigateClick: (source: String) -> Unit
) {
    HomeScreen(navController = navController)
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    // Dummy NavHostController for preview
    // In a real scenario, you should replace it with an actual NavHostController
    val dummyNavController = androidx.navigation.compose.rememberNavController()
    HomeScreen(navController = dummyNavController)
}
