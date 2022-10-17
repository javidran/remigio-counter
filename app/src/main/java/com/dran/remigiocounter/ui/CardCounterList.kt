package com.dran.remigiocounter.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dran.remigiocounter.datasource.Card
import com.dran.remigiocounter.ui.theme.RemigioCounterTheme

@Composable
fun CardCounterList(
    list: List<Card>,
    onCountDecrement: (Card) -> Unit,
    onCountIncrement: (Card) -> Unit,
) {
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(items = list, key = { card -> card.number }) { item ->
            CardCounter(
                cardNumber = item.number,
                cardCount = item.count,
                onCountDecrement = { onCountDecrement(item) },
                onCountIncrement = { onCountIncrement(item) },
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}

@Preview
@Composable
private fun CardListPreview() {
    val cardList = List(12) { i -> Card(i + 1) }

    RemigioCounterTheme() {
        CardCounterList(cardList, {}, {})
    }
}