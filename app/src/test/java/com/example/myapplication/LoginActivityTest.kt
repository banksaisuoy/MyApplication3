package com.example.myapplication

import android.content.Intent
import android.os.Build
import android.view.ViewGroup
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import com.example.myapplication.databinding.ActivityLoginBinding
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.Config
import org.robolectric.RuntimeEnvironment

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class LoginActivityTest {

    @Test
    fun testLoginSuccess_transitionsToDashboard() {
        RuntimeEnvironment.getApplication().setTheme(R.style.Theme_MyApplication)
        ActivityScenario.launch(LoginActivity::class.java).use { scenario ->
            scenario.onActivity { activity ->
                val binding = ActivityLoginBinding.bind((activity.findViewById<ViewGroup>(android.R.id.content)).getChildAt(0))

                binding.usernameEditText.setText("testuser")
                binding.passwordEditText.setText("password123")
                binding.loginButton.performClick()

                val expectedIntent = Intent(activity, DashboardActivity::class.java)
                val actualIntent = shadowOf(ApplicationProvider.getApplicationContext<android.app.Application>()).nextStartedActivity

                assertNotNull("Expected an intent to be started", actualIntent)
                assertEquals(expectedIntent.component, actualIntent.component)
            }
        }
    }

    @Test
    fun testLoginFailure_showsErrors() {
        RuntimeEnvironment.getApplication().setTheme(R.style.Theme_MyApplication)
        ActivityScenario.launch(LoginActivity::class.java).use { scenario ->
            scenario.onActivity { activity ->
                val binding = ActivityLoginBinding.bind((activity.findViewById<ViewGroup>(android.R.id.content)).getChildAt(0))

                binding.usernameEditText.setText("")
                binding.passwordEditText.setText("")
                binding.loginButton.performClick()

                assertEquals("Username required", binding.usernameInputLayout.error)
                assertEquals("Password required", binding.passwordInputLayout.error)
            }
        }
    }
}
