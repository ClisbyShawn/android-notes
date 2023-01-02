package com.clisby.shawn.note.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.clisby.shawn.note.domain.model.Note

@Entity(tableName = "note_table")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val content: String
) {

    fun toNote() = Note(
        id = id,
        title = title,
        content = content
    )

    companion object {
        fun fromNote(note: Note) = NoteEntity(
            id = note.id,
            title = note.title,
            content = note.content
        )
    }
}
