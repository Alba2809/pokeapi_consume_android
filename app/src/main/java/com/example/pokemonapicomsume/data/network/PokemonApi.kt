package com.example.pokemonapicomsume.data.network

import com.example.pokemonapicomsume.data.model.Pokemon
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url

interface PokemonApi {
    companion object {
        const val BASE_URL = "https://pokeapi.co/api/v2/pokemon/"
        val instance =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient.Builder().build()).build().create(PokemonApi::class.java)
    }

    @GET
    suspend fun getPokemon(@Url name: String): Pokemon
}