package com.example.myapplication.ui

import android.content.Intent
import android.os.Build
import com.example.myapplication.R
import org.junit.Assert.assertEquals
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

    @Test
    fun clickingLogin_shouldStartDashboardActivity() {
        RuntimeEnvironment.getApplication().setTheme(R.style.Theme_MyApplication)
        val activity = Robolectric.buildActivity(LoginActivity::class.java).create().visible().get()

        activity.findViewById<android.view.View>(R.id.loginButton).performClick()

        val expectedIntent = Intent(activity, DashboardActivity::class.java)
        val actualIntent = shadowOf(RuntimeEnvironment.getApplication()).nextStartedActivity

        assertEquals(expectedIntent.component, actualIntent.component)
    }
}
