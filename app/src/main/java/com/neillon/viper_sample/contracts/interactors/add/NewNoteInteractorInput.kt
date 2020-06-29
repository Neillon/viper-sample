package com.neillon.viper_sample.contracts.interactors.add

import androidx.lifecycle.LiveData
import com.neillon.viper_sample.data.entity.Note

interface NewNoteInteractorInput {
    fun saveNote(description: String)
}