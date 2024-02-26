package com.example.phrasebook.ui.screen.topic.navigation

import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.phrasebook.base.navigation.PhrasebookNavigationDestination
import com.example.phrasebook.ui.screen.phrase_category.navigation.PhraseCategoryNavigation
import com.example.phrasebook.ui.screen.topic.TopicScreen
import com.example.phrasebook.ui.screen.topic.TopicViewModel

object TopicNavigation: PhrasebookNavigationDestination {
    override val route = "topic_route"
    override val destination = "topic_destination"

}


fun NavGraphBuilder.topic(
    navigateTo: (destination: PhrasebookNavigationDestination, route: String?) -> Unit,
) {
    composable(
        route = TopicNavigation.route,
    ) {
        val viewModel = hiltViewModel<TopicViewModel>()
        val uiState by viewModel.topicUiState.collectAsStateWithLifecycle()
        TopicScreen(
            uiState = uiState,
            onClickItem = { id ->
                navigateTo(
                    TopicNavigation,
                    PhraseCategoryNavigation.navigateWithArgument(id)
                )
            }
        )
    }
}