package com.tahakhairy.notesapp.database

import androidx.room.*


@Dao
interface NoteDao {

    @Insert
    fun insertNote(note: Note)

    @Update
    fun updateNote(note: Note)

    @Delete
    fun deleteNote(note: Note)

    @Query("DELETE from note_table")
    fun deleteAllNotes(notes: List<Note>)

    @Query("SELECT * from note_table ORDER BY note_date DESC")
    fun getAllNotes(): List<Note>

    @Query("SELECT * from note_table WHERE note_description like :query")
    fun searchNoteByDescription(query: String): List<Note>

    @Query("DELETE from note_table WHERE note_id= :id")
    fun deleteNoteById(id: Int)
}