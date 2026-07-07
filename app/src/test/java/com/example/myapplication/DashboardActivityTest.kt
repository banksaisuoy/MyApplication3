package com.example.myapplication

import android.os.Build
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class DashboardActivityTest {

    private lateinit var activity: DashboardActivity

    @Before
    fun setUp() {
        activity = Robolectric.buildActivity(DashboardActivity::class.java)
            .create()
            .resume()
            .get()
    }

    private fun getCurrentFragment(): Fragment? {
        return activity.supportFragmentManager.findFragmentById(R.id.fragment_container)
    }

    @Test
    fun dashboard_initiallyShowsHomeFragment() {
        val currentFragment = getCurrentFragment()
        assertTrue(currentFragment is HomeFragment)
    }

    @Test
    fun dashboard_clickingListNav_showsListFragment() {
        val bottomNav = activity.findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.selectedItemId = R.id.navigation_list
        activity.supportFragmentManager.executePendingTransactions()

        val currentFragment = getCurrentFragment()
        assertTrue(currentFragment is ListFragment)
    }

    @Test
    fun dashboard_clickingProfileNav_showsProfileFragment() {
        val bottomNav = activity.findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.selectedItemId = R.id.navigation_profile
        activity.supportFragmentManager.executePendingTransactions()

        val currentFragment = getCurrentFragment()
        assertTrue(currentFragment is ProfileFragment)
    }
}
