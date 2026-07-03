package com.example.myapplication

import android.os.Build
import android.widget.FrameLayout
import android.widget.TextView
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.RuntimeEnvironment

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class ListAdapterTest {

    private lateinit var adapter: ListAdapter

    @Before
    fun setUp() {
        RuntimeEnvironment.getApplication().setTheme(R.style.Theme_MyApplication)
        adapter = ListAdapter()
    }

    @Test
    fun adapter_bindsListingDataCorrectly() {
        val listings = listOf(
            Listing(1, "Test Title", "Test Description")
        )
        adapter.submitList(listings)

        // Ensure list is submitted before creating viewholder
        val parent = FrameLayout(RuntimeEnvironment.getApplication())
        val viewHolder = adapter.onCreateViewHolder(parent, adapter.getItemViewType(0))
        adapter.onBindViewHolder(viewHolder, 0)

        val titleTextView = viewHolder.binding.tvItemTitle
        val descTextView = viewHolder.binding.tvItemDescription

        assertEquals("Test Title", titleTextView.text.toString())
        assertEquals("Test Description", descTextView.text.toString())
    }
}
