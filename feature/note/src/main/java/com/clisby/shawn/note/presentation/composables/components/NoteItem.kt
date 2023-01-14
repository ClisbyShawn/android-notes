package com.clisby.shawn.note.presentation.composables.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.clisby.shawn.note.presentation.model.NoteUi

@Composable
fun NoteItem(noteUi: NoteUi) {
    Row {
        Column {
            Text(text = noteUi.title)
            Text(text = noteUi.content)
        }
    }
}


@Preview
@Composable
fun PreviewNoteItem() {
    NoteItem(
        NoteUi(
            id = 0,
            title = "This is Note Title",
            content = "This is Note Content"
        )
    )
}