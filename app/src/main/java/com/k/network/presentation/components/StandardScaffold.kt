package com.k.network.presentation.components


import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.k.network.domain.models.BottomNavItem
import com.k.network.presentation.util.Screen

private val bottomNavItemList = listOf(
    BottomNavItem(
        route = Screen.MainFeedScreen.route,
        icon = Icons.Outlined.Home,
        contentDescription = "Home"
    ),
    BottomNavItem(
        route = Screen.ChatScreen.route,
        icon = Icons.Outlined.Chat,
        contentDescription = "Chat"
    ),
    //add post
    BottomNavItem(
        route = Screen.CreatePostScreen.route,
        icon = Icons.Outlined.Add,
        contentDescription = "Create Post"
    ),
    BottomNavItem(
        route = Screen.ActivityScreen.route,
        icon = Icons.Outlined.Notifications,
        contentDescription = "Activity"
    ),
    BottomNavItem(
        route = Screen.ProfileScreen.route,
        icon = Icons.Outlined.Person,
        contentDescription = "Person"
    )
)

@Composable
fun StandardScaffold(
    navController: NavController,
    modifier: Modifier = Modifier,
    showBottomBar: Boolean = true,
    bottomNavItems: List<BottomNavItem> = bottomNavItemList,
    content: @Composable () -> Unit
) {
    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                BottomNavigation(
                    backgroundColor = MaterialTheme.colors.surface,

                    ) {
                    bottomNavItems.forEachIndexed { i, bottomNavItem ->
                        StandardBottomNavItem(
                            icon = bottomNavItem.icon,
                            contentDescription = bottomNavItem.contentDescription,
                            selected = bottomNavItem.route == navController.currentDestination?.route,
                            alertCount = bottomNavItem.alertCount,
                            enabled = bottomNavItem.icon != null

                        ) {
                            if (navController.currentDestination?.route != bottomNavItem.route) {
                                navController.navigate(bottomNavItem.route)
                            }

                        }

                    }


                }
            }
        },
        modifier = modifier,


        ) {
        content()
    }

}