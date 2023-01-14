package com.clisby.shawn.note.presentation.composables.components


import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.clisby.shawn.note.presentation.model.NoteUi

@Composable
fun NoteList(notes: List<NoteUi>) {

    LazyColumn {
        items(items = notes) { note ->
            NoteItem(noteUi = note)
        }
    }

}


@Preview
@Composable
fun PreviewNoteList() {
    NoteList(
        listOf(
            NoteUi(id = 0, title = "Title", content = "Content"),
            NoteUi(id = 1, title = "Title #1", content = "Content"),
            NoteUi(id = 2, title = "Title #2", content = "Content"),
            NoteUi(id = 3, title = "Title #3", content = "Content")
        )
    )
}