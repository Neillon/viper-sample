package com.neillon.viper_sample.data

import android.content.Context
import androidx.lifecycle.LiveData
import com.neillon.viper_sample.data.entity.Note

class NoteRepository(context: Context) {
    private val db = NoteDatabase.getInstance(applicationContext = context)

    fun saveNote(note: Note): LiveData<Note> {

        val id = db.notesDao().insert(note)
        return db.notesDao().getById(id)
    }

    fun getAll(): LiveData<MutableList<Note>> = db.notesDao().getAll()
}