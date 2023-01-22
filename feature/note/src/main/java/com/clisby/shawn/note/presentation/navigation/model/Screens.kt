package com.clisby.shawn.note.presentation.navigation.model

sealed class Screens(val route: String) {

    object NoteListScreen : Screens("note_list")
    object NoteDetailScreen : Screens("note_detail")
}