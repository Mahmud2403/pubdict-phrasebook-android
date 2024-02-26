package com.example.phrasebook.ui.screen.phrase_category

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.phrasebook.R
import com.example.phrasebook.common.PhrasebookTopAppBar
import com.example.phrasebook.common.Title
import com.example.phrasebook.ui.screen.phrase_category.components.PhraseCategoryItem
import com.example.phrasebook.ui.screen.search.SearchBar

@Composable
fun PhraseCategoryScreen(
    modifier: Modifier = Modifier,
    uiState: PhraseCategoryUiState,
    onClickFavourite: () -> Unit,
    onClickPhrase: (id: Int) -> Unit,
) {
    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .systemBarsPadding()
            .background(Color.White),
        topBar = {
            PhrasebookTopAppBar()
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = it.calculateTopPadding(),
                ),
        ) {
            item {
                Image(
                    modifier = Modifier
                        .fillMaxWidth(),
                    painter = painterResource(id = R.drawable.img),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Title(
                        text = ""
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
            item {
                SearchBar()
                Spacer(modifier = Modifier.height(16.dp))
            }
            item() {
                uiState.phrase?.results?.forEach { phrase ->
                    PhraseCategoryItem(
                        word = phrase.translations[0].translation,
                        translate = phrase.translations[1].translation,
                        onClickFavorite = onClickFavourite,
                        isFavorite = uiState.isFavorite,
                        onClickPhrase = {
                            onClickPhrase(phrase.id)
                        }
                    )
                }
            }
        }
    }
}