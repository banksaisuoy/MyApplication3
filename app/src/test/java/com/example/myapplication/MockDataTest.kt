package com.example.myapplication

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class MockDataTest {

    @Test
    fun listings_areNotEmpty() {
        val listings = MockData.listings
        assertTrue(listings.isNotEmpty())
    }

    @Test
    fun listings_haveValidData() {
        val listings = MockData.listings
        val firstListing = listings.first()

        assertEquals(1, firstListing.id)
        assertEquals("Premium Apartment", firstListing.title)
    }

    @Test
    fun userProfile_hasValidData() {
        val profile = MockData.userProfile

        assertEquals("Jane Doe", profile.name)
        assertEquals("jane.doe@example.com", profile.email)
    }
}
