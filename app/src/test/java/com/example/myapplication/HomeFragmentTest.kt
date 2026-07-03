package com.example.myapplication

import android.os.Build
import android.widget.TextView
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class HomeFragmentTest {

    private lateinit var fragment: HomeFragment
    private lateinit var activity: DashboardActivity

    @Before
    fun setUp() {
        activity = Robolectric.buildActivity(DashboardActivity::class.java)
            .create()
            .resume()
            .get()
        fragment = activity.supportFragmentManager.findFragmentById(R.id.fragment_container) as HomeFragment
    }

    @Test
    fun homeFragment_displaysWelcomeText() {
        val view = fragment.view
        assertNotNull(view)

        val tvWelcome = view?.findViewById<TextView>(R.id.tvWelcome)
        val tvSubtitle = view?.findViewById<TextView>(R.id.subtitleTextView)

        assertNotNull(tvWelcome)
        assertNotNull(tvSubtitle)
        assertEquals(fragment.getString(R.string.welcome_dashboard), tvWelcome?.text.toString())
        assertEquals(fragment.getString(R.string.welcome_subtitle), tvSubtitle?.text.toString())
    }
}
