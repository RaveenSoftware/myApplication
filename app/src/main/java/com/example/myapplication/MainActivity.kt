package com.example.myapplication

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView

import com.example.ui.theme.AppTypography
import com.example.myapplication.R
import androidx.compose.ui.res.stringResource
import androidx.core.view.WindowCompat
import com.example.compose.MyApplicationTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        // Imagen de fondo
                        Image(
                            painter = painterResource(id = R.drawable.formulaw),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )

                        // Texto encima de la imagen
                        GreetingGroup()
                    }
                }
            }
        }
    }
}

@Composable
fun GreetingGroup() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 32.dp),
        verticalArrangement = Arrangement.Top // antes estaba en Center
    ) {
        Spacer(modifier = Modifier.height(60.dp)) // espacio desde arriba
        Text(
            text = stringResource(id = R.string.saludo_f1),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onPrimary
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(id = R.string.saludo_equipo),
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onPrimary
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = stringResource(id = R.string.autores),
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onPrimary
        )
        Spacer(modifier = Modifier.height(24.dp))

        // Aquí va el botón
        Button(onClick = { /* Acción futura, por ahora lo dejamos vacío */ }) {
            Text("Ver pilotos")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            GreetingGroup()
        }
    }
}

//Definiendo una data class para los pilotos

data class Piloto(
    val nombre: String,
    val edad: Int,
    val imagenRes: Int // drawable resource
)

val listaPilotos = listOf(
    Piloto("Lewis Hamilton", 39, R.drawable.formulaw), //Ruta de la imagen
    Piloto("Max Verstappen", 26, R.drawable.formulaw),
    Piloto("Fernando Alonso", 42, R.drawable.formulaw),
    Piloto("Charles Leclerc", 26, R.drawable.formulaw)
    //Se agregan los de la temporada :P
)




