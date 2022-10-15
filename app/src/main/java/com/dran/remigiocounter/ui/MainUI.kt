package com.dran.remigiocounter.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dran.remigiocounter.CardModelView
import com.dran.remigiocounter.ui.theme.RemigioCounterTheme

@Composable
fun MainUI() {
    RemigioCounterTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val tasksViewModel: CardModelView = viewModel()
            CardList(
                list = tasksViewModel.taskList,
                onCheckedTask = tasksViewModel::onCheckedChange,
                onCloseTask = tasksViewModel::removeTask
            )
        }
    }
}