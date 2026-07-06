package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _items = MutableLiveData<List<Item>>()
    val items: LiveData<List<Item>> = _items

    private val _currentUser = MutableLiveData<Map<String, String>>()
    val currentUser: LiveData<Map<String, String>> = _currentUser

    init {
        loadData()
    }

    private fun loadData() {
        _items.value = MockData.items
        _currentUser.value = MockData.currentUser
    }
}
