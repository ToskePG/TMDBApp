package com.example.tmdbapp.core.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
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
    onSearched: () -> Unit
){
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = value,
            singleLine = true,
            shape = RoundedCornerShape(16.dp),
            isError = isError,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearched()
                }
            ),
            placeholder = {
                Text(text = placeholder, color = Gray)
            },
            trailingIcon = {
                IconButton(onClick = {
                    onSearched()
                }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        tint = White)
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
                onSearched = { /*TODO*/ },
                onTextChanged = {}
            )
        }
    }
}