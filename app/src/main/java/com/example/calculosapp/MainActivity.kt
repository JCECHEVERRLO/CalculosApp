package com.example.calculosapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calculosapp.vista.PantallaPrincipal
import com.example.calculosapp.vistaModelo.PrincipalVistaModelo

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val principalVistaModelo: PrincipalVistaModelo = viewModel()
            PantallaPrincipal(principalVistaModelo)
        }
    }
}