package com.example.phrasebook.base

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.phrasebook.base.navigation.PhrasebookNavigationDestination
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@Composable
fun rememberPhrasebookAppState(
    navController: NavHostController = rememberNavController(),
    systemUiController: SystemUiController = rememberSystemUiController()
): PhrasebookAppState {
    return remember(navController, systemUiController) {
        PhrasebookAppState(
            navController,
            systemUiController
        )
    }
}

@Stable
class PhrasebookAppState constructor(
    val navController: NavHostController,
    val systemUiController: SystemUiController,
) {
    val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

    fun navigate(destination: PhrasebookNavigationDestination, route: String? = null) {
        navController.navigate(route ?: destination.route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
//                inclusive = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    fun onBackClick() {
        navController.popBackStack()
    }
}

fun SystemUiController.setDefaultSystemUiController() {
    setSystemBarsColor(
        color = Color.Transparent,
        darkIcons = true,
    )
    setNavigationBarColor(Color.Black)
}