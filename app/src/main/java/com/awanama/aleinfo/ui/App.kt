package com.awanama.aleinfo.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.awanama.aleinfo.navigation.AppNavigation
import com.awanama.aleinfo.navigation.TopLevelDestination
import com.awanama.aleinfo.ui.navbar.NavBarNavigation
import com.awanama.aleinfo.ui.theme.AppTheme

@Composable
fun App() {
    AppTheme {
        val navController = rememberNavController()
        val navBackStackEntry = navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry.value?.destination?.route

        Scaffold(
            bottomBar = {
                if (currentRoute != TopLevelDestination.Login.route && currentRoute != TopLevelDestination.Register.route) {
                    NavBarNavigation(navController = navController)
                }
            }
        ) { innerPadding ->
            AppNavigation(
                modifier = Modifier.padding(innerPadding),
                navController = navController
            )
        }
    }
}