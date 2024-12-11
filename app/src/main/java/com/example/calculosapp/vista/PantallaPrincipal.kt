package com.example.calculosapp.vista

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.calculosapp.vistaModelo.PrincipalVistaModelo

@Composable
fun PantallaPrincipal(principalVistaModelo: PrincipalVistaModelo) {
    val categoriaSeleccionada by principalVistaModelo.categoriaSeleccionada
    val historial by principalVistaModelo.historial

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Selecciona una categoría de cálculo", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { principalVistaModelo.seleccionarCategoria("Producto") }) {
            Text("Producto")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { principalVistaModelo.seleccionarCategoria("Empleador") }) {
            Text("Empleador")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { principalVistaModelo.seleccionarCategoria("Empleado") }) {
            Text("Empleado")
        }

        Spacer(modifier = Modifier.height(32.dp))

        if (categoriaSeleccionada.isNotEmpty()) {
            when (categoriaSeleccionada) {
                "Producto" -> FormularioProducto(principalVistaModelo)
                "Empleador" -> FormularioEmpleador(principalVistaModelo)
                "Empleado" -> FormularioEmpleado(principalVistaModelo)
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text("Historial de Cálculos", style = MaterialTheme.typography.titleLarge)
        historial.forEach { registro ->
            Text(text = registro, style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
