package com.clisby.shawn.note.presentation.model

sealed interface NoteUiListState {
    object Loading : NoteUiListState
    data class Success(val notes: List<NoteUi>) : NoteUiListState
    data class Error(val errorMessage: String) : NoteUiListState
}