package com.example.myapplication.lab8

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class News(val title: String, val subtitle: String, val views: Int)

@Composable
fun Task04_Header(news: News) {
    SideEffect { Log.d("Recompose", "Header(news)") }
    Column {
        Text(news.title)
        Text(news.subtitle)
    }
}

@Composable
fun Task04_Header(title: String, subtitle: String) {
    SideEffect { Log.d("Recompose", "Header(title, subtitle)") }
    Column {
        Text(title)
        Text(subtitle)
    }
}

@Composable
fun Task04_NewsScreen(modifier: Modifier = Modifier) {
    var news by remember {
        mutableStateOf(News("Compose is declarative", "State in, UI out", views = 0))
    }

    Column(modifier = modifier.padding(24.dp)) {
        Task04_Header(news)
        Task04_Header(news.title, news.subtitle)
        Text("Views: ${news.views}")
        Button(onClick = { news = news.copy(views = news.views + 1) }) {
            Text("Add view")
        }
    }
}
