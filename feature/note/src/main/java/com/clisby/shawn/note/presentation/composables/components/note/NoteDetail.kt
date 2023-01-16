package com.clisby.shawn.note.presentation.composables.components.note

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = title ?: "",
                    onValueChange = onTitleChanged,
                    singleLine = true,
                    label = { Text(text = "Title") },
                    trailingIcon = {
                        Icon(
                            Icons.Filled.Clear,
                            "Clear icon",
                            modifier = Modifier.clickable { })
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp)
                )
                OutlinedTextField(
                    value = content ?: "",
                    onValueChange = onContentChanged,
                    singleLine = false,
                    label = { Text(text = "Content") },
                    trailingIcon = {
                        Icon(
                            Icons.Filled.Clear,
                            "Clear icon",
                            modifier = Modifier.clickable { })
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp)
                )
            }
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