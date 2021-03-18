package com.example.languagenotes.numberpage

import androidx.lifecycle.ViewModel
import com.example.languagenotes.languages.Language

class NumberPageViewModel(private val inLang: Language): ViewModel() {

    fun returnNumber() : String? {
        return inLang.numbers[12]
    }

}