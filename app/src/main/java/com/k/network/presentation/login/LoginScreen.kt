package com.k.network.presentation.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.k.network.R
import com.k.network.presentation.components.StandardTextField
import com.k.network.presentation.ui.theme.SpaceLarge
import com.k.network.presentation.ui.theme.SpaceMedium
import com.k.network.presentation.util.Screen

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {

    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(SpaceLarge)
                .align(Alignment.Center),

            ) {
            //Title
            Text(
                text = stringResource(id = R.string.login),
                color = MaterialTheme.colors.onBackground,
                style = MaterialTheme.typography.h1
            )

            //Username-Email field
            Spacer(modifier = Modifier.height(SpaceLarge))
            StandardTextField(
                text = viewModel.usernameText.value,
                hint = stringResource(id = R.string.username_email),
                onValueChange = {
                    viewModel.setUsernameText(it)
                },
                error = viewModel.usernameError.value,
                keyboardType = KeyboardType.Email
            )

            //Password field
            Spacer(modifier = Modifier.height(SpaceMedium))
            StandardTextField(
                text = viewModel.passwordText.value,
                hint = stringResource(id = R.string.password),
                onValueChange = {
                    viewModel.setPasswordText(it)
                },
                keyboardType = KeyboardType.Password,
                showPasswordToggle = viewModel.showPassword.value,
                onPasswordToggleClick = {
                    viewModel.setShowPassword(it)
                },
                error = viewModel.passwordError.value,
            )

            //Log in Button
            Spacer(modifier = Modifier.height(SpaceLarge))
            Button(
                onClick = {
                          navController.navigate(Screen.MainFeedScreen.route)
                },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(text = stringResource(id = R.string.login))

            }


        }

        //Bottom sign up suggestion text
        Text(
            text = buildAnnotatedString {
                append(stringResource(id = R.string.dont_have_acc))
                append(" ")
                val signUP = stringResource(id = R.string.sign_up)
                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colors.primary
                    )
                ) {
                    append(signUP)

                }
            },
            style = MaterialTheme.typography.body1,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = SpaceLarge)
                .clickable {
                    navController.navigate(
                        Screen.RegisterScreen.route
                    )
                }
        )


    }


}