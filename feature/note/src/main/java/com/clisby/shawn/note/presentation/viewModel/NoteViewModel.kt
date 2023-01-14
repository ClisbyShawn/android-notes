package com.clisby.shawn.note.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clisby.shawn.note.domain.repo.NoteRepo
import com.clisby.shawn.note.presentation.model.NoteUi
import com.clisby.shawn.note.presentation.model.NoteUiListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val noteRepo: NoteRepo
) : ViewModel() {

    val notesState: StateFlow<NoteUiListState> =
        noteRepo
            .getAllNotes()
            .map { notes ->
                NoteUiListState.Success(
                    notes = notes.map { note -> NoteUi.fromNoteDomain(note) }
                )
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5000),
                initialValue = NoteUiListState.Loading
            )

    fun onSaveNewNote(noteUi: NoteUi) {
        viewModelScope.launch {
            noteRepo.saveNote(
                note = noteUi.toNoteDomain()
            )
        }
    }

    fun onDeleteNote(noteUi: NoteUi) {
        viewModelScope.launch {
            noteRepo.deleteNote(
                note = noteUi.toNoteDomain()
            )
        }
    }
}