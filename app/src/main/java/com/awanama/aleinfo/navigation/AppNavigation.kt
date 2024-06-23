package com.awanama.aleinfo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.awanama.aleinfo.ui.navbar.NavBar
import com.awanama.aleinfo.ui.screens.DetailScreen
import com.awanama.aleinfo.ui.screens.FavsRoute
import com.awanama.aleinfo.ui.screens.HomeRoute
import com.awanama.aleinfo.ui.screens.LoginRoute
import com.awanama.aleinfo.ui.screens.ProfileRoute
import com.awanama.aleinfo.ui.screens.RegisterRoute

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = TopLevelDestination.Login.route
    ) {

        composable(route = TopLevelDestination.Login.route) {
            LoginRoute { destination ->
                navController.navigate(destination)
            }
        }

        composable(route = TopLevelDestination.Register.route) {
            RegisterRoute { destination ->
                navController.navigate(destination)
            }
        }

        composable(route = TopLevelDestination.Home.route) {
            HomeRoute(
                navController = navController,
                onNavigateClick = { destination ->
                    navController.navigate(destination)
                }
            )
        }

        composable(
            route = TopLevelDestination.Detail.route,
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("beerId") ?: return@composable
            DetailScreen(beerId = id)
        }

        composable(route = NavBar.Favs.route) {
            FavsRoute(
                onNavigateClick = { destination ->
                    navController.navigate(destination)
                }
            )
        }

        composable(route = NavBar.Profile.route) {
            ProfileRoute(
                onNavigateClick = { destination ->
                    navController.navigate(destination)
                }
            )
        }
    }
}
