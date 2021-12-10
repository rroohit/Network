package com.k.network.presentation.components

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performTextClearance
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.text.input.KeyboardType
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.k.network.presentation.MainActivity
import com.k.network.presentation.util.TestTags.STANDARD_TEXT_FIELD
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class StandardTextFieldKtTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setup() {

    }


    @Test
    fun enterTooLongString_maxLengthNotExceed() {
        composeTestRule.setContent {
            var text by remember {
                mutableStateOf("")
            }

            MaterialTheme {
                StandardTextField(
                    text = text,
                    onValueChange = {
                        text = it
                    },
                    maxLength = 5,

                    )
            }
        }
        val expectedString = "aaaaa"

        composeTestRule.onNodeWithTag(STANDARD_TEXT_FIELD)
            .performTextClearance()

        composeTestRule.onNodeWithTag(STANDARD_TEXT_FIELD)
            .performTextInput(expectedString)

        composeTestRule.onNodeWithTag(STANDARD_TEXT_FIELD)
            .performTextInput("a")

        composeTestRule.onNodeWithTag(STANDARD_TEXT_FIELD)
            .assertTextEquals(expectedString)

    }

    @Test
    fun enterPassword_toggleVisibility_passwordVisible() {
        composeTestRule.setContent {
            var text by remember {
                mutableStateOf("")
            }

            MaterialTheme {
                StandardTextField(
                    text = text,
                    onValueChange = {
                        text = it
                    },
                    keyboardType = KeyboardType.Password,
                    maxLength = 5,

                    )
            }
        }

        composeTestRule.onNodeWithTag(STANDARD_TEXT_FIELD)
            .performTextInput("abcde")


    }


}