package com.example.pokemonapicomsume.ui.view.homeComponents

import android.content.Context
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokemonapicomsume.R
import com.example.pokemonapicomsume.data.model.api.Cries
import com.example.pokemonapicomsume.ui.theme.InfoCardPokemon
import java.io.IOException

@Composable
fun AudioPokemon(cries: Cries?) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(InfoCardPokemon)
            .fillMaxWidth(),
    ) {
        Text(
            text = "Sonidos",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(10.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp, bottom = 10.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ){
            cries.let {
                ButtonCry(context, cries?.latest ?: "", "Latest")
                Spacer(modifier = Modifier.width(15.dp))
                ButtonCry(context, cries?.legacy ?: "", "Legacy")
            }
        }
    }
}

@Composable
fun ButtonCry(context: Context, audio: String, title: String) {
    Button(
        onClick = {
            val mediaPlayer = MediaPlayer()
            mediaPlayer.setAudioAttributes(
                AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build()
            )
            try {
                mediaPlayer.setDataSource(context, Uri.parse(audio))
                mediaPlayer.prepare()
                mediaPlayer.start()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        },
        colors = ButtonDefaults.buttonColors(Color.Transparent),
        contentPadding = PaddingValues(horizontal = 15.dp, vertical = 8.dp),
        enabled = audio.isNotEmpty()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painterResource(id = R.drawable.audio_wave),
                contentDescription = "Icono de audio",
                modifier = Modifier.size(35.dp)
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
        }
    }
}
