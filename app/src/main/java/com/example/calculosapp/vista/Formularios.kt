package com.example.calculosapp.vista

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.calculosapp.vistaModelo.PrincipalVistaModelo

@Composable
fun FormularioProducto(principalVistaModelo: PrincipalVistaModelo) {
    var precioBase by remember { mutableStateOf("") }
    var precioVenta by remember { mutableStateOf("") }
    var costosFijos by remember { mutableStateOf("") }
    var costoVariable by remember { mutableStateOf("") }
    var ingresos by remember { mutableStateOf("") }
    var inversion by remember { mutableStateOf("") }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        TextField(
            value = precioBase,
            onValueChange = { precioBase = it },
            label = { Text("Precio Base") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = precioVenta,
            onValueChange = { precioVenta = it },
            label = { Text("Precio Venta") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = costosFijos,
            onValueChange = { costosFijos = it },
            label = { Text("Costos Fijos") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = costoVariable,
            onValueChange = { costoVariable = it },
            label = { Text("Costo Variable") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = ingresos,
            onValueChange = { ingresos = it },
            label = { Text("Ingresos") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = inversion,
            onValueChange = { inversion = it },
            label = { Text("Inversión") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            principalVistaModelo.calcularProducto(
                precioBase.toDoubleOrNull() ?: 0.0,
                precioVenta.toDoubleOrNull() ?: 0.0,
                costosFijos.toDoubleOrNull() ?: 0.0,
                costoVariable.toDoubleOrNull() ?: 0.0,
                ingresos.toDoubleOrNull() ?: 0.0,
                inversion.toDoubleOrNull() ?: 0.0
            )
        }) {
            Text("Calcular")
        }
    }
}

@Composable
fun FormularioEmpleador(principalVistaModelo: PrincipalVistaModelo) {
    var salarioBase by remember { mutableStateOf("") }
    var empleados by remember { mutableStateOf("") }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        TextField(
            value = salarioBase,
            onValueChange = { salarioBase = it },
            label = { Text("Salario Base") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = empleados,
            onValueChange = { empleados = it },
            label = { Text("Número de Empleados") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            principalVistaModelo.calcularEmpleador(
                salarioBase.toDoubleOrNull() ?: 0.0,
                empleados.toIntOrNull() ?: 0
            )
        }) {
            Text("Calcular")
        }
    }
}

@Composable
fun FormularioEmpleado(principalVistaModelo: PrincipalVistaModelo) {
    var salarioBase by remember { mutableStateOf("") }
    var horasExtrasDiurnas by remember { mutableStateOf("") }
    var horasExtrasNocturnas by remember { mutableStateOf("") }
    var horasFestivas by remember { mutableStateOf("") }
    var bonificaciones by remember { mutableStateOf("") }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        TextField(
            value = salarioBase,
            onValueChange = { salarioBase = it },
            label = { Text("Salario Base") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = horasExtrasDiurnas,
            onValueChange = { horasExtrasDiurnas = it },
            label = { Text("Horas Extras Diurnas") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = horasExtrasNocturnas,
            onValueChange = { horasExtrasNocturnas = it },
            label = { Text("Horas Extras Nocturnas") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = horasFestivas,
            onValueChange = { horasFestivas = it },
            label = { Text("Horas Festivas/Dominicales") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = bonificaciones,
            onValueChange = { bonificaciones = it },
            label = { Text("Bonificaciones") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            principalVistaModelo.calcularEmpleado(
                salarioBase.toDoubleOrNull() ?: 0.0,
                horasExtrasDiurnas.toIntOrNull() ?: 0,
                horasExtrasNocturnas.toIntOrNull() ?: 0,
                horasFestivas.toIntOrNull() ?: 0,
                bonificaciones.toDoubleOrNull() ?: 0.0
            )
        }) {
            Text("Calcular")
        }
    }
}
