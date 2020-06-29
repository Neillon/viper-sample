package com.neillon.viper_sample.interactor

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.neillon.viper_sample.contracts.interactors.add.NewNoteInteractorInput
import com.neillon.viper_sample.contracts.interactors.list.NotesInteractorInput
import com.neillon.viper_sample.data.NoteRepository
import com.neillon.viper_sample.data.entity.Note
import com.neillon.viper_sample.exceptions.RequiredParameterException

class NotesInteractor(context: Context) : NotesInteractorInput, NewNoteInteractorInput {

    private val notes = MediatorLiveData<MutableList<Note>>()
    private val repository = NoteRepository(context)

    override fun getAll(): LiveData<MutableList<Note>> = repository.getAll()

    override fun saveNote(description: String) {
        if (description.isNullOrEmpty() || description.isNullOrBlank()) throw RequiredParameterException(
            description.javaClass.name
        )

        try {
            val note = Note(description = description)
            notes.addSource(repository.saveNote(note)) { note ->
                val aux = notes.value
                aux?.add(note)
                notes.value = aux
            }
        } catch (e: Exception) {
            throw e
        }
    }
}