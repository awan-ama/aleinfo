package com.awanama.aleinfo.ui.navbar

import com.awanama.aleinfo.R
import com.awanama.aleinfo.navigation.TopLevelDestination

sealed class NavBar(
    var title: String,
    var icon: Int,
    var route: String
) {
    object Home :
        NavBar(
            "Home",
            R.drawable.ale_home,
            TopLevelDestination.Home.route
        )

    object Favs :
        NavBar(
            "Favs",
            R.drawable.ale_favs,
            TopLevelDestination.Favs.route
        )

    object Profile :
        NavBar(
            "Profile",
            R.drawable.ale_profile,
            TopLevelDestination.Profile.route
        )
}