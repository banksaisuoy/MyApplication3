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
class ProfileFragmentTest {

    private lateinit var fragment: ProfileFragment
    private lateinit var activity: DashboardActivity

    @Before
    fun setUp() {
        activity = Robolectric.buildActivity(DashboardActivity::class.java)
            .create()
            .resume()
            .get()

        // Navigate to ProfileFragment
        val bottomNav = activity.findViewById<com.google.android.material.bottomnavigation.BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.selectedItemId = R.id.navigation_profile
        activity.supportFragmentManager.executePendingTransactions()

        fragment = activity.supportFragmentManager.findFragmentById(R.id.fragment_container) as ProfileFragment
    }

    @Test
    fun profileFragment_displaysMockData() {
        val view = fragment.view
        assertNotNull(view)

        val tvName = view?.findViewById<TextView>(R.id.tvProfileName)
        val tvEmail = view?.findViewById<TextView>(R.id.tvProfileEmail)

        assertNotNull(tvName)
        assertNotNull(tvEmail)

        assertEquals(MockData.userProfile.name, tvName?.text.toString())
        assertEquals(MockData.userProfile.email, tvEmail?.text.toString())
    }
}
