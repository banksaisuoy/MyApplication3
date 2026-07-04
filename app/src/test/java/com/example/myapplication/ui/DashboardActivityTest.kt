package com.example.myapplication.ui

import android.os.Build
import com.example.myapplication.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class DashboardActivityTest {

    @Test
    fun defaultFragment_isHomeFragment() {
        RuntimeEnvironment.getApplication().setTheme(R.style.Theme_MyApplication)
        val activity = Robolectric.buildActivity(DashboardActivity::class.java).create().start().resume().get()
        activity.supportFragmentManager.executePendingTransactions()

        val fragment = activity.supportFragmentManager.findFragmentById(R.id.fragmentContainer)
        assertTrue(fragment is HomeFragment)
    }

    @Test
    fun selectList_showsListFragment() {
        RuntimeEnvironment.getApplication().setTheme(R.style.Theme_MyApplication)
        val activity = Robolectric.buildActivity(DashboardActivity::class.java).create().start().resume().get()
        activity.supportFragmentManager.executePendingTransactions()

        val bottomNav = activity.findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNav.selectedItemId = R.id.nav_list
        activity.supportFragmentManager.executePendingTransactions()

        val fragment = activity.supportFragmentManager.findFragmentById(R.id.fragmentContainer)
        assertTrue(fragment is ListFragment)
    }

    @Test
    fun selectProfile_showsProfileFragment() {
        RuntimeEnvironment.getApplication().setTheme(R.style.Theme_MyApplication)
        val activity = Robolectric.buildActivity(DashboardActivity::class.java).create().start().resume().get()
        activity.supportFragmentManager.executePendingTransactions()

        val bottomNav = activity.findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNav.selectedItemId = R.id.nav_profile
        activity.supportFragmentManager.executePendingTransactions()

        val fragment = activity.supportFragmentManager.findFragmentById(R.id.fragmentContainer)
        assertTrue(fragment is ProfileFragment)
    }
}
