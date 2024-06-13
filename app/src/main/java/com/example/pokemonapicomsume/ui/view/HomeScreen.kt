package com.example.pokemonapicomsume.ui.view

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pokemonapicomsume.data.model.Pokemon
import com.example.pokemonapicomsume.ui.view.homeComponents.Header
import com.example.pokemonapicomsume.ui.view.homeComponents.PokemonCard
import com.example.pokemonapicomsume.ui.view.homeComponents.PokemonForm
import com.example.pokemonapicomsume.ui.viewmodel.HomeViewModel

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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        Header()
        PokemonCard(modifier = Modifier.weight(1f), pokemonFound)
        PokemonForm(
            pokemonToFind,
            {
                viewModel.onInputChanged(it)
            },
            {
                viewModel.onSubmit(pokemonToFind, context)
            },
            isValidSubmit,
            isLoading
        )
        Spacer(modifier = Modifier.height(10.dp))
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