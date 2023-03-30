package com.example.tmdbapp.presentation.splash

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
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tmdbapp.ui.theme.TMDBAppTheme

@Composable
fun SearchBar(
    value: String,
    placeholder: String,
    isError: Boolean,
    onSearch: () -> Unit,
    onTextChanged: (text: String) -> Unit
){
    Column{
        Text(text = "What do you want to watch?",
        color = White,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp)
        OutlinedTextField(
            modifier = Modifier
                .padding(all = 10.dp)
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
                Text(text = placeholder, color = White)
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
    
}

@Preview
@Composable
fun SearchBarPreview(){
    TMDBAppTheme {
        SearchBar(
            value = "Search",
            placeholder = "Search",
            isError = false,
            onSearch = { /*TODO*/ },
            onTextChanged = {println("Search")}
        )
    }
}