package com.clisby.shawn.note.presentation.composables.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.clisby.shawn.note.presentation.composables.components.NoteError
import com.clisby.shawn.note.presentation.composables.components.NoteLoading
import com.clisby.shawn.note.presentation.composables.components.note.NoteDetail
import com.clisby.shawn.note.presentation.model.NoteUi
import com.clisby.shawn.note.presentation.model.NoteUiDetailState
import com.clisby.shawn.note.presentation.model.NoteUiDetailState.Error
import com.clisby.shawn.note.presentation.model.NoteUiDetailState.Existing
import com.clisby.shawn.note.presentation.model.NoteUiDetailState.Loading
import com.clisby.shawn.note.presentation.model.NoteUiDetailState.NewNote
import com.clisby.shawn.note.presentation.viewModel.NoteDetailViewModel

@Composable
fun NoteScreen(
    noteDetailViewModel: NoteDetailViewModel = hiltViewModel(),
    onNoteSaved: () -> Unit
) {
    val detailState: NoteUiDetailState by noteDetailViewModel.noteState.collectAsState()

    when (val state = detailState) {
        Loading -> NoteLoading()
        NewNote -> NoteDetail(
            onNoteSaved = { title, content ->
                noteDetailViewModel.saveNote(
                    noteUi = NoteUi(
                        title = title,
                        content = content
                    )
                )
                onNoteSaved()
            }
        )

        is Existing -> NoteDetail(
                noteUi = state.noteUi,
                onNoteSaved = { title, content ->
                    noteDetailViewModel.saveNote(
                        noteUi = NoteUi(
                            id = state.noteUi.id,
                            title = title,
                            content = content
                        )
                    )
                    onNoteSaved()
                })

        is Error -> NoteError(state.errorMessage)
    }
}
