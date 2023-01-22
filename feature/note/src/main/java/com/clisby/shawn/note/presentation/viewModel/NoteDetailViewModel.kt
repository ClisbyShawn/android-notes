package com.clisby.shawn.note.presentation.viewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clisby.shawn.note.domain.repo.NoteRepo
import com.clisby.shawn.note.presentation.model.NoteUi
import com.clisby.shawn.note.presentation.model.NoteUiDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

@HiltViewModel
class NoteDetailViewModel @Inject constructor(
    private val repo: NoteRepo,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val noteState: StateFlow<NoteUiDetailState> = flow {
        savedStateHandle.get<String>("noteId")?.let {
            emit(
                NoteUiDetailState.Existing(
                    noteUi = NoteUi.fromNoteDomain(note = repo.getNoteById(id = it.toInt()))
                )
            )
        } ?: run {
            emit(
                NoteUiDetailState.NewNote
            )
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = NoteUiDetailState.Loading
    )

    fun saveNote(noteUi: NoteUi) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.saveNote(note = noteUi.toNoteDomain())
        }
    }
}