package com.example.myapplication

import android.os.Build
import android.view.ViewGroup
import androidx.test.core.app.ActivityScenario
import com.example.myapplication.databinding.ActivityDashboardBinding
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.RuntimeEnvironment

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class DashboardActivityTest {

    @Test
    fun testDashboard_startsAtHomeFragment() {
        RuntimeEnvironment.getApplication().setTheme(R.style.Theme_MyApplication)
        ActivityScenario.launch(DashboardActivity::class.java).use { scenario ->
            scenario.onActivity { activity ->
                activity.supportFragmentManager.executePendingTransactions()
                val currentFragment = activity.supportFragmentManager.findFragmentById(R.id.fragmentContainer)
                assertTrue(currentFragment is HomeFragment)
            }
        }
    }

    @Test
    fun testDashboard_navigationToList() {
        RuntimeEnvironment.getApplication().setTheme(R.style.Theme_MyApplication)
        ActivityScenario.launch(DashboardActivity::class.java).use { scenario ->
            scenario.onActivity { activity ->
                val binding = ActivityDashboardBinding.bind((activity.findViewById<ViewGroup>(android.R.id.content)).getChildAt(0))
                binding.bottomNavigation.selectedItemId = R.id.nav_list

                activity.supportFragmentManager.executePendingTransactions()
                val currentFragment = activity.supportFragmentManager.findFragmentById(R.id.fragmentContainer)
                assertTrue(currentFragment is ListFragment)
            }
        }
    }
}
