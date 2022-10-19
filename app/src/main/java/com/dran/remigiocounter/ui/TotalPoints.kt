package com.dran.remigiocounter.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dran.remigiocounter.R
import com.dran.remigiocounter.ui.theme.RemigioCounterTheme

@Composable
fun TotalPoints(
    points: Int,
    modifier: Modifier = Modifier
) {
    Row(horizontalArrangement = Arrangement.Center, modifier = modifier.fillMaxWidth()) {
        Text(text = "${stringResource(id = R.string.total_points)}: $points", modifier.padding(10.dp))
    }
}

@Preview
@Composable
private fun TotalCountPreview() {
    RemigioCounterTheme {
        TotalPoints(points = 34)
    }
}