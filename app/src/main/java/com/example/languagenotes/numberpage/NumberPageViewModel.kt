package com.example.languagenotes.numberpage

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.languagenotes.languages.Language
import kotlin.random.Random

class NumberPageViewModel(inLang: Language): ViewModel() {

    private val numberMap = inLang.numbers

    private val _numberText = MutableLiveData<String>()
    val numberText: LiveData<String>
        get() = _numberText

    private val _genNumberBegin = MutableLiveData<Boolean>()
    val genNumberBegin: LiveData<Boolean>
        get() = _genNumberBegin

    fun setNumber(num: Int) {
        Log.i("NumberPageViewModel", "$num")
        Log.i("NumberPageViewModel", numberMap[num]?: "null")
        _numberText.value = numberMap[num]
    }

    fun beginGenerateNumber() {
        _genNumberBegin.value = true
    }

    fun endGenerateNumber() {
        _genNumberBegin.value = false
    }

    fun generateNumbers() : List<Int> {
        return listOf(Random.nextInt(0, 10), Random.nextInt(0,10))
    }

}