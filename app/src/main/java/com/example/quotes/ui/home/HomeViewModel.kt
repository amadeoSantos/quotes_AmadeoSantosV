package com.example.quotes.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.AndroidEntryPoint


class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "rosi"
    }
    val text: LiveData<String> = _text
}