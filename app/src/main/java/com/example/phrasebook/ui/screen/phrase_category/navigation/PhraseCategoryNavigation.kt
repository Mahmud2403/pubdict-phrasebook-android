package com.example.phrasebook.ui.screen.phrase_category.navigation

import android.content.Intent
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavType
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.example.phrasebook.base.navigation.PhrasebookNavigationDestination
import com.example.phrasebook.ui.screen.phrase_category.PhraseCategoryScreen
import com.example.phrasebook.ui.screen.phrase_category.PhraseCategoryViewModel
import com.example.phrasebook.ui.screen.phrase_detail.navigation.PhraseDetailNavigation

const val PhrasebookCategory = "https://staging-api.publicdictionary.org/phrasebooks/categories/"

object PhraseCategoryNavigation: PhrasebookNavigationDestination {
    override val route = "category_route/{id}"
    override val destination = "category_destination"

    fun navigateWithArgument(id: Int) =
        "category_route/$id"
}

fun NavGraphBuilder.category(
    navigateTo: (destination: PhrasebookNavigationDestination, route: String?) -> Unit,
) {
    composable(
        route = PhraseCategoryNavigation.route,
        deepLinks = listOf(
            navDeepLink {
                uriPattern = "${PhrasebookCategory}{id}"
                action = Intent.ACTION_VIEW
            }
        ),
        arguments = listOf(
            navArgument("id") {type = NavType.IntType}
        )
    ) {
        val id = requireNotNull(it.arguments?.getInt("id"))

        val viewModel = hiltViewModel<PhraseCategoryViewModel>()
        val uiState by viewModel.phraseCategoryUiState.collectAsStateWithLifecycle()
        
        LaunchedEffect(viewModel){
            viewModel.getPhrase(id)
        }
        PhraseCategoryScreen(
            uiState = uiState,
            onClickFavourite = {
                viewModel.setFavourite(
                    isFavourite = uiState.isFavorite
                )
            },
            onClickPhrase = { phraseId ->
                navigateTo (
                    PhraseCategoryNavigation,
                    PhraseDetailNavigation.navigateWithRoute(phraseId)
                )
            }
        )
    }
}