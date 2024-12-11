package modelo

data class CalculosProducto(
    val precioBase: Double,
    val precioVenta: Double,
    val costosFijos: Double,
    val costoVariableUnitario: Double,
    val ingresos: Double,
    val inversion: Double
) {
    fun calcularPrecioConIVA(): Double = precioBase * 1.19
    fun calcularMargenGanancia(): Double = ((precioVenta - precioBase) / precioVenta) * 100
    fun calcularPuntoEquilibrio(): Double = costosFijos / (precioVenta - costoVariableUnitario)
    fun calcularROI(): Double = ((ingresos - inversion) / inversion) * 100
}

