package com.clisby.shawn.note.di

import com.clisby.shawn.note.data.repositories.NoteRepository
import com.clisby.shawn.note.domain.repo.NoteRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class NotePresentationModule {

    @Binds
    abstract fun providesNoteRepo(
        noteRepository: NoteRepository
    ): NoteRepo
}
