package com.example.pokemonapicomsume.data

import com.example.pokemonapicomsume.data.model.Pokemon
import com.example.pokemonapicomsume.data.network.PokemonApi

class PokemonRepository(
    private val pokemonApi: PokemonApi
) {
    suspend fun getPokemon(name: String): Result<Pokemon> {
        return try {
            val response = pokemonApi.getPokemon(name)
            Result.success(response)
        } catch (e: Exception) {
            println(e.message)
            Result.failure(e)
        }
    }
}