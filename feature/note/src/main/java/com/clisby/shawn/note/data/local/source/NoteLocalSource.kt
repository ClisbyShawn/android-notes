package com.clisby.shawn.note.data.local.source

import com.clisby.shawn.note.data.local.model.NoteEntity
import kotlinx.coroutines.flow.Flow

interface NoteLocalSource {

    fun getAllNotes(): Flow<List<NoteEntity>>
    suspend fun getNoteById(id: Int): NoteEntity
    suspend fun saveNote(note: NoteEntity)
    suspend fun deleteNote(note: NoteEntity)
}
