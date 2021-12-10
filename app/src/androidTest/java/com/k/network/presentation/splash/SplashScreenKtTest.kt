package com.k.network.presentation.splash

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.navigation.NavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.k.network.presentation.MainActivity
import com.k.network.presentation.ui.theme.NetworkTheme
import com.k.network.presentation.util.Screen
import com.k.network.util.Constants
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class SplashScreenKtTest {

    @get: Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @RelaxedMockK
    lateinit var navController: NavController

    private val testDispatcher = TestCoroutineDispatcher()


    @Before
    fun setup(){
        MockKAnnotations.init(this)
    }

    @Test
    fun splash_screen_displayAndDisappear() = testDispatcher.runBlockingTest {
        composeTestRule.setContent {
            NetworkTheme {
                SplashScreen(
                    navController = navController,
                    dispatcher = testDispatcher
                )            }
        }

        composeTestRule
            .onNodeWithContentDescription("Logo")
            .assertExists()

        advanceTimeBy(Constants.SPLASH_SCREEN_DURATION)

        verify {
            navController.popBackStack()
            navController.navigate(Screen.LoginScreen.route)
        }

    }

}