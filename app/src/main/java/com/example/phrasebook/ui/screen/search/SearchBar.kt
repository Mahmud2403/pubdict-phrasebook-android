package com.example.phrasebook.ui.screen.search

import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel


@Preview
@Composable
fun SearchBarPreview() {
    SearchBar(
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    viewModel: SearchViewModel = hiltViewModel()
) {
    val searchText = viewModel.searchText.collectAsState()
    val focusManager = LocalFocusManager.current
    val focusRequester = remember { FocusRequester() }


    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        TextField(
            modifier = Modifier
                .focusRequester(focusRequester)
                .fillMaxWidth(),
            value = searchText.value,
            onValueChange = viewModel::changeSearchText,
            interactionSource = remember { MutableInteractionSource() },
            keyboardActions = KeyboardActions(onSearch = {
                focusManager.clearFocus()
            }),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            label = {
                Text(text = "Search ...")
            },
            leadingIcon = {
                Icon(
                    modifier = Modifier
                        .padding(end = 8.dp),
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                )
            },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White,
                focusedLabelColor = Color(0xFFF44336),
                focusedLeadingIconColor = Color(0xFFF44336),
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
            )
        )
    }
}z