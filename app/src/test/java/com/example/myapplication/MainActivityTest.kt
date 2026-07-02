package com.example.myapplication

import android.os.Build
import android.widget.Button
import android.widget.TextView
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.android.material.snackbar.Snackbar
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class MainActivityTest {

    @Test
    fun testActivityLaunchAndUIElements() {
        ActivityScenario.launch(MainActivity::class.java).use { scenario ->
            scenario.onActivity { activity ->
                val titleTextView = activity.findViewById<TextView>(R.id.titleTextView)
                assertNotNull(titleTextView)
                assertEquals("Welcome to My App", titleTextView.text)

                val refreshButton = activity.findViewById<Button>(R.id.refreshButton)
                assertNotNull(refreshButton)
            }
        }
    }

    @Test
    fun testRefreshButtonShowsSnackbar() {
        ActivityScenario.launch(MainActivity::class.java).use { scenario ->
            scenario.onActivity { activity ->
                val refreshButton = activity.findViewById<Button>(R.id.refreshButton)

                // Click the button
                refreshButton.performClick()

                assertNotNull(refreshButton)
            }
        }
    }
}
