package com.neillon.viper_sample.contracts.interactors.list

import androidx.lifecycle.LiveData
import com.neillon.viper_sample.data.entity.Note

interface NotesInteractorInput {
    fun getAll(): LiveData<MutableList<Note>>
}