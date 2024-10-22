package com.example.etapaproductiva

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.etapaproductiva.ui.theme.EtapaProductivaTheme

class InstructorActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EtapaProductivaTheme {
                InstructorScreen()
            }
        }
    }

    @Composable
    fun InstructorScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            HeaderSection() // Aquí se llama a HeaderSection
            Spacer(modifier = Modifier.height(8.dp)) // Espaciador opcional
            NotificationBar() // Añadir la barra verde aquí
            Spacer(modifier = Modifier.height(16.dp))
            SearchBar()
            Spacer(modifier = Modifier.height(16.dp))
            InstructorGrid()
        }
    }

    @Composable
    fun HeaderSection() {
        Row(
            modifier = Modifier.padding(0.dp), // Sin padding para mantener las medidas
            verticalAlignment = Alignment.Top // Cambiar a Alignment.Top
        ) {
            // Logo SENA
            Image(
                painter = painterResource(id = R.drawable.logo_sena),
                contentDescription = "Logo SENA",
                modifier = Modifier.size(70.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))

            // Logo Etapa Productiva
            Image(
                painter = painterResource(id = R.drawable.logo_etapaproductiva),
                contentDescription = "Logo Etapa Productiva",
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))

            // Textos
            Column {
                Text(
                    "Etapa\nProductiva",
                    fontSize = 13.sp,
                    color = Color(0xFF009E00),
                    modifier = Modifier
                        .padding(top = 6.dp) // Ajusta la distancia hacia abajo
                        .offset(x = (-5).dp) // Desplaza el texto hacia la izquierda
                )
                Spacer(modifier = Modifier.height(15.dp)) // Espaciador para bajar el texto "Centro de Comercio y Servicios"
                Text(
                    "Centro de Comercio y Servicios",
                    fontSize = 14.sp,
                    color = Color(0xFF009E00),
                    modifier = Modifier.offset(x = (-30).dp) // Desplazar 30 dp hacia la izquierda
                )
            }

            Spacer(modifier = Modifier.weight(1f)) // Para empujar el icono del usuario a la derecha

            // Icono de usuario
            Image(
                painter = painterResource(id = R.drawable.user_icon),
                contentDescription = "User Icon",
                modifier = Modifier.size(45.dp)
            )
        }
    }

    @Composable
    fun NotificationBar() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .background(Color(0xFF009E00)), // Barra verde
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                painter = painterResource(id = R.drawable.notificaciones_icon),
                contentDescription = "Notification Icon",
                modifier = Modifier.size(60.dp),
                colorFilter = ColorFilter.tint(Color.White) // Cambia el color a blanco
            )
        }
    }

    @Composable
    fun SearchBar() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Search Input
            TextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp)
                    .padding(horizontal = 2.dp),
                placeholder = { Text(text = "Buscar...") }
            )

            Spacer(modifier = Modifier.width(2.dp))

            // Botón de agregar
            IconButton(onClick = {}, modifier = Modifier.size(36.dp)) {
                Icon(
                    painter = painterResource(id = R.drawable.mas),
                    contentDescription = "Agregar",
                    tint = Color.Green,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }

    @Composable
    fun InstructorGrid() {
        Column {
            repeat(4) { // Número de filas
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    repeat(2) { // Cambiado para tener 2 tarjetas por fila
                        InstructorCard(modifier = Modifier.size(170.dp))
                    }
                }
            }
        }
    }

    @Composable
    fun InstructorCard(modifier: Modifier = Modifier) {
        Column(
            modifier = modifier
                .padding(8.dp)
                .border(2.dp, Color.Green, shape = MaterialTheme.shapes.medium)
                .padding(16.dp)
                .clickable { },
            horizontalAlignment = Alignment.CenterHorizontally // Alinea horizontalmente al centro
        ) {
            Image(
                painter = painterResource(id = R.drawable.instructor),
                contentDescription = "Instructor Icon",
                modifier = Modifier.size(60.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Nombre Completo", fontSize = 12.sp, fontWeight = FontWeight.Bold)
            Text(text = "Cédula", fontSize = 10.sp)
            Text(text = "Sede", fontSize = 10.sp)
            Text(text = "Aprendices: 0", fontSize = 10.sp)
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        EtapaProductivaTheme {
            InstructorScreen()
        }
    }
}

