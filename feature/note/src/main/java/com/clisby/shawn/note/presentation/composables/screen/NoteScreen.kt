package com.clisby.shawn.note.presentation.composables.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.clisby.shawn.note.presentation.composables.components.NoteError
import com.clisby.shawn.note.presentation.composables.components.NoteLoading
import com.clisby.shawn.note.presentation.composables.components.note.NoteDetail
import com.clisby.shawn.note.presentation.model.NoteUi
import com.clisby.shawn.note.presentation.model.NoteUiDetailState

@Composable
fun NoteScreen(
    state: NoteUiDetailState
) {
    when (state) {
        NoteUiDetailState.Loading -> NoteLoading()
        NoteUiDetailState.NewNote -> NoteDetail(
            onNoteSaved = {},
            onTitleChanged = {},
            onContentChanged = {}
        )
        is NoteUiDetailState.Existing -> NoteDetail(
            onNoteSaved = {},
            onTitleChanged = {},
            onContentChanged = {})
        is NoteUiDetailState.Error -> NoteError(state.errorMessage)
    }
}

@Preview
@Composable
fun PreviewLoadingNoteScreen() {
    NoteScreen(NoteUiDetailState.Loading)
}

@Preview
@Composable
fun PreviewErrorNoteScreen() {
    NoteScreen(NoteUiDetailState.Error(errorMessage = "Uh-Oh!"))
}

@Preview
@Composable
fun PreviewNewNoteScreen() {
    NoteScreen(NoteUiDetailState.NewNote)
}

@Preview
@Composable
fun PreviewExistingNoteScreen() {
    NoteScreen(
        NoteUiDetailState.Existing(
            noteUi = NoteUi(
                id = 1,
                title = "Title #1",
                content = "Content"
            )
        )
    )
}
