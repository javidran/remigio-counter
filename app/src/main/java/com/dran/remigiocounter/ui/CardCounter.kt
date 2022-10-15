package com.dran.remigiocounter.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dran.remigiocounter.R
import com.dran.remigiocounter.datasource.Card
import com.dran.remigiocounter.ui.theme.RemigioCounterTheme

@Composable
fun CardCounter(
    card: Card,
    onCountDecrement: (Card) -> Unit,
    onCountIncrement: (Card) -> Unit,
    onCountReset: (Card) -> Unit
) {
    Surface(shape = MaterialTheme.shapes.large, tonalElevation = 10.dp) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.width(IntrinsicSize.Min)) {
            Counter(card.count)
            Divider()
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CountButton(
                    onClick = { onCountDecrement(card) },
                    onLongClick = { onCountReset(card) },
                    id = R.drawable.substract_icon
                )
                CardToCount(card.number)
                CountButton(onClick = { onCountIncrement(card) }, id = R.drawable.add_icon)
            }
        }
    }
}

@Composable
private fun Counter(count: Int) {
    Text(text = "$count", modifier = Modifier.padding(10.dp))
}

@Composable
private fun CardToCount(cardNumber: Int) {
    Text(text = "Card $cardNumber")
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun CountButton(onClick: () -> Unit, onLongClick: () -> Unit = { }, @DrawableRes id: Int) {
    TextButton(
        onClick = onClick, modifier = Modifier.combinedClickable(
            onClick = onClick, // TODO: Revisar que no se clique dos veces
            onLongClick = onLongClick,
        )
    ) {
        Icon(painterResource(id = id), contentDescription = null)
    }
}

@Preview
@Preview(showBackground = true)
@Composable
fun CardCounterPreview() {
    val sampleCard = Card(1)

    RemigioCounterTheme {
        CardCounter(sampleCard, {}, {}, {})
    }
}