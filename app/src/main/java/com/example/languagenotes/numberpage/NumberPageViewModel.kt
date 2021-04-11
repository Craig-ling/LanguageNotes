package com.example.languagenotes.numberpage

import android.util.Log
import android.view.View
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.languagenotes.languages.Language
import kotlin.random.Random

class NumberPageViewModel(language: Language): ViewModel() {

    private val numberMap = language.numbers

    private val _numberText = MutableLiveData<String>().apply {
        value = numberMap[0]
    }
    val numberText: LiveData<String>
        get() = _numberText

    private val _genNumberBegin = MutableLiveData<Boolean>()
    val genNumberBegin: LiveData<Boolean>
        get() = _genNumberBegin

    private val _numberTextVisible = MutableLiveData<Boolean>()
    val numberTextVisible: LiveData<Boolean>
        get() = _numberTextVisible

    fun setNumberText(num: Int) {
        _numberText.value = numberMap[num]
    }

    fun beginGenerateNumber() {
        _genNumberBegin.value = true
        hideNumberText()
    }

    fun endGenerateNumber() {
        _genNumberBegin.value = false
    }

    fun generateNumbers() : List<Int> {
        return listOf(Random.nextInt(0, 10), Random.nextInt(0,10))
    }

    fun hideNumberText() {
        _numberTextVisible.value = false
    }

    fun revealNumberText() {
        _numberTextVisible.value = true
    }
}

class NumberPageViewModelFactory(private val language: Language) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NumberPageViewModel::class.java)) {
            return NumberPageViewModel(language) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}