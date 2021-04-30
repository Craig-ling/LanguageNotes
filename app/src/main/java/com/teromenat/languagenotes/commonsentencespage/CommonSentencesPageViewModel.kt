package com.teromenat.languagenotes.commonsentencespage

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.teromenat.languagenotes.database.getDatabase
import com.teromenat.languagenotes.domain.CommonSentence
import com.teromenat.languagenotes.repository.LangNotesRepository
import kotlinx.coroutines.launch

class CommonSentencesPageViewModel(application: Application, languageKey: Int) : ViewModel() {

    private val database = getDatabase(application)
    private val repository = LangNotesRepository(database, languageKey)

    init {
        viewModelScope.launch {
            repository.insertCommonSentences(
                    listOf(CommonSentence(1, languageKey, "This is a sentence.")))
        }
    }

    // LiveData List
    val comSenList = repository.commonSentences

}

class CommonSentencesPageViewModelFactory(val app: Application, val languageKey: Int) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CommonSentencesPageViewModel::class.java)) {
            return CommonSentencesPageViewModel(app, languageKey) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
