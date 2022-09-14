package com.dran.remigiocounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dran.remigiocounter.enums.Card
import com.dran.remigiocounter.ui.theme.RemigioCounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RemigioCounterTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun Button(cardNumber: Card) {
    val imageDrawable: Int = when(cardNumber) {
        Card.ONE -> R.drawable.oro_1
        Card.TWO -> R.drawable.oro_2
        else -> 0 //Never occurs. TODO: Delete when all cases are covered
    }

    val image: Painter = painterResource(id = imageDrawable)
    Image(painter = image, contentDescription = "", modifier = Modifier.fillMaxWidth(0.25f))
}

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    RemigioCounterTheme {
        Button(cardNumber = Card.ONE)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RemigioCounterTheme {
        Greeting("Android")
    }
}