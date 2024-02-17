package com.example.phrasebook.ui.screen.topic.navigation

import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.phrasebook.base.navigation.PhrasebookNavigationDestination
import com.example.phrasebook.ui.screen.phrase_category.navigation.PhraseCategoryNavigation
import com.example.phrasebook.ui.screen.topic.TopicScreen

object TopicNavigation: PhrasebookNavigationDestination {
    override val route = "topic_route/{id}"
    override val destination = "topic_destination"

}


fun NavGraphBuilder.topic(
    navigateTo: (destination: PhrasebookNavigationDestination, route: String?) -> Unit,
) {
    composable(
        route = TopicNavigation.route,
        arguments = listOf(
            navArgument("id") { type = NavType.IntType },
        ),
    ) {
        TopicScreen(
            onClickItem = { id ->
                navigateTo(
                    TopicNavigation,
                    PhraseCategoryNavigation.navigateWithArgument(id)
                )
            }
        )
    }
}