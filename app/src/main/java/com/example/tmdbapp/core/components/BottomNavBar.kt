package com.example.tmdbapp.core.components

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.tmdbapp.core.navigation.Screen
import com.example.tmdbapp.domain.model.BottomNavItem
import com.example.tmdbapp.ui.theme.DarkBlue

@Composable
fun BottomNavBar(
    navController: NavController,
    onItemClick: (BottomNavItem) -> Unit
) {
    val items = listOf(
        BottomNavItem(
            route = Screen.HomeScreen.route,
            icon = Screen.HomeScreen.icon,
            text = Screen.HomeScreen.text
        ),
        BottomNavItem(
            route = Screen.SearchScreen.route,
            icon = Screen.SearchScreen.icon,
            text = Screen.SearchScreen.text
        ),
        BottomNavItem(
            route = Screen.WatchListScreen.route,
            icon = Screen.WatchListScreen.icon,
            text = Screen.WatchListScreen.text
        )
    )
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        backgroundColor = DarkBlue,
        elevation = 5.dp
    ) {
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = {
                    onItemClick(item)
                },
                selectedContentColor = Blue,
                unselectedContentColor = LightGray,
                icon = {
                    if (item.icon != null)
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                },
                label = { Text(text = item.text) }
            )
        }
    }
}