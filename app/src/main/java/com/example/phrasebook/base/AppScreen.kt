package com.example.phrasebook.base

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.phrasebook.base.navigation.PhrasebookNavHost

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppScreen(
    modifier: Modifier = Modifier,
    appState: PhrasebookAppState = rememberPhrasebookAppState()
) {
    Scaffold {
        PhrasebookNavHost(
            navController = appState.navController,
            onNavigationToDestination = appState::navigate,
            onClickBack = appState::onBackClick
        )
    }
}

