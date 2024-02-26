package com.example.phrasebook.ui.screen.phrase_category.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.phrasebook.ui.theme.PhrasebookTheme

@Preview(
    showSystemUi = true,
    showBackground = true,
)
@Composable
fun PhraseCategoryItemPreview() {
    PhrasebookTheme {
        PhraseCategoryItem(
            word = "Можно ли вернуть деньги если я не удовлетворен покупкой?",
            translate = "Ин мал хуш татӀайтӀа завай элкьуьр жедан?",
            isFavorite = false,
            onClickFavorite = {},
            onClickPhrase = {}
        )
    }
}

@Composable
fun PhraseCategoryItem(
    modifier: Modifier = Modifier,
    word: String,
    translate: String,
    isFavorite: Boolean,
    onClickFavorite: () -> Unit,
    onClickPhrase: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable(
                onClick = onClickPhrase
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            modifier = Modifier
                .weight(1f),
        ) {
            Text(
                text = word,
                color = Color.Black,
                fontSize = 18.sp,
            )
            Text(
                modifier = Modifier
                    .padding(top = 18.dp),
                text = translate,
                color = Color.Black,
                fontSize = 12.sp,
            )
        }
        Icon(
            modifier = Modifier
                .size(24.dp)
                .clickable(
                    onClick = onClickFavorite
                ),
            imageVector = if (!isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
            contentDescription = null,
            tint = Color(0xFFF44336),
        )
    }
}
