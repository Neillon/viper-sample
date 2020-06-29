package com.neillon.viper_sample.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.neillon.viper_sample.data.entity.Note

@Dao
interface NoteDao {

    @Insert
    fun insert(note: Note): Long

    @Query(value = "SELECT * FROM notes")
    fun getAll(): LiveData<MutableList<Note>>

    @Query(value = "SELECT * FROM notes WHERE note_id = :id")
    fun getById(id: Long): LiveData<Note>

}