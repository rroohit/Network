package com.k.network.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.k.network.R
import com.k.network.domain.models.Post
import com.k.network.presentation.ui.theme.SpaceMedium
import com.k.network.presentation.ui.theme.SpaceSmall
import com.k.network.util.Constants.MAX_POST_DESCRIPTION_LINE

@Composable
fun Post(
    post: Post
) {

    Box(
        modifier = Modifier.fillMaxWidth()
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Image(
                painter = painterResource(id = R.drawable.unsplash),
                contentDescription = "Post Image"
            )
            Spacer(modifier = Modifier.height(SpaceSmall))
            ActionRaw(
                username = "Rohit",
                modifier = Modifier.fillMaxWidth(),
                onLikeClick = { isLiked ->

                },
                onUsernameClick = { username ->

                },
                onCommentClick = {},
                onShareClick = {}

            )
            Spacer(modifier = Modifier.height(SpaceSmall))

            Text(
                modifier = Modifier.padding(SpaceSmall, 0.dp, SpaceSmall, 0.dp),

                text = buildAnnotatedString {
                    append(post.description)
                    withStyle(
                        SpanStyle(
                        )
                    ) {
                        append(LocalContext.current.getString(R.string.read_more))
                    }
                },
                style = MaterialTheme.typography.body2,
                overflow = TextOverflow.Ellipsis,
                maxLines = MAX_POST_DESCRIPTION_LINE
            )

            Spacer(modifier = Modifier.height(SpaceSmall))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(SpaceSmall, 0.dp, SpaceSmall, 0.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(
                        id = R.string.liked_by,
                        post.likeCount
                    ),
                    fontSize = 17.sp,
                    style = MaterialTheme.typography.body2

                )

                Text(
                    text = stringResource(
                        id = R.string.x_comments,
                        post.commentCount
                    ),
                    fontSize = 17.sp,
                    style = MaterialTheme.typography.body2

                )

            }


        }

    }


}