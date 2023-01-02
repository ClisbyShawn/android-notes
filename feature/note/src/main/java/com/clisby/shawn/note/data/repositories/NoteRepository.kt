package com.clisby.shawn.note.data.repositories

import com.clisby.shawn.common.hilt.module.IoDispatcher
import com.clisby.shawn.note.data.local.model.NoteEntity
import com.clisby.shawn.note.data.local.source.NoteLocalSource
import com.clisby.shawn.note.domain.model.Note
import com.clisby.shawn.note.domain.repo.NoteRepo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NoteRepository @Inject constructor(
    private val noteLocalSource: NoteLocalSource,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : NoteRepo {

    override fun getAllNotes(): Flow<List<Note>> {
        return noteLocalSource
            .getAllNotes()
            .map { notes ->
                notes.map { noteEntity ->
                    noteEntity.toNote()
                }
            }.flowOn(dispatcher)
    }

    override suspend fun getNoteById(id: Int): Note = withContext(dispatcher) {
        noteLocalSource.getNoteById(id = id).toNote()
    }

    override suspend fun saveNote(note: Note) = withContext(dispatcher) {
        noteLocalSource.saveNote(NoteEntity.fromNote(note))
    }

    override suspend fun deleteNote(note: Note) = withContext(dispatcher) {
        noteLocalSource.deleteNote(NoteEntity.fromNote(note))
    }
}