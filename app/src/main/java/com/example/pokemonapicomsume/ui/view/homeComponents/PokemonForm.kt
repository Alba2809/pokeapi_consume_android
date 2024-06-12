package com.example.pokemonapicomsume.ui.view.homeComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pokemonapicomsume.R
import com.example.pokemonapicomsume.ui.theme.DarkPrimary

@Preview
@Composable
fun PokemonForm(pokemon: String = "", onValueChange: (String) -> Unit = {}) {
    Row(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth()
            .border(1.dp, Color.Gray, RectangleShape)
    ){
        Image(
            painterResource(id = R.drawable.search_icon),
            contentDescription = "Icono de busqueda",
            modifier = Modifier.size(25.dp)
        )
        TextField(
            value = pokemon,
            onValueChange = { onValueChange(it) },
            modifier = Modifier
                .fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                focusedIndicatorColor = DarkPrimary
            ),
            singleLine = true,
            maxLines = 1
        )
    }
}
