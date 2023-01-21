package com.clisby.shawn.note.presentation.composables.components.notes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.clisby.shawn.note.R

@Composable
fun NoteListEmpty() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.empty_list_state),
            contentDescription = "Image show empty notes",
            modifier = Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.padding(top = 16.dp))
        Text(text = "No Notes")
        Text(text = "To Add a new Note press +")
    }
}

@Preview
@Composable
fun PreviewEmptyNoteList() {
    NoteListEmpty()
}
