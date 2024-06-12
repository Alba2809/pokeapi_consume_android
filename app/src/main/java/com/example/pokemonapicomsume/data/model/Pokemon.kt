package com.example.pokemonapicomsume.data.model

import com.example.pokemonapicomsume.data.model.api.Ability
import com.example.pokemonapicomsume.data.model.api.Cries
import com.example.pokemonapicomsume.data.model.api.Form
import com.example.pokemonapicomsume.data.model.api.GameIndice
import com.example.pokemonapicomsume.data.model.api.HeldItem
import com.example.pokemonapicomsume.data.model.api.Move
import com.example.pokemonapicomsume.data.model.api.Species
import com.example.pokemonapicomsume.data.model.api.Sprites
import com.example.pokemonapicomsume.data.model.api.Stat
import com.example.pokemonapicomsume.data.model.api.Type

data class Pokemon(
    val abilities: List<Ability>,
    val base_experience: Int,
    val cries: Cries,
    val forms: List<Form>,
    val game_indices: List<GameIndice>,
    val height: Int,
    val held_items: List<HeldItem>,
    val id: Int,
    val is_default: Boolean,
    val location_area_encounters: String,
    val moves: List<Move>,
    val name: String,
    val order: Int,
    val past_abilities: List<Any>,
    val past_types: List<Any>,
    val species: Species,
    val sprites: Sprites,
    val stats: List<Stat>,
    val types: List<Type>,
    val weight: Int
)