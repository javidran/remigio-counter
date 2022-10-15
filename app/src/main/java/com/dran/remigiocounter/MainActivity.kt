package com.dran.remigiocounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dran.remigiocounter.enums.CardNumber
import com.dran.remigiocounter.ui.MainUI
import com.dran.remigiocounter.ui.theme.NoRippleTheme
import com.dran.remigiocounter.ui.theme.RemigioCounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainUI()
        }
    }
}

@Composable
fun DeprecatedMainUI() {
    RemigioCounterTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                CardOption(cardNumber = CardNumber.ONE)
                CardOption(cardNumber = CardNumber.TWO)
            }
        }
    }
}

@Composable
fun CardOption(cardNumber: CardNumber) {
    Row {
        val count = remember { mutableStateOf(0) }
        CardOption(
            cardNumber = cardNumber,
            selectedCount = count.value,
            onCardClicked = {
                if (count.value == 4) count.value = 0
                else ++count.value
            },
            onCardLongClicked =  {
                count.value = 0
            }
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CardOption(cardNumber: CardNumber, selectedCount: Int, onCardClicked: () -> Unit, onCardLongClicked: () -> Unit) {
    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
        Image(
            painter = painterResource(id = obtainImageDrawable(cardNumber, selectedCount)),
            contentDescription = "",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(200.dp)
                .combinedClickable(onClick = onCardClicked, onLongClick = onCardLongClicked)
        )
    }
}

@DrawableRes
private fun obtainImageDrawable(cardNumber: CardNumber, selectedCount: Int): Int {
    return when (cardNumber) {
        CardNumber.ONE -> when (selectedCount) {
            0 -> R.drawable.uno_0
            1 -> R.drawable.uno_1
            2 -> R.drawable.uno_2
            3 -> R.drawable.uno_3
            4 -> R.drawable.uno_4
            else -> throw java.lang.IllegalStateException()
        }
        CardNumber.TWO -> when (selectedCount) {
            0 -> R.drawable.dos_0
            1 -> R.drawable.dos_1
            2 -> R.drawable.dos_2
            3 -> R.drawable.dos_3
            4 -> R.drawable.dos_4
            else -> throw java.lang.IllegalStateException()
        }
        else -> throw java.lang.IllegalStateException()
    }
}

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    RemigioCounterTheme {
        CardOption(cardNumber = CardNumber.ONE)
    }
}