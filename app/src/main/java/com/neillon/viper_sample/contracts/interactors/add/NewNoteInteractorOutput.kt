package com.neillon.viper_sample.contracts.interactors.add

interface NewNoteInteractorOutput {
    fun onSaveSuccess()
    fun onSaveError(message: String)
}