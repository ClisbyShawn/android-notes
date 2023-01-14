package com.clisby.shawn.note.presentation.composables.screen

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.clisby.shawn.note.presentation.composables.components.NoteList
import com.clisby.shawn.note.presentation.composables.components.NoteListLoading
import com.clisby.shawn.note.presentation.composables.components.NoteListScreenError
import com.clisby.shawn.note.presentation.model.NoteUi
import com.clisby.shawn.note.presentation.model.NoteUiListState


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NoteScreen(
    state: NoteUiListState,
    onAddNote: () -> Unit
) {
    Scaffold(
        content = {
            when (state) {
                is NoteUiListState.Success -> {
                    NoteList(notes = state.notes)
                }

                NoteUiListState.Loading -> {
                    NoteListLoading()
                }

                is NoteUiListState.Error -> {
                    NoteListScreenError(state.errorMessage)
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onAddNote) {}
        })
}


@Preview(showSystemUi = true)
@Composable
fun PreviewSuccessNotes() {
    NoteScreen(
        state = NoteUiListState.Success(
            notes = listOf(
                NoteUi(id = 0, title = "Title", content = "Content"),
                NoteUi(id = 1, title = "Title #1", content = "Content"),
                NoteUi(id = 2, title = "Title #2", content = "Content"),
                NoteUi(id = 3, title = "Title #3", content = "Content"),
            )
        ),
        onAddNote = {}
    )
}

@Preview(showSystemUi = true)
@Composable
fun PreviewLoadingNotes() {
    NoteScreen(
        state = NoteUiListState.Loading,
        onAddNote = {}
    )
}

@Preview(showSystemUi = true)
@Composable
fun PreviewErrorNotes() {
    NoteScreen(
        state = NoteUiListState.Error(
            errorMessage = "Uh-Oh! Error..."
        ),
        onAddNote = {}
    )
}