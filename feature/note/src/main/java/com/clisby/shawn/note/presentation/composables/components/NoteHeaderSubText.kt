package com.clisby.shawn.note.presentation.composables.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun NoteHeaderSubText(
    title: String,
    subText: String
) {
    Column {
        Text(text = title)
        Text(text = subText)
    }
}


@Preview
@Composable
fun PreviewNoteHeaderSubText() {
    NoteHeaderSubText(title = "Header", subText = "SubText")
}