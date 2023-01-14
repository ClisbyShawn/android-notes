package com.clisby.shawn.note.presentation.composables.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.clisby.shawn.note.presentation.model.NoteUi

@Composable
fun NoteItem(noteUi: NoteUi) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp)
    ) {
        NoteHeaderSubText(title = noteUi.title, subText = noteUi.content)
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