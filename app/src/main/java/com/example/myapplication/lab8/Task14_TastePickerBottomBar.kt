package com.example.myapplication.lab8

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Task14_TastePickerBottomBar(
    likedCount: Int,
    required: Int,
    canContinue: Boolean,
    onContinueClick: () -> Unit,
    onSkipClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val progress = (likedCount.toFloat() / required.toFloat()).coerceAtMost(1f)

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp),
        shape = RoundedCornerShape(16.dp),
        shadowElevation = 8.dp,
        tonalElevation = 2.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.size(40.dp)
            ) {
                CircularProgressIndicator(
                    progress = { progress },
                    modifier = Modifier.size(40.dp)
                )
                Text(
                    text = "$likedCount",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = "Pick $required artists you like",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.weight(1f)
            )
            TextButton(onClick = onSkipClick) {
                Text("Later")
            }
            Spacer(modifier = Modifier.width(4.dp))
            Button(
                onClick = onContinueClick,
                enabled = canContinue
            ) {
                Text("Continue")
            }
        }
    }
}

@Composable
fun Task14_FullTastePickerScreen(
    state: TastePickerState,
    onGenreClick: (String) -> Unit,
    onLikeClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
    onContinueClick: () -> Unit = { Log.d("TastePicker", "Continue") },
    onSkipClick: () -> Unit = { Log.d("TastePicker", "Skip") }
) {
    Scaffold(
        modifier = modifier,
        bottomBar = {
            Task14_TastePickerBottomBar(
                likedCount = state.likedCount,
                required = REQUIRED_LIKES,
                canContinue = state.canContinue,
                onContinueClick = onContinueClick,
                onSkipClick = onSkipClick
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Task13_GenreChips(
                genres = state.genres,
                selectedGenre = state.selectedGenre,
                onGenreClick = onGenreClick
            )
            Task12_ArtistGrid(
                artists = state.visibleArtists,
                likedIds = state.likedIds,
                onLikeClick = onLikeClick
            )
        }
    }
}

@Preview(showBackground = true, name = "0 Liked")
@Composable
fun Task14_Preview0() {
    Task14_TastePickerBottomBar(likedCount = 0, required = 3, canContinue = false, onContinueClick = {}, onSkipClick = {})
}

@Preview(showBackground = true, name = "2 Liked")
@Composable
fun Task14_Preview2() {
    Task14_TastePickerBottomBar(likedCount = 2, required = 3, canContinue = false, onContinueClick = {}, onSkipClick = {})
}

@Preview(showBackground = true, name = "3 Liked")
@Composable
fun Task14_Preview3() {
    Task14_TastePickerBottomBar(likedCount = 3, required = 3, canContinue = true, onContinueClick = {}, onSkipClick = {})
}
