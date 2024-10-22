package com.example.etapaproductiva

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.ColorFilter


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }

    @Composable
    fun MainScreen() {
        Column(
            modifier = Modifier.fillMaxSize().background(Color.White),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HeaderSection()
            NotificationBar()
            ButtonGrid()
        }
    }

    @Composable
    fun HeaderSection() {
        Row(
            modifier = Modifier.padding(16.dp),
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
                .background(Color(0xFF009E00)),
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
    fun ButtonGrid() {
        Column(modifier = Modifier.padding(16.dp)) {
            // Aquí puedes usar Column para apilar los botones verticalmente
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp) // Espaciado entre botones
            ) {
                ActionButton("Instructores", R.drawable.instructor_icono) {
                    Log.d("MainActivity", "Instructores button clicked")
                    startActivity(Intent(this@MainActivity, InstructorActivity::class.java))
                }
                ActionButton("Aprendices", R.drawable.aprendiz_icono) {
                    Log.d("MainActivity", "Aprendices button clicked")
                    startActivity(Intent(this@MainActivity, ApprenticeActivity::class.java))
                }
                ActionButton("Gráficas", R.drawable.graficas) {
                    Log.d("MainActivity", "Gráficas button clicked")
                    startActivity(Intent(this@MainActivity, GraphicActivity::class.java))
                }
                ActionButton("Plantillas", R.drawable.template_icon) {
                    Log.d("MainActivity", "Plantillas button clicked")
                    startActivity(Intent(this@MainActivity, TemplateActivity::class.java))
                }
            }
        }
    }

    @Composable
    fun ActionButton(text: String, iconRes: Int, onClick: () -> Unit) {
        Box(
            modifier = Modifier
                .size(300.dp, 150.dp) // Cambia el tamaño según sea necesario
                .padding(8.dp)
                .shadow(elevation = 8.dp, shape = RoundedCornerShape(8.dp), clip = false) // Sombra difuminada
        ) {
            Button(
                onClick = onClick,
                modifier = Modifier.fillMaxSize(), // Ocupa todo el espacio del Box
                shape = RoundedCornerShape(8.dp),
                colors = androidx.compose.material.ButtonDefaults.buttonColors(backgroundColor = Color.White)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = iconRes),
                        contentDescription = text,
                        modifier = Modifier.size(40.dp)
                    )
                    Text(text = text)
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        MainScreen()
    }
}