package com.transporte.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint // <--- OBLIGATORIO para que funcione la DI
class MainActivity : ComponentActivity() { // Si usas Compose, mejor ComponentActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Aquí llamarás a tu NavHost o a tu LoginScreen()
            // Por ahora puedes dejar un texto para probar:
            // Text("App de Transporte Madrid")
        }
    }
}