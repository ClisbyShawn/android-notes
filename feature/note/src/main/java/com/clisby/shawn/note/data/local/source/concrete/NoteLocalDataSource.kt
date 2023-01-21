package com.clisby.shawn.note.data.local.source.concrete

import com.clisby.shawn.note.data.local.model.NoteEntity
import com.clisby.shawn.note.data.local.room.dao.NoteEntityDao
import com.clisby.shawn.note.data.local.source.NoteLocalSource
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class NoteLocalDataSource @Inject constructor(
    private val noteDao: NoteEntityDao
) : NoteLocalSource {

    override fun getAllNotes(): Flow<List<NoteEntity>> {
        return noteDao.getAllNotes()
    }

    override suspend fun getNoteById(id: Int): NoteEntity {
        return noteDao.getNoteEntityById(id = id)
    }

    override suspend fun saveNote(note: NoteEntity) {
        noteDao.insertNoteEntity(noteEntity = note)
    }

    override suspend fun deleteNote(note: NoteEntity) {
        noteDao.deleteNoteEntity(noteEntity = note)
    }
}
