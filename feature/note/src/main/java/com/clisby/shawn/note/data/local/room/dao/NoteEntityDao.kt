package com.clisby.shawn.note.data.local.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.clisby.shawn.note.data.local.model.NoteEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface NoteEntityDao {

    @Query("SELECT * FROM note_table")
    fun getAllNotes(): Flow<List<NoteEntity>>


    @Query("SELECT * FROM note_table WHERE id = :id")
    suspend fun getNoteEntityById(id: Int): NoteEntity


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNoteEntity(noteEntity: NoteEntity)

    @Delete
    suspend fun deleteNoteEntity(noteEntity: NoteEntity)

}