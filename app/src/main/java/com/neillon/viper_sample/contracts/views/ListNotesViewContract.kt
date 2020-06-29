package com.neillon.viper_sample.contracts.views

import com.neillon.viper_sample.data.entity.Note

interface ListNotesViewContract {
    fun showLoading()
    fun hideLoading()
    fun displayNotes(notes: MutableList<Note>)
    fun displayError(message: String)
    fun newNoteClicked()
}