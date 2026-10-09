package com.example.myapplication.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Q42: Hoisted Counter composables
@Composable
fun Counter(count: Int, onIncrement: () -> Unit) {
    Button(onClick = onIncrement) {
        Text("Clicked $count times")
    }
}

@Composable
fun CounterScreen() {
    var count by remember { mutableIntStateOf(0) }
    Counter(count = count, onIncrement = { count++ })
}

@Composable
fun Practice5PartCScreen(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp)
    ) {
        Text("Practice 5 (Q31-Q42) Material 3 & Responsive Demos", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        // Q36: Button Emphasis Levels
        Text("Q36: Button Emphasis (Primary, Tonal, Outlined)", fontWeight = FontWeight.Bold)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = {}) { Text("Save") } // Primary
            Spacer(modifier = Modifier.width(8.dp))
            FilledTonalButton(onClick = {}) { Text("Preview") } // Medium
            Spacer(modifier = Modifier.width(8.dp))
            OutlinedButton(onClick = {}) { Text("Cancel") } // Low
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Q37 & Q38: WindowSizeClass Adaptive Navigation description
        Text("Q37-38: WindowSizeClass Breakpoints", fontWeight = FontWeight.Bold)
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(12.dp)) {
                Text("Compact (<600dp): BottomNavigationBar")
                Text("Medium (600-839dp): NavigationRail")
                Text("Expanded (>=840dp): PermanentNavigationDrawer")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Q40, Q41, Q42: Declarative Compose & State Hoisting Counter
        Text("Q40-Q42: Declarative State Hoisting Counter", fontWeight = FontWeight.Bold)
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Stateless Counter receiving state & exposing events:")
                Spacer(modifier = Modifier.height(8.dp))
                CounterScreen() // Q42
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Practice5PartCScreenPreview() {
    Practice5PartCScreen()
}
