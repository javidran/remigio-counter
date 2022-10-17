package com.dran.remigiocounter.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dran.remigiocounter.ui.theme.RemigioCounterTheme
import com.dran.remigiocounter.viewmodels.CardModelView

@Composable
fun MainUI() {
    RemigioCounterTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val cardViewModel: CardModelView = viewModel()
            CardCounterList(
                list = cardViewModel.cardList,
                onCountDecrement = cardViewModel::onCountDecrement,
                onCountIncrement = cardViewModel::onCountIncrement
            )
        }
    }
}