package com.example.myapplication

import android.os.Build
import androidx.recyclerview.widget.RecyclerView
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
class ListFragmentTest {

    private lateinit var fragment: ListFragment
    private lateinit var activity: DashboardActivity

    @Before
    fun setUp() {
        activity = Robolectric.buildActivity(DashboardActivity::class.java)
            .create()
            .resume()
            .get()

        // Navigate to ListFragment
        val bottomNav = activity.findViewById<com.google.android.material.bottomnavigation.BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.selectedItemId = R.id.navigation_list
        activity.supportFragmentManager.executePendingTransactions()

        fragment = activity.supportFragmentManager.findFragmentById(R.id.fragment_container) as ListFragment
    }

    @Test
    fun listFragment_displaysRecyclerViewWithMockData() {
        val view = fragment.view
        assertNotNull(view)

        val recyclerView = view?.findViewById<RecyclerView>(R.id.recyclerView)
        assertNotNull(recyclerView)

        val adapter = recyclerView?.adapter as ListAdapter
        assertNotNull(adapter)
        assertEquals(MockData.listings.size, adapter.itemCount)
    }
}
