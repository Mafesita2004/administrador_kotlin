package com.example.etapaproductiva

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class TemplateActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TemplateScreen()
        }
    }

    @Composable
    fun TemplateScreen() {
        Text("Template Activity")
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        TemplateScreen()
    }
}
