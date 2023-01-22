package com.clisby.shawn.note.presentation.composables.screen

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.clisby.shawn.note.presentation.composables.components.NoteError
import com.clisby.shawn.note.presentation.composables.components.NoteLoading
import com.clisby.shawn.note.presentation.composables.components.notes.NoteList
import com.clisby.shawn.note.presentation.model.NoteUi
import com.clisby.shawn.note.presentation.model.NoteUiListState

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NoteListScreen(
    state: NoteUiListState,
    onAddNote: () -> Unit,
    onNoteSelected: (Int) -> Unit
) {
    Scaffold(
        content = {
            when (state) {
                is NoteUiListState.Success -> {
                    NoteList(notes = state.notes, onNoteSelected)
                }

                NoteUiListState.Loading -> {
                    NoteLoading()
                }

                is NoteUiListState.Error -> {
                    NoteError(state.errorMessage)
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onAddNote) {
                Icon(Icons.Filled.Add, "Add Note")
            }
        }
    )
}

@Preview(showSystemUi = true)
@Composable
fun PreviewSuccessNotes() {
    NoteListScreen(
        state = NoteUiListState.Success(
            notes = listOf(
                NoteUi(id = 0, title = "Title", content = "Content"),
                NoteUi(id = 1, title = "Title #1", content = "Content"),
                NoteUi(id = 2, title = "Title #2", content = "Content"),
                NoteUi(id = 3, title = "Title #3", content = "Content"),
            )
        ),
        onAddNote = {},
        onNoteSelected = {}
    )
}

@Preview(showSystemUi = true)
@Composable
fun PreviewSuccessNotesEmpty() {
    NoteListScreen(
        state = NoteUiListState.Success(
            notes = emptyList()
        ),
        onAddNote = {},
        onNoteSelected = {}
    )
}

@Preview(showSystemUi = true)
@Composable
fun PreviewLoadingNotes() {
    NoteListScreen(
        state = NoteUiListState.Loading,
        onAddNote = {},
        onNoteSelected = {}
    )
}

@Preview(showSystemUi = true)
@Composable
fun PreviewErrorNotes() {
    NoteListScreen(
        state = NoteUiListState.Error(
            errorMessage = "Uh-Oh! Error..."
        ),
        onAddNote = {},
        onNoteSelected = {}
    )
}
