package com.k.network.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.k.network.presentation.components.Post
import com.k.network.presentation.components.StandardScaffold
import com.k.network.presentation.components.StandardToolbar

@Composable
fun MainFeedScreen(
    navController: NavController
) {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        StandardToolbar(
            navController = navController,
            title = {
                Text(text = "Your Feed")
            },
            modifier = Modifier.fillMaxWidth(),
            showBackArrow = true,
            navActions = {

            }

        )

        Post(
            post = com.k.network.domain.models.Post(
                username = "rohit",
                imageUrl = "",
                profilePictureUrl = "",
                description = "When words become unclear, I shall focus with photographs. When images become inadequate, I shall be content with silence.",
                likeCount = 11,
                commentCount = 7
            )
        )
    }

}