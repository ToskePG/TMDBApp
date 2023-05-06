package com.example.tmdbapp.core.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.tmdbapp.core.navigation.Screen

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
        backgroundColor = Gray2,
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
@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    TMDBAppTheme {
        BottomNavigationBar(
            navController = rememberNavController(),
            onItemClick = {}
        )
    }
}