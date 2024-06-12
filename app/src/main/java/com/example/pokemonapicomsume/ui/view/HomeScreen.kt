package com.example.pokemonapicomsume.ui.view

import android.annotation.SuppressLint
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.pokemonapicomsume.R
import com.example.pokemonapicomsume.data.model.Pokemon
import com.example.pokemonapicomsume.data.model.api.Cries
import com.example.pokemonapicomsume.ui.theme.CardPokemon
import com.example.pokemonapicomsume.ui.theme.DarkPrimary
import com.example.pokemonapicomsume.ui.view.homeComponents.Header
import com.example.pokemonapicomsume.ui.view.homeComponents.PokemonCard
import com.example.pokemonapicomsume.ui.view.homeComponents.PokemonForm
import com.example.pokemonapicomsume.ui.viewmodel.HomeViewModel
import java.io.IOException

@Preview
@Composable
fun HomeScreen(
    navController: NavController = rememberNavController(),
    viewModel: HomeViewModel = HomeViewModel()
) {
    val pokemonToFind: String by viewModel.pokemonToFind.observeAsState(initial = "")
    val isValidSubmit: Boolean by viewModel.isValidSubmit.observeAsState(initial = false)
    val isLoading: Boolean by viewModel.isLoading.observeAsState(initial = false)
    val pokemonFound: Pokemon? by viewModel.pokemonFound.observeAsState(initial = null)

    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Header()
        PokemonCard(pokemonFound)
        Column {
            PokemonForm(pokemonToFind) {
                viewModel.onInputChanged(it)
            }
            Spacer(modifier = Modifier.height(10.dp))
            ButtonSubmit(isValidSubmit, isLoading) {
                viewModel.onSubmit(pokemonToFind, context)
                keyboardController?.hide()
            }
        }
    }
}

@Composable
fun ButtonSubmit(isValidSubmit: Boolean, isLoading: Boolean, onSubmit: () -> Unit) {
    Button(
        onClick = { onSubmit() },
        enabled = isValidSubmit && !isLoading,
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = DarkPrimary
        )
    ) {
        Text(text = "Buscar", fontSize = 15.sp, fontWeight = FontWeight.Bold)
    }
}

@SuppressLint("ModifierFactoryUnreferencedReceiver")
@Composable
fun Modifier.bottomBorder(strokeWidth: Dp, color: Color): Modifier = composed(
    factory = {
        val density = LocalDensity.current
        val strokeWidthPx = density.run { strokeWidth.toPx() }

        Modifier.drawBehind {
            val width = size.width
            val height = size.height - strokeWidthPx / 2

            drawLine(
                color = color,
                start = Offset(x = 0f, y = height),
                end = Offset(x = width, y = height),
                strokeWidth = strokeWidthPx
            )
        }
    }
)