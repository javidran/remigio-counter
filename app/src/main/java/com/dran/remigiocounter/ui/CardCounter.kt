package com.dran.remigiocounter.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dran.remigiocounter.R
import com.dran.remigiocounter.datasource.Card
import com.dran.remigiocounter.ui.theme.RemigioCounterTheme

@Composable
fun CardCounter(
    cardNumber: Int,
    cardCount: Int,
    points: Int,
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
            Counter(
                count = cardCount,
                points = points
            )
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
private fun Counter(count: Int, points: Int, modifier: Modifier = Modifier) {
    Text(text = "$count ($points ${stringResource(id = R.string.points)})", style = MaterialTheme.typography.bodySmall, modifier = modifier.padding(10.dp))
}

@Composable
private fun CardToCount(cardNumber: Int, modifier: Modifier = Modifier) {
//    Text(text = "Card $cardNumber", modifier = modifier)
    val id = when(cardNumber) {
        1 -> R.drawable.copas1
        2 -> R.drawable.copas2
        3 -> R.drawable.copas3
        4 -> R.drawable.copas4
        5 -> R.drawable.copas5
        6 -> R.drawable.copas6
        7 -> R.drawable.copas7
        8 -> R.drawable.copas8
        9 -> R.drawable.copas9
        10 -> R.drawable.copas10
        11 -> R.drawable.copas11
        12 -> R.drawable.copas12
        else -> R.drawable.copas1
    }

    Image(
        painter = painterResource(id = id),
        contentDescription = "${stringResource(id = R.string.card)} $cardNumber",
        modifier = modifier
    )
}

@Composable
private fun CountButton(
    modifier: Modifier = Modifier,
    @DrawableRes id: Int,
    onClick: () -> Unit,
) {
    Column (
        modifier = modifier
            .clickable(onClick = onClick)
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center
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
@Composable
fun CardCounterPreview() {
    var sampleCard by remember { mutableStateOf( Card(1) ) }

    RemigioCounterTheme {
        CardCounter(
            cardNumber = sampleCard.number,
            cardCount = sampleCard.count,
            points = sampleCard.points,
            onCountDecrement = { if(sampleCard.count > 0) sampleCard = sampleCard.copy(count = sampleCard.count - 1) },
            onCountIncrement = { sampleCard = sampleCard.copy(count = sampleCard.count + 1) }
        )
    }
}

@Preview
@Composable
fun CardCounter2Preview() {
    val sampleCard by remember { mutableStateOf( Card(1), neverEqualPolicy()) }

    RemigioCounterTheme {
        CardCounter(
            cardNumber = sampleCard.number,
            cardCount = sampleCard.count,
            points = sampleCard.points,
            onCountDecrement = { if(sampleCard.count > 0) sampleCard.count -= 1 },
            onCountIncrement = { sampleCard.count += 1 }
        )
    }
}