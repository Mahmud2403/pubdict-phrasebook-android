package com.example.phrasebook.base.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.phrasebook.ui.screen.phrase_category.navigation.category
import com.example.phrasebook.ui.screen.topic.navigation.TopicNavigation
import com.example.phrasebook.ui.screen.topic.navigation.topic

@Composable
fun PhrasebookNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    onNavigationToDestination: (destination: PhrasebookNavigationDestination, route: String?) -> Unit,
    onClickBack: () -> Unit
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = TopicNavigation.route
    ) {
        topic(
            navigateTo = onNavigationToDestination
        )

        category()
    }

}