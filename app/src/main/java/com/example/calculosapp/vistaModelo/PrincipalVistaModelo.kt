package com.example.calculosapp.vistaModelo

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf

class PrincipalVistaModelo : ViewModel() {
    val categoriaSeleccionada = mutableStateOf("")
    val resultado = mutableStateOf("")
    val historial = mutableStateOf(listOf<String>())

    fun seleccionarCategoria(categoria: String) {
        categoriaSeleccionada.value = categoria
    }

    fun limpiarSeleccion() {
        categoriaSeleccionada.value = ""
        resultado.value = ""
    }

    private fun agregarAlHistorial(categoria: String, calculo: String) {
        historial.value = historial.value + "[$categoria] $calculo"
    }

    // Cálculos para Producto
    fun calcularProducto(precioBase: Double, precioVenta: Double, costosFijos: Double, costoVariable: Double, ingresos: Double, inversion: Double) {
        val precioConIVA = precioBase * 1.19
        val margenGanancia = ((precioVenta - precioBase) / precioVenta) * 100
        val puntoEquilibrio = if (precioVenta - costoVariable > 0) costosFijos / (precioVenta - costoVariable) else 0.0
        val roi = if (inversion != 0.0) ((ingresos - inversion) / inversion) * 100 else 0.0

        val calculo = """
            Precio con IVA: $precioConIVA
            Margen de ganancia: ${"%.2f".format(margenGanancia)}%
            Punto de equilibrio: ${"%.2f".format(puntoEquilibrio)}
            ROI: ${"%.2f".format(roi)}%
        """.trimIndent()

        resultado.value = calculo
        agregarAlHistorial("Producto", calculo)
    }

    // Cálculos para Empleador
    fun calcularEmpleador(salarioBase: Double, empleados: Int) {
        val aportesParafiscales = salarioBase * 0.09
        val seguridadSocial = salarioBase * 0.205
        val prestaciones = salarioBase * 0.2183
        val costoTotalNomina = (salarioBase + aportesParafiscales + seguridadSocial + prestaciones) * empleados

        val calculo = """
            Aportes parafiscales: $aportesParafiscales
            Seguridad social: $seguridadSocial
            Prestaciones sociales: $prestaciones
            Costo total de nómina: $costoTotalNomina
        """.trimIndent()

        resultado.value = calculo
        agregarAlHistorial("Empleador", calculo)
    }

    // Cálculos para Empleado
    fun calcularEmpleado(salarioBase: Double, horasExtrasDiurnas: Int, horasExtrasNocturnas: Int, horasFestivas: Int, bonificaciones: Double) {
        val deducciones = salarioBase * 0.08 // (Pensión 4% + Salud 4%)
        val salarioNeto = salarioBase - deducciones
        val horaExtraDiurna = (salarioBase / 240) * 1.25 * horasExtrasDiurnas
        val horaExtraNocturna = (salarioBase / 240) * 1.75 * horasExtrasNocturnas
        val horaFestiva = (salarioBase / 240) * 2 * horasFestivas
        val totalHorasExtras = horaExtraDiurna + horaExtraNocturna + horaFestiva
        val salarioTotal = salarioNeto + totalHorasExtras + bonificaciones

        val calculo = """
            Salario neto: $salarioNeto
            Deducciones: $deducciones
            Total horas extras: $totalHorasExtras
            Bonificaciones: $bonificaciones
            Salario total: $salarioTotal
        """.trimIndent()

        resultado.value = calculo
        agregarAlHistorial("Empleado", calculo)
    }
}