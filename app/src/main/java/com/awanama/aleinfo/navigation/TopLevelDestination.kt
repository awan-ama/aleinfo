package com.awanama.aleinfo.navigation

sealed class TopLevelDestination(
    val title: String,
    val route: String
) {

    data object Login : TopLevelDestination(
        title = "Login",
        route = "login"
    )
    data object Register : TopLevelDestination(
        title = "Register",
        route = "register"
    )
    data object Home : TopLevelDestination(
        title = "Home",
        route = "home"
    )

    data object Detail : TopLevelDestination(
        title = "Detail",
        route = "detail/{beerId}"
    ) {
        fun createRoute(beerId: Int): String {
            return "detail/$beerId"
        }
    }

    data object Favs : TopLevelDestination(
        title = "Favs",
        route = "favs"
    )

    data object Profile : TopLevelDestination(
        title = "Profile",
        route = "profile"
    )

    fun withArgs(vararg args: Any): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
