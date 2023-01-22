package com.clisby.shawn.note.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.clisby.shawn.note.presentation.composables.screen.NoteListScreen
import com.clisby.shawn.note.presentation.composables.screen.NoteScreen
import com.clisby.shawn.note.presentation.navigation.model.Screens.NoteDetailScreen
import com.clisby.shawn.note.presentation.navigation.model.Screens.NoteListScreen
import com.clisby.shawn.note.presentation.viewModel.NoteListViewModel

@Composable
fun NoteNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String = NoteListScreen.route,
    noteListViewModel: NoteListViewModel = hiltViewModel(),
) {
    val noteListState by noteListViewModel.notesState.collectAsState()

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {

        composable(route = NoteListScreen.route) {
            NoteListScreen(
                state = noteListState,
                onAddNote = { navController.navigate(route = NoteDetailScreen.route) },
                onNoteSelected = { noteId -> navController.navigate(route = NoteDetailScreen.route + "?noteId=$noteId") }
            )
        }

        composable(
            route = NoteDetailScreen.route + "?noteId={noteId}",
            arguments = listOf(
                navArgument("noteId") {
                    nullable = true
                    defaultValue = null
                    type = NavType.StringType
                }
            )
        ) {
            NoteScreen(
                onNoteSaved = { navController.navigate(route = NoteListScreen.route) }
            )
        }
    }
}