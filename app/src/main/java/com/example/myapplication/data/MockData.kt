package com.example.myapplication.data

object MockData {
    val listItems = listOf(
        ListItem("Item 1", "Description for item 1"),
        ListItem("Item 2", "Description for item 2"),
        ListItem("Item 3", "Description for item 3"),
        ListItem("Item 4", "Description for item 4"),
        ListItem("Item 5", "Description for item 5")
    )

    val userProfile = UserProfile(
        name = "John Doe",
        email = "john.doe@example.com",
        bio = "Software Engineer with a passion for beautiful UI/UX."
    )
}

data class ListItem(val title: String, val description: String)
data class UserProfile(val name: String, val email: String, val bio: String)
