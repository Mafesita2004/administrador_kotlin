package com.example.etapaproductiva

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ApprenticeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApprenticeScreen()
        }
    }

    @Composable
    fun ApprenticeScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            HeaderSection()
            Spacer(modifier = Modifier.height(8.dp))
            NotificationBar()
            Spacer(modifier = Modifier.height(16.dp))
            SearchBar()
            Spacer(modifier = Modifier.height(16.dp))
            InstructorGrid()
        }
    }

    @Composable
    fun HeaderSection() {
        Row(
            modifier = Modifier.padding(0.dp),
            verticalAlignment = Alignment.Top
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
                        .padding(top = 6.dp)
                        .offset(x = (-5).dp)
                )
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    "Centro de Comercio y Servicios",
                    fontSize = 14.sp,
                    color = Color(0xFF009E00),
                    modifier = Modifier.offset(x = (-30).dp)
                )
            }

            Spacer(modifier = Modifier.weight(1f))

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
                .background(Color(0xFF009E00)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                painter = painterResource(id = R.drawable.notificaciones_icon),
                contentDescription = "Notification Icon",
                modifier = Modifier.size(60.dp),
                colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(Color.White)
            )
            // Contador de notificaciones (puedes ajustarlo según tus necesidades)
            Text(
                text = "5", // Ejemplo de contador de notificaciones
                color = Color.White,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .background(Color.Red, shape = androidx.compose.foundation.shape.CircleShape)
                    .padding(4.dp),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
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
            repeat(4) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    repeat(2) {
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
                .border(2.dp, Color.Green)
                .padding(16.dp)
                .clickable { },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.aprendiz),
                contentDescription = "Aprendiz Icon",
                modifier = Modifier.size(60.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Nombre Completo", fontSize = 12.sp, fontWeight = FontWeight.Bold)
            Text(text = "Cédula", fontSize = 10.sp)
            Text(text = "Ficha", fontSize = 10.sp)
            Text(text = "Programa", fontSize = 10.sp)
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        ApprenticeScreen()
    }
}
