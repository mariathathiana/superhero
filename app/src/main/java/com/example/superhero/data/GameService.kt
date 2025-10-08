package com.example.superhero.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface GameService {

    @GET("games")
    suspend fun findSuperheroesByName(): SuperheroResponse

    @GET("game")
    suspend fun getSuperheroById(@Query("d") id: String): Superhero

    companion object {
        fun getInstance(): com.example.superhero.data.GameService {
            val retrofit = Retrofit.Builder()
                .baseUrl(" https://www.freetogame.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(com.example.superhero.data.GameService::class.java)
        }
    }




}