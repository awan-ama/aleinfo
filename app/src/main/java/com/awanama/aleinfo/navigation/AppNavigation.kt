package com.awanama.aleinfo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.awanama.aleinfo.ui.navbar.NavBar
import com.awanama.aleinfo.ui.detail.DetailScreen
import com.awanama.aleinfo.ui.ranks.FavsRoute
import com.awanama.aleinfo.ui.home.HomeRoute
import com.awanama.aleinfo.ui.login.LoginRoute
import com.awanama.aleinfo.ui.profile.ProfileRoute
import com.awanama.aleinfo.ui.register.RegisterRoute

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
                onNavigateClick = { source ->
                    navController.navigate(TopLevelDestination.Detail.withArgs(source))
                }
            )
        }

        composable(
            route = TopLevelDestination.Detail.route,
            arguments = listOf(
                navArgument("beerId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val beerId = backStackEntry.arguments?.getInt("beerId") ?: return@composable
            DetailScreen(beerId = beerId)
        }

        composable(route = NavBar.Favs.route) {
            FavsRoute(
                onNavigateClick = { source ->
                    navController.navigate(TopLevelDestination.Detail.withArgs(source))
                }
            )
        }

        composable(route = NavBar.Profile.route) {
            ProfileRoute(
                onNavigateClick = { source ->
                    navController.navigate(TopLevelDestination.Detail.withArgs(source))
                }
            )
        }
    }
}
