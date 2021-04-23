package com.example.languagenotes.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CommonSentenceDao {
    @Query("SELECT * FROM common_sentence_table WHERE languageKey = :langKey")
    fun getCommonSentences(langKey: Int): LiveData<List<DatabaseCommonSentence>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllCommonSentences(vararg comSen: DatabaseCommonSentence)
}

@Database(entities = [DatabaseCommonSentence::class], version = 1, exportSchema = false)
abstract class LangNoteDatabase : RoomDatabase() {
    abstract val commonSentenceDao: CommonSentenceDao
}

private lateinit var INSTANCE: LangNoteDatabase

fun getDatabase(context: Context): LangNoteDatabase {
    synchronized(LangNoteDatabase::class.java) {
        if(!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(context.applicationContext,
                    LangNoteDatabase::class.java,
                    "LangNotes").build()
        }
    }
    return INSTANCE
}
