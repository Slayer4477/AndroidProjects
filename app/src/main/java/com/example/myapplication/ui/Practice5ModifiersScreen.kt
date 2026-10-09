package com.example.myapplication.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

fun Modifier.dashedBorder(
    color: Color,
    strokeWidth: Dp = 2.dp
): Modifier = this.drawBehind {
    val stroke = Stroke(
        width = strokeWidth.toPx(),
        pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
    )
    drawRoundRect(color = color, style = stroke)
}

@Composable
fun RowScope.MyRow() {
    Text("A", Modifier.weight(1f))
    Text("B", Modifier.weight(1f))
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Practice5ModifiersScreen(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp)
    ) {
        Text("Practice 5 (Q16-Q30) Demos", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        Text("Q17: Horizontal Scroll Row", fontWeight = FontWeight.Bold)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(vertical = 8.dp)
        ) {
            repeat(10) { index ->
                Card(modifier = Modifier.padding(end = 8.dp)) {
                    Text("Chip $index", modifier = Modifier.padding(12.dp))
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text("Q18: Test Tag Button", fontWeight = FontWeight.Bold)
        Button(
            onClick = {},
            modifier = Modifier.testTag("submit_button")
        ) {
            Text("Submit")
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text("Q19: Accessibility", fontWeight = FontWeight.Bold)
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .width(4.dp)
                    .height(24.dp)
                    .background(Color.Gray)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                imageVector = Icons.Default.Warning,
                contentDescription = "Warning",
                tint = Color.Red
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Error occurred")
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text("Q20: graphicsLayer Alpha", fontWeight = FontWeight.Bold)
        var alphaVal by remember { mutableFloatStateOf(0.7f) }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .graphicsLayer { alpha = alphaVal }
        ) {
            Text("Fade Card (alpha = $alphaVal)", modifier = Modifier.padding(16.dp))
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text("Q21: graphicsLayer Transform", fontWeight = FontWeight.Bold)
        Box(
            modifier = Modifier
                .size(60.dp)
                .graphicsLayer {
                    rotationZ = 45f
                    scaleX = 1.1f
                    scaleY = 1.1f
                }
                .background(MaterialTheme.colorScheme.primary)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text("Q22: Box zIndex", fontWeight = FontWeight.Bold)
        var isBeingDragged by remember { mutableStateOf(true) }
        Box(modifier = Modifier.height(60.dp)) {
            Card(
                modifier = Modifier
                    .size(50.dp)
                    .zIndex(if (isBeingDragged) 1f else 0f)
            ) {
                Text("Card 1", modifier = Modifier.padding(4.dp))
            }
            Card(
                modifier = Modifier
                    .size(50.dp)
                    .padding(start = 20.dp, top = 10.dp)
                    .zIndex(0f)
            ) {
                Text("Card 2", modifier = Modifier.padding(4.dp))
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text("Q23: Dashed Border", fontWeight = FontWeight.Bold)
        Box(
            modifier = Modifier
                .size(100.dp)
                .dashedBorder(Color.Blue, 2.dp)
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text("Dashed")
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text("Q24: Combined Clickable Marker", fontWeight = FontWeight.Bold)
        var tapText by remember { mutableStateOf("Tap or Long Press") }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .combinedClickable(
                    onClick = { tapText = "Normal Clicked!" },
                    onLongClick = { tapText = "Long Pressed!" }
                )
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .padding(16.dp)
        ) {
            Text(tapText)
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text("Q25: requiredSize(100.dp)", fontWeight = FontWeight.Bold)
        Box(
            modifier = Modifier
                .size(60.dp)
                .background(Color.LightGray)
        ) {
            Box(
                modifier = Modifier
                    .requiredSize(100.dp)
                    .background(Color.Red.copy(alpha = 0.5f))
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text("Q26: LazyColumn contentPadding", fontWeight = FontWeight.Bold)
        Box(modifier = Modifier.height(100.dp)) {
            LazyColumn(
                contentPadding = PaddingValues(16.dp)
            ) {
                items(5) { index ->
                    Text("Item $index")
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text("Q27: matchParentSize Glow", fontWeight = FontWeight.Bold)
        Box(modifier = Modifier.size(70.dp)) {
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .background(Color.Yellow, CircleShape)
            )
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .align(Alignment.Center)
                    .background(Color.Blue, CircleShape)
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text("Q28: RowScope.MyRow Extension", fontWeight = FontWeight.Bold)
        Row(modifier = Modifier.fillMaxWidth()) {
            MyRow()
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text("Q29: 80% Width Search Bar", fontWeight = FontWeight.Bold)
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Search") },
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .wrapContentWidth(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text("Q30: Rounded Background", fontWeight = FontWeight.Bold)
        Box(
            modifier = Modifier
                .size(80.dp, 40.dp)
                .background(Color.Cyan, RoundedCornerShape(20.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text("Rounded")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Practice5ModifiersScreenPreview() {
    Practice5ModifiersScreen()
}
