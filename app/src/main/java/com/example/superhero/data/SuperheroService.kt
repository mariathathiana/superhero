package com.example.superhero.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


interface SuperheroService {

    @GET("search/{name}")
    suspend fun findSuperheroesByName(@Path("name") query: String): SuperheroResponse

    @GET("{character-id}")
    suspend fun getSuperheroById(@Path("character-id") id: String): Superhero

    companion object {
        fun getInstance(): com.example.superhero.data.SuperheroService {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://www.superheroapi.com/api.php/7252591128153666/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(com.example.superhero.data.SuperheroService::class.java)
        }
    }




}