package com.awanama.aleinfo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.awanama.aleinfo.ui.detail.DetailRoute
import com.awanama.aleinfo.ui.navbar.NavBar
import com.awanama.aleinfo.ui.screens.FavsRoute
import com.awanama.aleinfo.ui.screens.HomeRoute
import com.awanama.aleinfo.ui.screens.LoginRoute
import com.awanama.aleinfo.ui.screens.ProfileRoute
import com.awanama.aleinfo.utility.Constants

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

//        composable(route = TopLevelDestination.Login.route) {
//            LoginRoute(
//                onNavigateClick = { source ->
//                    navController.navigate(TopLevelDestination.Login.withArgs(source))
//                }
//            )
//        }
//
//        composable(route = TopLevelDestination.Home.route) {
//            HomeRoute(
//                onNavigateClick = { source ->
//                    navController.navigate(TopLevelDestination.Detail.withArgs(source))
//                }
//            )
//        }

        composable(route = TopLevelDestination.Login.route) {
            LoginRoute { destination ->
                navController.navigate(destination)
            }
        }

        composable(route = TopLevelDestination.Home.route) {
            HomeRoute(
                onNavigateClick = { source ->
                    navController.navigate(TopLevelDestination.Detail.withArgs(source))
                }
            )
        }

        composable(route = TopLevelDestination.Detail.route + "/{${Constants.SOURCE}}",
            arguments = listOf(
                navArgument(Constants.SOURCE) {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val source = backStackEntry.arguments?.getString(Constants.SOURCE) ?: return@composable

            DetailRoute(
                source = source,
                onBackClick = { navController.popBackStack() }
            )
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