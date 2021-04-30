package com.teromenat.languagenotes.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.teromenat.languagenotes.database.LangNoteDatabase
import com.teromenat.languagenotes.database.changeToDomainModel
import com.teromenat.languagenotes.domain.CommonSentence
import com.teromenat.languagenotes.network.changeToDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LangNotesRepository(private val database: LangNoteDatabase, val languageKey: Int) {

    val commonSentences: LiveData<List<CommonSentence>> =
            Transformations.map(database.commonSentenceDao.getCommonSentences(languageKey)) {
                it.changeToDomainModel()
            }

    suspend fun insertCommonSentences(listComSen: List<CommonSentence>) {
        withContext(Dispatchers.IO) {
            database.commonSentenceDao.insertAllCommonSentences(*listComSen.changeToDatabaseModel())
        }
    }

}