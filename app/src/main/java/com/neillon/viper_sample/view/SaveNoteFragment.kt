package com.neillon.viper_sample.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.neillon.viper_sample.R
import com.neillon.viper_sample.contracts.presenters.NewNotePresenterContract
import com.neillon.viper_sample.contracts.views.NewNoteViewContract
import com.neillon.viper_sample.interactor.NotesInteractor
import com.neillon.viper_sample.presenter.NewNotePresenter
import com.neillon.viper_sample.router.NotesAppRouter
import kotlinx.android.synthetic.main.fragment_save_note.*

class SaveNoteFragment : Fragment(R.layout.fragment_save_note), NewNoteViewContract {

    private val interactor by lazy { NotesInteractor(requireActivity().applicationContext) }
    private val router by lazy { NotesAppRouter(requireActivity()) }
    private val presenter: NewNotePresenterContract by lazy {
        NewNotePresenter(
            this,
            router,
            interactor
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonSaveNote.setOnClickListener {
            val description = editTextDescription.text.toString()
            presenter.saveNote(description = description)
        }
    }
}