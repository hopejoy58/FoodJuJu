package com.example.foodjuju.ui.report

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ReportViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is the notifications fragment."
    }
    internal val text: LiveData<String> = _text
}