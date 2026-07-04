package com.example.myapplication

import android.os.Build
import com.example.myapplication.ui.DashboardActivity
import com.example.myapplication.ui.HomeFragment
import com.example.myapplication.ui.ListFragment
import com.example.myapplication.ui.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class DashboardActivityTest {

    private lateinit var activity: DashboardActivity
    private lateinit var bottomNav: BottomNavigationView

    @Before
    fun setUp() {
        RuntimeEnvironment.getApplication().setTheme(R.style.Theme_MyApplication)
        activity = Robolectric.buildActivity(DashboardActivity::class.java)
            .create()
            .start()
            .resume()
            .get()
        bottomNav = activity.findViewById(R.id.bottomNav)
    }

    @Test
    fun `initial fragment is HomeFragment`() {
        val currentFragment = activity.supportFragmentManager.findFragmentById(R.id.fragmentContainer)
        assertTrue(currentFragment is HomeFragment)
    }

    @Test
    fun `click on List nav item switches to ListFragment`() {
        bottomNav.selectedItemId = R.id.nav_list
        activity.supportFragmentManager.executePendingTransactions()
        val currentFragment = activity.supportFragmentManager.findFragmentById(R.id.fragmentContainer)
        assertTrue(currentFragment is ListFragment)
    }

    @Test
    fun `click on Profile nav item switches to ProfileFragment`() {
        bottomNav.selectedItemId = R.id.nav_profile
        activity.supportFragmentManager.executePendingTransactions()
        val currentFragment = activity.supportFragmentManager.findFragmentById(R.id.fragmentContainer)
        assertTrue(currentFragment is ProfileFragment)
    }
}
