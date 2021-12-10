package com.k.network.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import com.k.network.presentation.util.TestTags.PASSWORD_TOGGLE
import com.k.network.presentation.util.TestTags.STANDARD_TEXT_FIELD

@Composable
fun StandardTextField(
    text: String = "",
    hint: String = "",
    maxLength: Int = 5,
    onValueChange: (String) -> Unit,
    error: String = "",
    keyboardType: KeyboardType = KeyboardType.Text,
    isPasswordToggleEnabled: Boolean = keyboardType == KeyboardType.Password,
    showPasswordToggle: Boolean = false,
    onPasswordToggleClick: (Boolean) -> Unit = {},
) {
    val toggleOff = Icons.Filled.VisibilityOff
    val toggleOn = Icons.Filled.Visibility


    Column {

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .semantics {
                    testTag = STANDARD_TEXT_FIELD
                },
            value = text,
            placeholder = {
                Text(text = hint, style = MaterialTheme.typography.body1)
            },
            onValueChange = {
                if (it.length <= maxLength) {
                    onValueChange(it)
                }
            },
            isError = error != "",
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            singleLine = true,
            trailingIcon = {
                if (isPasswordToggleEnabled) {
                    IconButton(
                        onClick = {
                            onPasswordToggleClick(showPasswordToggle)

                        },
                        modifier = Modifier.semantics {
                            testTag = PASSWORD_TOGGLE
                        }
                    ) {
                        Icon(
                            imageVector = if (showPasswordToggle) toggleOff else toggleOn,
                            contentDescription = "password hide/show Toggle "
                        )
                    }
                }
            },
            visualTransformation = if (!showPasswordToggle && isPasswordToggleEnabled) PasswordVisualTransformation()
            else VisualTransformation.None


        )

        //Error text below text edit text field
        if (error.isNotEmpty()) {
            Text(
                text = error,
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth()
            )
        }

    }


}