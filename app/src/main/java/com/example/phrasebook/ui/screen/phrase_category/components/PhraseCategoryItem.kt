package com.example.phrasebook.ui.screen.phrase_category.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.phrasebook.domain.models.PhraseCategory

@Composable
fun PhraseCategoryItem(
    modifier: Modifier = Modifier,
    phraseCategory: PhraseCategory,
    isFavorite: Boolean,
    onClickFavorite: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .padding(
                    vertical = 8.dp,
                    horizontal = 16.dp
                )
        ) {
            Text(
                text = phraseCategory.word,
                color = Color.Black,
                fontSize = 12.sp,
            )
            Row {
                Text(
                    text = phraseCategory.translate,
                    color = Color.Black,
                    fontSize = 12.sp,
                )
                Text(
                    text = phraseCategory.transcription,
                    color = Color.Black,
                    fontSize = 12.sp,
                )
            }
        }
        Icon(
            modifier = Modifier
                .clickable(
                    onClick = onClickFavorite
                ),
            imageVector = if(isFavorite) Icons.Filled.Favorite else Icons.Outlined.Favorite,
            contentDescription = null,
            tint = Color(0xFFF44336),
        )
    }
}