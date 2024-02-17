package com.example.phrasebook.ui.screen.phrase_category.navigation

import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.phrasebook.base.navigation.PhrasebookNavigationDestination
import com.example.phrasebook.ui.screen.phrase_category.PhraseCategoryScreen
import com.example.phrasebook.ui.screen.phrase_category.PhraseCategoryViewModel

object PhraseCategoryNavigation: PhrasebookNavigationDestination {
    override val route = "category_route/{id}"
    override val destination = "category_destination"

    fun navigateWithArgument(id: Int) =
        "category_route/$id"
}

fun NavGraphBuilder.category(
) {
    composable(
        route = PhraseCategoryNavigation.route
    ) {
        val viewModel = hiltViewModel<PhraseCategoryViewModel>()
        val uiState by viewModel.phraseCategoryUiState.collectAsStateWithLifecycle()
        PhraseCategoryScreen(
            title = "Basic",
            uiState = uiState,
            onClickFavourite = {
                viewModel.setFavourite(
                    isFavourite = uiState.isFavorite
                )
            }
        )
    }
}