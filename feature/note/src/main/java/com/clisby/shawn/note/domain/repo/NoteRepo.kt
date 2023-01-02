package com.clisby.shawn.note.domain.repo

import com.clisby.shawn.note.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepo {
    fun getAllNotes(): Flow<List<Note>>
    suspend fun getNoteById(id: Int): Note
    suspend fun saveNote(note: Note)
    suspend fun deleteNote(note: Note)
}