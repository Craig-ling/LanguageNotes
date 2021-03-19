package com.example.languagenotes.numberpage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.languagenotes.languages.Language

class NumberPageViewModel(inLang: Language): ViewModel() {

    private val numberMap = inLang.numbers

    private val _numberText = MutableLiveData<String>()
    val numberText: LiveData<String>
        get() = _numberText

    fun setNumber(num: Int) {
        _numberText.value = numberMap[num]
    }


}