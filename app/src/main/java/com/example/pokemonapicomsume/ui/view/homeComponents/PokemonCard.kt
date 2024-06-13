package com.example.pokemonapicomsume.ui.view.homeComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.pokemonapicomsume.R
import com.example.pokemonapicomsume.data.model.Pokemon
import com.example.pokemonapicomsume.ui.theme.CardPokemon
import com.example.pokemonapicomsume.ui.theme.DarkPrimary
import com.example.pokemonapicomsume.ui.theme.InfoCardPokemon

@Preview
@Composable
fun PokemonCard(modifier: Modifier = Modifier, pokemon: Pokemon? = null) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = CardPokemon,
        ),
        modifier = modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        HeaderCard(pokemon?.id, pokemon?.name)
        AsyncImage(
            model = pokemon?.sprites?.front_default ?: R.drawable.pokeball,
            contentDescription = "Imagen del pokemon ${pokemon?.name ?: ""}",
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )
        InfoPokemon(pokemon)
        AudioPokemon(pokemon?.cries)
        //ButtonDetails(pokemon)
    }
}

@Composable
fun HeaderCard(numberPokemon: Int?, namePokemon: String?) {
    Row(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "#${numberPokemon ?: 0}",
            modifier = Modifier.padding(10.dp),
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp
        )
        Text(
            text = namePokemon ?: "...",
            modifier = Modifier.padding(10.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
    }
}

@Composable
fun InfoPokemon(pokemon: Pokemon?) {
    Column(
        modifier = Modifier
            .padding(start = 15.dp, end = 15.dp, bottom = 15.dp, top = 8.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(InfoCardPokemon)
            .fillMaxWidth()
    ) {
        Text(
            text = "Información",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(10.dp)
        )
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            Arrangement.SpaceAround
        ) {
            val height = pokemon?.height?.toDouble()?.div(10) ?: 0.0
            val weight = pokemon?.weight?.toDouble()?.div(10) ?: 0.0

            InfoItem(R.drawable.height_icon, height, "m")
            InfoItem(R.drawable.weight_icon, weight, "kg")
        }
    }
}

@Composable
fun InfoItem(icon: Int, value: Double, unitValue: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painterResource(id = icon),
            contentDescription = "Imagen del icono",
            modifier = Modifier.size(35.dp)
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = "$value $unitValue",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(10.dp)
        )
    }
}

@Composable
fun ButtonDetails(pokemon: Pokemon?) {
    Button(
        onClick = { },
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = DarkPrimary
        )
    ) {
        Text(text = "Detalles", fontSize = 15.sp, fontWeight = FontWeight.Bold)
    }
}