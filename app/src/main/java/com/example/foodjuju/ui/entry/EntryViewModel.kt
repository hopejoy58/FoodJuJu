package com.example.foodjuju.ui.entry

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EntryViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is the entry Fragment"
    }
    val text: LiveData<String> = _text
}