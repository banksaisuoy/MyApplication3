package com.example.myapplication

data class Item(val id: Int, val title: String, val description: String)

object MockData {
    val items = listOf(
        Item(1, "Fix Login Bug", "Investigate and fix the issue preventing users from logging in on Android 11."),
        Item(2, "Update Dependencies", "Update Gradle and all third-party libraries to their latest stable versions."),
        Item(3, "Implement Settings", "Add a new settings screen allowing users to toggle dark mode."),
        Item(4, "Write Unit Tests", "Achieve 80% code coverage on the core business logic module."),
        Item(5, "Refactor Networking", "Migrate from Volley to Retrofit for all API calls.")
    )

    val currentUser = mapOf(
        "name" to "Jane Doe",
        "email" to "jane.doe@example.com"
    )
}
