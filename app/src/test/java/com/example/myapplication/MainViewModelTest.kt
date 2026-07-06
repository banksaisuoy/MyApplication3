package com.example.myapplication

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [33])
class MainViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun testItemsLiveData() {
        val viewModel = MainViewModel()

        // Observe LiveData to trigger updates
        viewModel.items.observeForever { }

        val items = viewModel.items.value
        assertNotNull("Items should not be null", items)
        assertEquals("Items size should match MockData", MockData.items.size, items?.size)
        assertEquals("First item should match MockData", MockData.items[0], items?.get(0))
    }

    @Test
    fun testCurrentUserLiveData() {
        val viewModel = MainViewModel()

        // Observe LiveData to trigger updates
        viewModel.currentUser.observeForever { }

        val user = viewModel.currentUser.value
        assertNotNull("Current user should not be null", user)
        assertEquals("User should match MockData", MockData.currentUser, user)
        assertEquals("User name should be Jane Doe", "Jane Doe", user?.get("name"))
        assertEquals("User email should be jane.doe@example.com", "jane.doe@example.com", user?.get("email"))
    }
}
