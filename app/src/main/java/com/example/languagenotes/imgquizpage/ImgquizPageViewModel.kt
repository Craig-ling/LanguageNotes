package com.example.languagenotes.imgquizpage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.languagenotes.languages.Language
import kotlin.random.Random

class ImgquizPageViewModel(language: Language) : ViewModel() {

    private val wordImages = language.imageWordPairs
    var questionsAnswered = 0

    private var radioList = mutableListOf(1, 2, 3, 4)
    private val radioWordList = mutableListOf<String>()

    private val _totalQuestions = MutableLiveData<Int>()
    val totalQuestions: LiveData<Int>
        get() = _totalQuestions

    private val _correctCount = MutableLiveData<Int>().apply {
        value = 0
    }
    val correctCount: LiveData<Int>
        get() = _correctCount

    private val _imgWord = MutableLiveData<String>()
    val imgWord: LiveData<String>
        get() =_imgWord

    private val _wordList = MutableLiveData<MutableList<String>>()
    val wordList: LiveData<MutableList<String>>
        get() = _wordList

    private val _radioOne = MutableLiveData<String>()
    val radioOne: LiveData<String>
        get() = _radioOne

    private val _radioTwo = MutableLiveData<String>()
    val radioTwo: LiveData<String>
        get() = _radioTwo

    private val _radioThree = MutableLiveData<String>()
    val radioThree: LiveData<String>
        get() = _radioThree

    private val _radioFour = MutableLiveData<String>()
    val radioFour: LiveData<String>
        get() = _radioFour

    init {
        _totalQuestions.value = wordImages.size
        _wordList.value = wordImages.keys.toMutableList()
        initializeRadioWords()
        setupQuiz()
    }

    fun getWordMapValue(): String? {
        return wordImages[_imgWord.value]
    }

    fun incrementCorrect() {
        _correctCount.value?.let {
            _correctCount.value = _correctCount.value!! + 1
        }
    }

    fun incrementAnswered() {
        questionsAnswered++
    }

    fun setupQuiz() {
        assignRandomWord()
        assignRadioWords()
    }

    private fun assignRandomWord() {
        _imgWord.value = _wordList.value?.let { it[Random.nextInt(0, it.size)] }
        _wordList.value?.remove(_imgWord.value)
    }

    private fun assignRadioWords() {
        var radioList = shuffleList(radioList)
        _imgWord.value?.let { assignWordToRadio(radioList[0], wordImages[it]) }
        radioWordList.remove(_imgWord.value)
        var wordList = shuffleList(radioWordList)
        for (i in 1 until radioList.size) {
            assignWordToRadio(radioList[i], wordImages[wordList[i]])
        }
        _imgWord.value?.let { radioWordList.add(it) }
    }

    private fun assignWordToRadio(buttonNumber: Int, word: String?) {
        when (buttonNumber) {
            1 -> word?.let{_radioOne.value = it}
            2 -> word?.let{_radioTwo.value = it}
            3 -> word?.let{_radioThree.value = it}
            4 -> word?.let{_radioFour.value = it}
        }
    }

    private fun <T: Any> shuffleList(numList: MutableList<T>) : MutableList<T> {
        var shuffleCount = 10
        while (shuffleCount > 0) {
            var i = Random.nextInt(0, numList.size)
            var j = Random.nextInt(0, numList.size)
            numList[i] = numList[j].also{numList[j] = numList[i]}
            --shuffleCount
        }
        return numList
    }

    private fun initializeRadioWords() {
        for ((key) in wordImages) {
            radioWordList.add(key)
        }
    }
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