package com.tahakhairy.notesapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class Note(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "note_id") val id: Int = 0,
    @ColumnInfo(name = "note_title") val title: String,
    @ColumnInfo(name = "note_description") val description: String,
    @ColumnInfo(name = "note_date") val date: String
)