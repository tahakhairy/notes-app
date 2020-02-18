package com.tahakhairy.notesapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tahakhairy.notesapp.database.Note

class NoteAdapter(private var notes: List<Note>?) :
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_note, parent, false)
        return NoteViewHolder(view)
    }

    override fun getItemCount(): Int {
        return notes?.size ?: 0
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = notes?.get(position)
        holder.noteTitle.text = currentNote?.title
        holder.noteDate.text = currentNote?.date
    }

    internal fun setNotes(notes: List<Note>?) {
        this.notes = notes
        notifyDataSetChanged()
    }

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val noteTitle: TextView = itemView.findViewById(R.id.note_item_title)
        val noteDate: TextView = itemView.findViewById(R.id.note_item_date)
    }
}