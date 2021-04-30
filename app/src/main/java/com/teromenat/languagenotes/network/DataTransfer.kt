package com.teromenat.languagenotes.network

import com.teromenat.languagenotes.database.DatabaseCommonSentence
import com.teromenat.languagenotes.domain.CommonSentence

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