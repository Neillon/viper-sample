package com.neillon.viper_sample.contracts.interactors.list

import com.neillon.viper_sample.data.entity.Note

interface NotesInteractorOutput {
    fun onLoadNotesSuccess(notes: MutableList<Note>)
    fun onLoadNotesError()
}