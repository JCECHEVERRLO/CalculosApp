package modelo

data class CalculosEmpleado(
    val salarioBase: Double,
    val horasExtras: Int,
    val bonificaciones: Double
) {
    fun calcularSalarioNeto(): Double = salarioBase - (salarioBase * 0.08)
    fun calcularHoraExtraDiurna(): Double = (salarioBase / 240) * 1.25
    fun calcularHoraExtraNocturna(): Double = (salarioBase / 240) * 1.75
    fun calcularHoraDominical(): Double = (salarioBase / 240) * 2
}
