package com.clisby.shawn.note.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.clisby.shawn.note.data.local.model.NoteEntity
import com.clisby.shawn.note.data.local.room.dao.NoteEntityDao

@Database(
    entities = [NoteEntity::class],
    version = 1
)
abstract class NoteRoomDatabase : RoomDatabase() {

    abstract fun noteEntityDao(): NoteEntityDao
}