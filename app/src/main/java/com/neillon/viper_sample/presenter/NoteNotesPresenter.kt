package com.neillon.viper_sample.presenter

import androidx.lifecycle.Observer
import com.neillon.viper_sample.contracts.interactors.list.NotesInteractorInput
import com.neillon.viper_sample.contracts.interactors.list.NotesInteractorOutput
import com.neillon.viper_sample.contracts.presenters.ListNotesPresenterContract
import com.neillon.viper_sample.contracts.router.RouterContract
import com.neillon.viper_sample.contracts.views.ListNotesViewContract
import com.neillon.viper_sample.data.entity.Note
import com.neillon.viper_sample.view.ListNotesFragment

class NoteNotesPresenter(
    private val listNotesView: ListNotesViewContract,
    private val router: RouterContract,
    private val notesNotesInteractor: NotesInteractorInput
) : ListNotesPresenterContract,
    NotesInteractorOutput {

    override fun onListNotesViewCreated() {
        listNotesView.showLoading()
        notesNotesInteractor.getAll().observe(listNotesView as ListNotesFragment, Observer { notes ->
            if (notes.isNullOrEmpty())
                onLoadNotesError()
            else
                onLoadNotesSuccess(notes)
        })
    }

    override fun newNoteClick() {
        router.navigateToSaveFragment()
    }

    override fun onLoadNotesSuccess(notes: MutableList<Note>) {
        listNotesView.hideLoading()
        listNotesView.displayNotes(notes)
    }

    override fun onLoadNotesError() {
        listNotesView.hideLoading()
        listNotesView.displayError("No notes found")
    }
}