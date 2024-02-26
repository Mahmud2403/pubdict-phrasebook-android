package com.example.phrasebook.ui.screen.phrase_detail

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.phrasebook.common.PhrasebookTopAppBar
import com.example.phrasebook.data.network_source.models.PhraseDetailDto
import com.example.phrasebook.domain.models.PhraseDetail


@Preview(
    showSystemUi = true,
    showBackground = true,
)
@Composable
fun PhraseDetailScreenPreview() {
    PhraseDetailScreen(
        uiState = PhraseDetailUiState(
            phraseDetail = PhraseDetail.mockData
        )
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PhraseDetailScreen(
    modifier: Modifier = Modifier,
    uiState: PhraseDetailUiState,
) {
    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .systemBarsPadding(),
        topBar = {
            PhrasebookTopAppBar()
        },
        containerColor = Color.White
    ) {
        Column(
            modifier = Modifier
                .padding(
                    top = it.calculateTopPadding(),
                    start = 16.dp,
                    end = 16.dp,
                )
        ) {
            Text(
                text = "phrase: ${uiState.phraseDetail.translations[1].translation}",
                color = Color.Black,
            )
            Text(
                text = "translate: ${uiState.phraseDetail.translations[2].translation}",
                color = Color.Black,
            )
            Row {
                Text(
                    text = "en: ",
                    color = Color.Black,
                )
                uiState.phraseDetail.translations[1].phoneticsEn?.let {
                    Text(
                        text = "/$it/",
                        color = Color(0xFFB8491E),
                    )
                }
            }
            Row {
                Text(
                    text = "ipa: ",
                    color = Color.Black,
                )
                uiState.phraseDetail.translations[1].phoneticsIpa?.let {
                    Text(
                        text = "/$it/",
                        color = Color(0xFFB8491E),
                    )
                }
            }
        }
    }
}
