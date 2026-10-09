package com.example.myapplication.lab8

const val REQUIRED_LIKES_COUNT = 3

data class ArtistModel(
    val id: Int,
    val name: String,
    val genre: String
)

val sampleArtistsList = listOf(
    ArtistModel(1, "Nilufar Skye", "Pop"),
    ArtistModel(2, "Amir Neon", "Pop"),
    ArtistModel(3, "Zarina Bloom", "Pop"),
    ArtistModel(4, "Iron Caravan", "Rock"),
    ArtistModel(5, "Qora Tun", "Rock"),
    ArtistModel(6, "Steel Orchard", "Rock"),
    ArtistModel(7, "Midnight Samarkand", "Jazz"),
    ArtistModel(8, "Blue Registan", "Jazz"),
    ArtistModel(9, "Saida Quartet", "Jazz"),
    ArtistModel(10, "Silk Road Duo", "Folk"),
    ArtistModel(11, "Navruz Ensemble", "Folk"),
    ArtistModel(12, "Chor Minor", "Folk")
)

data class Task10State(
    val artists: List<ArtistModel> = sampleArtistsList,
    val selectedGenre: String? = null,
    val likedIds: Set<Int> = emptySet()
) {
    val genres: List<String>
        get() = artists.map { it.genre }.distinct()

    val visibleArtists: List<ArtistModel>
        get() = if (selectedGenre == null) artists else artists.filter { it.genre == selectedGenre }

    val likedCount: Int
        get() = likedIds.size

    val canContinue: Boolean
        get() = likedCount >= REQUIRED_LIKES_COUNT
}
