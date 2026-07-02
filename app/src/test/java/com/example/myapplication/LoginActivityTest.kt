package com.example.myapplication

import android.content.Intent
import android.os.Build
import android.widget.Button
import android.widget.EditText
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class LoginActivityTest {

    private lateinit var activity: LoginActivity

    @Before
    fun setUp() {
        activity = Robolectric.buildActivity(LoginActivity::class.java)
            .create()
            .resume()
            .get()
    }

    @Test
    fun login_withValidInput_startsDashboardActivity() {
        val usernameEditText = activity.findViewById<EditText>(R.id.etUsername)
        val passwordEditText = activity.findViewById<EditText>(R.id.etPassword)
        val loginButton = activity.findViewById<Button>(R.id.btnLogin)

        usernameEditText.setText("testuser")
        passwordEditText.setText("password")
        loginButton.performClick()

        val expectedIntent = Intent(activity, DashboardActivity::class.java)
        val actualIntent = shadowOf(activity).nextStartedActivity

        assertNotNull(actualIntent)
        assertEquals(expectedIntent.component, actualIntent.component)
    }

    @Test
    fun login_withEmptyInput_showsToastAndDoesNotStartDashboard() {
        val loginButton = activity.findViewById<Button>(R.id.btnLogin)
        loginButton.performClick()

        val actualIntent = shadowOf(activity).nextStartedActivity
        assertEquals(null, actualIntent)
    }
}
