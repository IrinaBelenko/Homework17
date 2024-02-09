package com.example.homework17

import io.reactivex.Single
import retrofit2.http.GET

interface ApiInterface {
    @GET("/superhero-api/api/all.json")
    fun getHeroes(): Single<List<Hero>>
}