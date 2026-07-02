package com.example.myapplication

import android.os.Build
import android.widget.TextView
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class ExampleUnitTest {
    @Test
    fun testMainActivityLaunchAndTextView() {
        ActivityScenario.launch(MainActivity::class.java).use { scenario ->
            scenario.onActivity { activity ->
                assertNotNull(activity)
                val textView = activity.findViewById<TextView>(R.id.textView)
                assertNotNull(textView)
                assertEquals("Hello World!", textView.text.toString())
            }
        }
    }
}
