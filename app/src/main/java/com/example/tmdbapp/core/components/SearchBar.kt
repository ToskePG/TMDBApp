package com.example.tmdbapp.core.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tmdbapp.ui.theme.TMDBAppTheme

@Composable
fun SearchBar(
    value: String,
    placeholder: String,
    isError: Boolean,
    onTextChanged: (text: String) -> Unit,
    onSearch: () -> Unit
){
        OutlinedTextField(
            modifier = Modifier
                .padding(all = 16.dp)
                .fillMaxSize(),
            value = value,
            singleLine = true,
            shape = RoundedCornerShape(16.dp),
            isError = isError,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(
                onSearch = { onSearch() }
            ),
            placeholder = {
                Text(text = placeholder, color = Gray)
            },
            trailingIcon = {
                IconButton(onClick = { onSearch() }) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = null, tint = White)
                }
            },
            onValueChange = {onTextChanged(it)},
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = White,
                backgroundColor = Black,
                focusedBorderColor = White,
                unfocusedBorderColor = White,
                cursorColor = White
            )
        )
}

@Preview
@Composable
fun SearchBarPreview(){
    TMDBAppTheme {
        Column{
            SearchBar(
                value = "",
                placeholder = "Search for movies...",
                isError = false,
                onSearch = { /*TODO*/ },
                onTextChanged = {}
            )
        }
    }
}