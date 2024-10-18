package com.example.etapaproductiva

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class InstructorActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstructorScreen()
        }
    }

    @Composable
    fun InstructorScreen() {
        Text("Instructor Activity")
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        InstructorScreen()
    }
}
