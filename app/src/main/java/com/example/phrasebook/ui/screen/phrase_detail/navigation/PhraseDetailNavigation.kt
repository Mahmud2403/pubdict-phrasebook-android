package com.example.phrasebook.ui.screen.phrase_detail.navigation

import android.content.Intent
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.example.phrasebook.base.navigation.PhrasebookNavigationDestination
import com.example.phrasebook.ui.screen.phrase_detail.PhraseDetailScreen
import com.example.phrasebook.ui.screen.phrase_detail.PhraseDetailViewModel

const val PhrasebookPhrase = "https://staging-api.publicdictionary.org/phrasebooks/phrase/"


object PhraseDetailNavigation: PhrasebookNavigationDestination {
    override val route = "phrase_detail_route/{id}"
    override val destination = "phrase_detail_destination"

    fun navigateWithRoute(id: Int) = "phrase_detail_route/$id"

}

fun NavGraphBuilder.phraseDetail(
    onClickBack: () -> Unit,
    navigateTo: (destination: PhrasebookNavigationDestination, route: String?) -> Unit,
) {
    composable(
        route = PhraseDetailNavigation.route,
        deepLinks = listOf(
            navDeepLink {
                uriPattern = "${PhrasebookPhrase}{id}"
                action = Intent.ACTION_VIEW
            }
        ),
        arguments = listOf(
            navArgument("id") { type = NavType.IntType }
        )
    ) {
        val id = requireNotNull(it.arguments?.getInt("id"))

        val viewModel = hiltViewModel<PhraseDetailViewModel>()
        val uiState by viewModel.phraseDetailUiState.collectAsStateWithLifecycle()

        LaunchedEffect(viewModel) {
            viewModel.getDetailPhrase(id)
        }

        PhraseDetailScreen(
            uiState = uiState,
        )
    }
}