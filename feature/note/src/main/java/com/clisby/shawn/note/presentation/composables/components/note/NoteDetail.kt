package com.clisby.shawn.note.presentation.composables.components.note

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteDetail(
    title: String? = null,
    content: String? = null,
    onTitleChanged: (String) -> Unit,
    onContentChanged: (String) -> Unit,
    onNoteSaved: () -> Unit
) {
    Scaffold(
        content = {
            DetailInput(
                title,
                content,
                onTitleChanged = onTitleChanged,
                onContentChanged = onContentChanged
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onNoteSaved) {
                Icon(Icons.Filled.Done, "Save Note")
            }
        }
    )
}

@Preview
@Composable
fun PreviewNoteDetailNew() {
    NoteDetail(
        onNoteSaved = {},
        onTitleChanged = {},
        onContentChanged = {}
    )
}

@Preview
@Composable
fun PreviewNoteDetailExisting() {
    NoteDetail(
        title = "Note Detail Title",
        content = "Note Detail Content",
        onNoteSaved = {},
        onTitleChanged = {},
        onContentChanged = {}
    )
}
