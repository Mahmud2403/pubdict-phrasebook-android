package com.example.phrasebook.common

import android.icu.text.CaseMap.Title
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun Title(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: TextUnit = 20.sp,
    fontWeight: FontWeight = FontWeight(600),
    color: Color = Color.Black
) {
    Text(
        text = text,
        fontSize = fontSize,
        fontWeight = fontWeight,
        color = color
    )
}