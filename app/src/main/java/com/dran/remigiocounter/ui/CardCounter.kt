package com.dran.remigiocounter.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
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
    cardNumber: Int,
    cardCount: Int,
    onCountDecrement: () -> Unit,
    onCountIncrement: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.large,
        tonalElevation = 10.dp,
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.width(IntrinsicSize.Min)
        ) {
            Counter(cardCount)
            Divider()
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.height(IntrinsicSize.Min)
            ) {
                CountButton(
                    onClick = onCountDecrement,
                    id = R.drawable.substract_icon
                )
                VerticalDivider()
                CardToCount(
                    cardNumber = cardNumber,
                    modifier = Modifier
                        .weight(1f)
                        .padding(10.dp)
                )
                VerticalDivider()
                CountButton(
                    onClick = onCountIncrement,
                    id = R.drawable.add_icon
                )
            }
        }
    }
}

@Composable
private fun Counter(count: Int, modifier: Modifier = Modifier) {
    Text(text = "$count", modifier = modifier.padding(10.dp))
}

@Composable
private fun CardToCount(cardNumber: Int, modifier: Modifier = Modifier) {
    Text(text = "Card $cardNumber", modifier = modifier)
}

@Composable
private fun CountButton(
    modifier: Modifier = Modifier,
    @DrawableRes id: Int,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .clickable(onClick = onClick)
    ) {
        Icon(
            painterResource(id = id),
            contentDescription = null,
            modifier = Modifier.padding(10.dp)
        )
    }
}

@Composable
private fun VerticalDivider() {
    Divider(
        modifier = Modifier
            .fillMaxHeight()
            .width(1.dp)
    )
}

@Preview
@Preview(showBackground = true)
@Composable
fun CardCounterPreview() {
    val sampleCard = Card(1)

    RemigioCounterTheme {
        CardCounter(sampleCard.number, sampleCard.count, {}, {})
    }
}