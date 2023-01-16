package com.clisby.shawn.note.presentation.model

sealed interface NoteUiDetailState {
    object Loading : NoteUiDetailState
    data class Error(val errorMessage: String) : NoteUiDetailState
    object NewNote : NoteUiDetailState
    data class Existing(val noteUi: NoteUi) : NoteUiDetailState
}
