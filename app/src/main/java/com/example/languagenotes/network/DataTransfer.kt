package com.example.languagenotes.network

import com.example.languagenotes.database.DatabaseCommonSentence
import com.example.languagenotes.domain.CommonSentence

/**
 *  Temporary
 */
fun List<CommonSentence>.changeToDatabaseModel(): Array<DatabaseCommonSentence> {
    return map {
        DatabaseCommonSentence(
                senId = it.senId,
                languageKey = it.languageKey,
                sentence = it.sentence)
    }.toTypedArray()
}