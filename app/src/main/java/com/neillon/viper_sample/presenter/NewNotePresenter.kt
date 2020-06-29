package com.neillon.viper_sample.presenter

import android.widget.Toast
import com.neillon.viper_sample.contracts.interactors.add.NewNoteInteractorInput
import com.neillon.viper_sample.contracts.interactors.add.NewNoteInteractorOutput
import com.neillon.viper_sample.contracts.presenters.NewNotePresenterContract
import com.neillon.viper_sample.contracts.router.RouterContract
import com.neillon.viper_sample.contracts.views.NewNoteViewContract
import com.neillon.viper_sample.view.SaveNoteFragment

class NewNotePresenter(
    private val view: NewNoteViewContract,
    private val router: RouterContract,
    private val interactor: NewNoteInteractorInput
) : NewNotePresenterContract, NewNoteInteractorOutput {

    override fun saveNote(description: String) {
        try {
            interactor.saveNote(description)
            onSaveSuccess()
        } catch (e: Exception) {
            onSaveError(e.localizedMessage)
        }
    }

    override fun onSaveSuccess() {
        router.navigateBack()
    }

    override fun onSaveError(message: String) {
        Toast.makeText((view as SaveNoteFragment).context, message, Toast.LENGTH_SHORT).show()
    }
}