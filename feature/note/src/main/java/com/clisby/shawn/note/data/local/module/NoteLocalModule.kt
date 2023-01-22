package com.clisby.shawn.note.data.local.module

import com.clisby.shawn.note.data.local.source.NoteLocalSource
import com.clisby.shawn.note.data.local.source.concrete.NoteLocalDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class NoteLocalModule {

    @Binds
    abstract fun bindsNoteLocalSource(
        source: NoteLocalDataSource
    ): NoteLocalSource
}