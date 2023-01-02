package com.clisby.shawn.note

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.clisby.shawn.note.data.local.model.NoteEntity
import com.clisby.shawn.note.data.local.room.NoteRoomDatabase
import com.clisby.shawn.note.data.local.room.dao.NoteEntityDao
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class NoteRoomUnitTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var noteEntityDao: NoteEntityDao
    private lateinit var noteRoomDatabase: NoteRoomDatabase

    @Before
    fun setup() {
        noteRoomDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            NoteRoomDatabase::class.java
        ).build()

        noteEntityDao = noteRoomDatabase.noteEntityDao()
    }

    @After
    @Throws(IOException::class)
    fun cleanUp() {
        noteRoomDatabase.close()
    }


    @Test
    @Throws(Exception::class)
    fun writeAndReadNoteDatabase() = runBlocking {
        val noteEntity = NoteEntity(id = 1, title = "This title", content = "This content")
        noteEntityDao.insertNoteEntity(noteEntity = noteEntity)

        val testedNote = noteEntityDao.getAllNotes().first().first()
        assertEquals(noteEntity, testedNote)
    }

    @Test
    @Throws(Exception::class)
    fun writeAndOverwriteEntityInNoteDatabase() = runBlocking {
        val noteEntity = NoteEntity(id = 1, title = "This title", content = "This content")
        val newNoteEntity = NoteEntity(id = 1, title = "New Title", content = "New Content")
        noteEntityDao.insertNoteEntity(noteEntity = noteEntity)
        noteEntityDao.insertNoteEntity(noteEntity = newNoteEntity)


        val testedNote = noteEntityDao.getAllNotes().first().first()
        assertEquals(newNoteEntity, testedNote)
    }

    @Test
    @Throws(Exception::class)
    fun writeAndDeleteNoteDatabase() = runBlocking {
        val noteEntity = NoteEntity(id = 1, title = "This title", content = "This content")
        noteEntityDao.insertNoteEntity(noteEntity = noteEntity)
        noteEntityDao.deleteNoteEntity(noteEntity = noteEntity)

        val testedNote = noteEntityDao.getAllNotes().firstOrNull()?.firstOrNull()
        assertEquals(null, testedNote)
    }
}