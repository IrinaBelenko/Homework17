package com.example.homework17

data class Heroes(val heroes: List<Hero>)

data class Hero(
    val id: Int,
    val name: String,
    val appearance: Appear,
    val images: HeroImages
)
data class Appear(val gender: String, val race: String)
data class HeroImages(val xs: String, val sm: String)