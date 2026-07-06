package com.example.myapplication

data class Listing(val id: Int, val title: String, val description: String)
data class UserProfile(val name: String, val email: String)

object MockData {
    val listings = listOf(
        Listing(1, "Premium Apartment", "A beautiful 2 bedroom apartment in the city center."),
        Listing(2, "Cozy Studio", "Perfect for a single professional or student."),
        Listing(3, "Suburban House", "Spacious 4 bedroom house with a large backyard."),
        Listing(4, "Luxury Condo", "High-rise condo with spectacular city views and amenities."),
        Listing(5, "Rustic Cabin", "A quiet getaway in the woods.")
    )

    val userProfile = UserProfile("Jane Doe", "jane.doe@example.com")
}
