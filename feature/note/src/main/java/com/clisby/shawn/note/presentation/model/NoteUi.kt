package com.clisby.shawn.note.presentation.model

import com.clisby.shawn.note.domain.model.Note

data class NoteUi(
    val id: Int = 0,
    val title: String,
    val content: String
) {
    fun toNoteDomain(): Note {
        return Note(
            id = id,
            title = title,
            content = content
        )
    }

    companion object {
        fun fromNoteDomain(note: Note): NoteUi {
            return NoteUi(
                id = note.id,
                title = note.title,
                content = note.content
            )
        }
    }
}
