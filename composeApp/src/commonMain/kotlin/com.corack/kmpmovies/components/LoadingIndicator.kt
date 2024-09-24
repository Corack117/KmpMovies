package com.corack.kmpmovies.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun LoadingIndicator(
    enabled: Boolean = false,
    modifier: Modifier = Modifier
) {
    if (enabled) {
        Box(modifier = modifier
            .fillMaxSize(),
            contentAlignment = Alignment.Center
        )  {
            CircularProgressIndicator()
        }

    }
}
