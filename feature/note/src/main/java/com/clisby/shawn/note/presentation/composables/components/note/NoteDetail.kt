package com.clisby.shawn.note.presentation.composables.components.note

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.clisby.shawn.note.presentation.model.NoteUi

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteDetail(
    noteUi: NoteUi? = null,
    onNoteSaved: (String, String) -> Unit
) {
    var title by remember {
        mutableStateOf(noteUi?.title ?: "")
    }

    var content by remember {
        mutableStateOf(noteUi?.content ?: "")
    }

    Scaffold(
        content = {
            DetailInput(
                title,
                content,
                onTitleChanged = { newTitle ->
                    title = newTitle
                },
                onContentChanged = { newContent ->
                    content = newContent
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    onNoteSaved(title, content)
                }) {
                Icon(Icons.Filled.Done, "Save Note")
            }
        }
    )
}

@Preview
@Composable
fun PreviewNoteDetailNew() {
    NoteDetail(onNoteSaved = {_,_->})
}

@Preview
@Composable
fun PreviewNoteDetailExisting() {
    NoteDetail(
        noteUi = NoteUi(
            id = 0,
            title = "Note Detail Title",
            content = "Note Detail Content"
        ),
        onNoteSaved = {_,_->}
    )
}
