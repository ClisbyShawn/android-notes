package com.clisby.shawn.note.presentation.composables.components.note

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailInput(
    title: String? = null,
    content: String? = null,
    onTitleChanged: (String) -> Unit,
    onContentChanged: (String) -> Unit,
) {

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (titleInput, contentInput) = createRefs()
        val middleGuideline = createGuidelineFromTop(.5f)

        OutlinedTextField(
            value = title ?: "",
            onValueChange = onTitleChanged,
            singleLine = true,
            label = { Text(text = "Title") },
            trailingIcon = {
                Icon(Icons.Filled.Clear, "Clear icon", modifier = Modifier.clickable { })
            },
            modifier = Modifier.constrainAs(titleInput) {
                top.linkTo(parent.top, margin = 16.dp)
                start.linkTo(parent.start, margin = 16.dp)
                end.linkTo(parent.end, margin = 16.dp)
            }
        )

        OutlinedTextField(
            value = content ?: "",
            onValueChange = onContentChanged,
            singleLine = false,
            label = { Text(text = "Content") },
            modifier = Modifier.constrainAs(contentInput) {
                top.linkTo(titleInput.bottom, margin = 16.dp)
                start.linkTo(titleInput.start)
                end.linkTo(titleInput.end)
                bottom.linkTo(middleGuideline)
                height = Dimension.fillToConstraints
            }
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewDetailInput() {
    DetailInput(onTitleChanged = {}, onContentChanged = {})
}
