package com.example.tmdbapp.presentation.movie

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tmdbapp.R
import com.example.tmdbapp.ui.theme.TMDBAppTheme

@Composable
fun Toolbar(
    onArrowClicked : () -> Unit,
    onFavClick : () -> Unit
){
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        IconButton(
            onClick = { onArrowClicked() },
            content = {
                Icon(
                    painter = painterResource(id =  R.drawable.back_arrow_ic),
                    contentDescription = null,
                    tint = Color.White
                )
            }
        )
        Text(
            modifier = Modifier
                .padding(top = 16.dp),
            text = stringResource(id = R.string.detail),
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        IconButton(
            onClick = { onFavClick() },
            content = {
                Icon(
                    painter = painterResource(id =  R.drawable.bookmark_true_ic),
                    contentDescription = null,
                    tint = Color.White
                )
            }
        )
    }
}

@Preview
@Composable
fun ToolbarComponentPreview(){
    TMDBAppTheme {
        Toolbar(onArrowClicked = { /*TODO*/ }) {
            
        }
    }
}