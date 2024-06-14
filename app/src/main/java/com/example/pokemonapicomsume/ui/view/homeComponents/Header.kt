package com.example.pokemonapicomsume.ui.view.homeComponents

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokemonapicomsume.ui.view.bottomBorder

@Composable
fun Header() {
    Box(
        modifier = Modifier
            .bottomBorder(1.dp, Color.LightGray)
            .fillMaxWidth()
            .padding(top = 30.dp, start = 10.dp, bottom = 10.dp, end = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Buscar Pokemon", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
    }
}