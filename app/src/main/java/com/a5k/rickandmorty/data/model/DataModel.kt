package com.a5k.rickandmorty.data.model

data class DataModel(val results: List<Character>)

data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val type: String,
    val gender: String,
    val location: Location,
    val image: String,
    val episode: List<String>,
)

data class Location(
    val name: String,
)

