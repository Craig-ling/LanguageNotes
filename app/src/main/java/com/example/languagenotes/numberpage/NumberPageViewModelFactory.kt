package com.example.languagenotes.numberpage

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.languagenotes.languages.Language

class NumberPageViewModelFactory(private val language: Language) : ViewModelProvider.Factory {
        @Suppress("unchecked_cast")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(NumberPageViewModel::class.java)) {
                return NumberPageViewModel(language) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
}