package com.tahakhairy.notesapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tahakhairy.notesapp.database.NoteDatabase
import kotlinx.android.synthetic.main.activity_notes.*

class NotesActivity : AppCompatActivity() {

    private lateinit var adapter: NoteAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)
        setSupportActionBar(toolbar)

        recyclerView = findViewById(R.id.recycler_view)
        adapter = NoteAdapter(null)
        viewManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL, false
        )

        recyclerView.adapter = adapter
        recyclerView.layoutManager = viewManager

        fab.setOnClickListener { view ->

            val intent = Intent(this@NotesActivity, AddNoteActivity::class.java)
            startActivity(intent)
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
        }


    }

    override fun onStart() {
        super.onStart()
        val notes = NoteDatabase.getInstance(applicationContext)?.notesDao()?.getAllNotes()
        adapter.setNotes(notes)
    }

}
