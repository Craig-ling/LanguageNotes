package com.example.languagenotes.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.languagenotes.domain.CommonSentence

@Entity(tableName = "common_sentence_table")
data class DatabaseCommonSentence (
        @PrimaryKey(autoGenerate = true)
        var senId: Long = 0L,
        var languageKey: Int,
        var sentence: String)

fun List<DatabaseCommonSentence>.changeToDomainModel(): List<CommonSentence> {
        return map {
                CommonSentence(
                        senId = it.senId,
                        languageKey = it.languageKey,
                        sentence = it.sentence)
        }
}