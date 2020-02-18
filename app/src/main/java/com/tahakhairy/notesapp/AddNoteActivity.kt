package com.tahakhairy.notesapp

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.tahakhairy.notesapp.database.Note
import com.tahakhairy.notesapp.database.NoteDatabase
import kotlinx.android.synthetic.main.activity_add_note.*

class AddNoteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
        add_note_button.setOnClickListener {
            val noteTitle = note_name_edit_text.text.toString()
            val noteDescription = note_description_edit_text.text.toString()
            val noteDate = note_date_edit_text.text.toString()

            val note = Note(title = noteTitle, date = noteDate, description = noteDescription)
            NoteDatabase.getInstance(applicationContext)?.notesDao()?.insertNote(note)
            showSuccessMessage()
        }

    }

    private fun showSuccessMessage() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(R.string.note_created_successfully)
        builder.setPositiveButton(R.string.ok) { dialogInterface, _ ->
            dialogInterface.dismiss()
            finish()
        }
        builder.setCancelable(false)
        builder.show()
    }
}
