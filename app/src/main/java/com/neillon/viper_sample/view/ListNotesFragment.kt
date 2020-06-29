package com.neillon.viper_sample.view

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.neillon.viper_sample.R
import com.neillon.viper_sample.contracts.presenters.ListNotesPresenterContract
import com.neillon.viper_sample.contracts.views.ListNotesViewContract
import com.neillon.viper_sample.data.entity.Note
import com.neillon.viper_sample.interactor.NotesInteractor
import com.neillon.viper_sample.presenter.NoteNotesPresenter
import com.neillon.viper_sample.router.NotesAppRouter
import com.neillon.viper_sample.view.adapters.NotesAdapter
import kotlinx.android.synthetic.main.fragment_list_notes.*

class ListNotesFragment : Fragment(R.layout.fragment_list_notes), ListNotesViewContract {

    private val adapter: NotesAdapter by lazy { NotesAdapter() }

    private val interactor by lazy { NotesInteractor(requireActivity().applicationContext) }
    private val router by lazy { NotesAppRouter(requireActivity()) }
    private val listNotesPresenter: ListNotesPresenterContract by lazy {
        NoteNotesPresenter(
            this,
            router,
            interactor
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // RecyclerView init
        recyclerViewNotes.adapter = adapter
        recyclerViewNotes.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        buttonNewNote.setOnClickListener { listNotesPresenter.newNoteClick() }

        listNotesPresenter.onListNotesViewCreated()
    }

    override fun showLoading() {
        recyclerViewNotes.isVisible = false
        progressBarNotes.isVisible = true
        buttonNewNote.isVisible = false
        textViewError.isVisible = false
    }

    override fun hideLoading() {
        recyclerViewNotes.isVisible = true
        progressBarNotes.isVisible = false
        buttonNewNote.isVisible = true
        textViewError.isVisible = false
    }

    override fun displayNotes(notes: MutableList<Note>) {
        recyclerViewNotes.isVisible = true
        adapter.notes = notes
        progressBarNotes.isVisible = false
        buttonNewNote.isVisible = true
        textViewError.isVisible = false
    }

    override fun displayError(message: String) {
        textViewError.isVisible = true
        textViewError.text = message
        recyclerViewNotes.isVisible = false
        progressBarNotes.isVisible = false
        buttonNewNote.isVisible = true
    }

    override fun newNoteClicked() {
        listNotesPresenter.newNoteClick()
    }
}