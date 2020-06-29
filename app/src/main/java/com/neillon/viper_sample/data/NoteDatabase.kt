package com.neillon.viper_sample.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.neillon.viper_sample.data.entity.Note

@Database(
    entities = [Note::class],
    exportSchema = false,
    version = 1
)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun notesDao(): NoteDao

    companion object {
        private var instance: NoteDatabase? = null

        fun getInstance(applicationContext: Context): NoteDatabase {
            if (instance == null)
                instance = Room.databaseBuilder(
                    applicationContext,
                    NoteDatabase::class.java, "notes"
                )
                    .allowMainThreadQueries()
                    .build()

            return instance as NoteDatabase
        }
    }
}