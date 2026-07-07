package com.example.myapplication

import android.content.Intent
import android.os.Build
import android.widget.Button
import com.example.myapplication.ui.DashboardActivity
import com.example.myapplication.ui.LoginActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class LoginActivityTest {

    private lateinit var activity: LoginActivity

    @Before
    fun setUp() {
        RuntimeEnvironment.getApplication().setTheme(R.style.Theme_MyApplication)
        activity = Robolectric.buildActivity(LoginActivity::class.java)
            .create()
            .resume()
            .get()
    }

    @Test
    fun `login with empty fields shows errors`() {
        val loginButton = activity.findViewById<Button>(R.id.btnLogin)
        val emailInputLayout = activity.findViewById<TextInputLayout>(R.id.tilEmail)
        val passwordInputLayout = activity.findViewById<TextInputLayout>(R.id.tilPassword)

        loginButton.performClick()

        assertEquals("Email is required", emailInputLayout.error)
        assertEquals("Password is required", passwordInputLayout.error)
    }

    @Test
    fun `login with valid fields starts DashboardActivity`() {
        val emailEditText = activity.findViewById<TextInputEditText>(R.id.etEmail)
        val passwordEditText = activity.findViewById<TextInputEditText>(R.id.etPassword)
        val loginButton = activity.findViewById<Button>(R.id.btnLogin)

        emailEditText.setText("test@example.com")
        passwordEditText.setText("password123")
        loginButton.performClick()

        val expectedIntent = Intent(activity, DashboardActivity::class.java)
        val actualIntent = shadowOf(activity).nextStartedActivity

        assertNotNull(actualIntent)
        assertEquals(expectedIntent.component, actualIntent.component)
        assertTrue(activity.isFinishing)
    }
}
