package com.clisby.shawn.note.presentation.composables.components


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.clisby.shawn.note.presentation.model.NoteUi

@Composable
fun NoteList(notes: List<NoteUi>) {

    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        contentPadding = PaddingValues(start = 8.dp, end = 8.dp)
    ) {
        items(
            items = notes,
            key = { noteUi ->
                noteUi.id
            }
        ) { note ->
            NoteItem(noteUi = note)
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewNoteList() {
    NoteList(
        notes =
        listOf(
            NoteUi(id = 0, title = "Title", content = "Content"),
            NoteUi(id = 1, title = "Title #1", content = "Content"),
            NoteUi(id = 2, title = "Title #2", content = "Content"),
            NoteUi(id = 3, title = "Title #3", content = "Content"),
            NoteUi(id = 4, title = "Title #4", content = "Content"),
            NoteUi(id = 5, title = "Title #5", content = "Content")
        )
    )
}