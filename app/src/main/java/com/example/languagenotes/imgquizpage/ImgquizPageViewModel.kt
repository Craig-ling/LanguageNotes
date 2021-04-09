package com.example.languagenotes.imgquizpage

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.languagenotes.languages.Language
import kotlin.random.Random

class ImgquizPageViewModel(language: Language) : ViewModel() {

    private val wordImages = language.imageWordPairs

    private val _correctCount = MutableLiveData<Int>()
    val correctCount: LiveData<Int>
        get() = _correctCount

    private val _imgWord = MutableLiveData<String>()
    val imgWord: LiveData<String>
        get() =_imgWord

    private val _wordList = MutableLiveData<MutableList<String>>()
    val wordList: LiveData<MutableList<String>>
        get() = _wordList

    init {
        _correctCount.value = 0
        _wordList.value = wordImages.keys.toMutableList()
        assignRandomWord()
//        Log.i("ImgQuizFrag", toString(_wordList.value))
    }

    private fun assignRandomWord() {
        _imgWord.value = _wordList.value?.let{it[Random.nextInt(0, it.size)]}
        _wordList.value?.remove(_imgWord.value)
    }

    fun incrementCount() {
        _correctCount.value?.plus(_correctCount.value!!)
    }

//    private fun toString(mutableList: MutableList<String>): String {
//        var wordList = "["
//        for (each in mutableList) {
//            wordList += " $each"
//        }
//        wordList += "]"
//        return wordList
//    }

}

class ImgquizPageViewModelFactory(private val language: Language) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ImgquizPageViewModel::class.java)) {
            return ImgquizPageViewModel(language) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}