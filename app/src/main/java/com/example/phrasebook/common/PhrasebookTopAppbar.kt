package com.example.phrasebook.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.phrasebook.R


@Preview
@Composable
fun PhrasebookTopAppBarPreview() {
    PhrasebookTopAppBar()
}

@Composable
fun PhrasebookTopAppBar(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color(0xFFF44336)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier
                .padding(
                    horizontal = 16.dp,
                    vertical = 16.dp
                )
                .size(36.dp),
            painter = painterResource(id = R.drawable.mountains),
            contentDescription = null,
            tint = Color.White,
        )
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "Dagestan",
                color = Color.White,
                fontSize = 18.sp
            )
            Text(
                text = "Phrasebook",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Icon(
            modifier = Modifier
                .padding(horizontal = 36.dp),
            imageVector = Icons.Rounded.MoreVert,
            contentDescription = null,
            tint = Color.White
        )
    }
}