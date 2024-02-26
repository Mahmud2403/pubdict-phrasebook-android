package com.example.phrasebook.ui.screen.topic

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import com.example.phrasebook.ui.screen.topic.components.TopicItem

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TopicScreen(
    modifier: Modifier = Modifier,
    onClickItem: (id: Int) -> Unit,
    uiState: TopicUiState,
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding(),
        topBar = {
            PhrasebookTopAppBar()
        },
        containerColor = Color.White,
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(
                    top = it.calculateTopPadding()
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth(),
                painter = painterResource(id = R.drawable.img),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Title(
                    text = "Topics"
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn {
                item() {
                    uiState.categoryList?.results?.forEach { topic ->
                        TopicItem(
                            nameEn = topic.categoryTranslations[0].name,
                            nameRu = topic.categoryTranslations[1].name,
                            countPhrase = "${topic.countPhrases} phrase",
                            onClickItem = {
                                onClickItem(topic.id)
                            }
                        )
                    }
                }
            }
        }
    }
}