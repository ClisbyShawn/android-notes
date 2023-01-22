package com.clisby.shawn.note.data.local.module

import android.content.Context
import androidx.room.Room
import com.clisby.shawn.note.data.local.room.NoteRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun providesNoteRoomDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        NoteRoomDatabase::class.java,
        "note_room_database"
    ).build()

    @Singleton
    @Provides
    fun providesNoteEntityDao(
        db: NoteRoomDatabase
    ) = db.noteEntityDao()
}
