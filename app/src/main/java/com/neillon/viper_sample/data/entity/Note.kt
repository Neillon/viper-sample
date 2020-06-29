package com.neillon.viper_sample.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Note(
    @PrimaryKey
    @ColumnInfo(name = "note_id")
    val id: Long? = null,
    @ColumnInfo(name = "note_description")
    val description: String
)