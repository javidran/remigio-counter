package com.dran.remigiocounter.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dran.remigiocounter.datasource.Card
import com.dran.remigiocounter.ui.theme.RemigioCounterTheme

@Composable
fun CardCounterList(
    list: List<Card>,
    onCountDecrement: (Int) -> Unit,
    onCountIncrement: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(numberOfCells(LocalConfiguration.current.orientation)),
        userScrollEnabled = true,
        modifier = modifier
    ) {
        itemsIndexed(items = list, key = { _, card -> card.number}) { index, item ->
            CardCounter(
                cardNumber = item.number,
                cardCount = item.count,
                points = item.points,
                onCountDecrement = { onCountDecrement(index) },
                onCountIncrement = { onCountIncrement(index) },
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}

private fun numberOfCells(orientation: Int): Int {
    return when(orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> 4
        else -> 2
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