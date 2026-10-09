package com.example.myapplication.lab8

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class Task11ViewModel : ViewModel() {
    private val _state = MutableStateFlow(Task10State())
    val state: StateFlow<Task10State> = _state.asStateFlow()

    fun onGenreClick(genre: String) {
        _state.update {
            it.copy(selectedGenre = if (it.selectedGenre == genre) null else genre)
        }
    }

    fun onArtistLikeToggled(id: Int) {
        _state.update {
            val newLikes = if (id in it.likedIds) it.likedIds - id else it.likedIds + id
            it.copy(likedIds = newLikes)
        }
    }
}
