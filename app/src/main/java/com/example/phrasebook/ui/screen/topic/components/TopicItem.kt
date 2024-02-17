package com.example.phrasebook.ui.screen.topic.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.phrasebook.common.Title
import com.example.phrasebook.domain.models.Topic

@Composable
fun TopicItem(
    modifier: Modifier = Modifier,
    topic: Topic,
    onClickItem: () -> Unit,
) {
    ElevatedCard(
        modifier = Modifier
            .clickable(
                onClick = onClickItem,
            )
            .fillMaxWidth()
            .padding(
                horizontal = 8.dp,
                vertical = 4.dp
            ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
    ) {
        Column(
            modifier = modifier
                .padding(
                    horizontal = 10.dp,
                    vertical = 16.dp,
                )
        ) {
            Title(
                text = topic.title
            )
            Text(
                modifier = Modifier
                    .padding(
                        top = 8.dp,
                        bottom = 16.dp,
                    ),
                text = topic.subhead,
                fontSize = 12.sp,
                color = Color.Black,
            )
            Text(
                text = topic.content,
                color = Color.Black,
                fontSize = 12.sp,
            )
        }
    }
}