package com.example.pokemonapicomsume.ui.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonapicomsume.data.PokemonRepository
import com.example.pokemonapicomsume.data.model.Pokemon
import com.example.pokemonapicomsume.data.network.PokemonApi
import kotlinx.coroutines.launch

class HomeViewModel(
    private val pokemonRepository: PokemonRepository = PokemonRepository(PokemonApi.instance)
): ViewModel() {
    private val _pokemonToFind = MutableLiveData<String>()
    val pokemonToFind: LiveData<String> = _pokemonToFind

    private val _isValidSubmit = MutableLiveData<Boolean>()
    val isValidSubmit: LiveData<Boolean> = _isValidSubmit

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _pokemonFound = MutableLiveData<Pokemon?>()
    val pokemonFound: LiveData<Pokemon?> = _pokemonFound

    fun onInputChanged(pokemon: String){
        _pokemonToFind.value = pokemon
        _isValidSubmit.value = isValidPokemon(pokemon)
    }

    fun onSubmit(pokemon: String, context: Context){
        viewModelScope.launch {
            _isLoading.value = true
            pokemonRepository.getPokemon(pokemon).onSuccess {
                _pokemonFound.value = it
            }.onFailure {
                Toast.makeText(context, "No se encontró al pokemon.", Toast.LENGTH_SHORT).show()
            }

            _isLoading.value = false
        }
    }

    private fun isValidPokemon(name: String): Boolean = name.isNotEmpty()
}