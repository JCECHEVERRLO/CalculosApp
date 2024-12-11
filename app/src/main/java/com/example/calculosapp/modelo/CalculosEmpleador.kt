package modelo

data class CalculosEmpleador(
    val salarioBase: Double
) {
    fun calcularAportesParafiscales(): Double = salarioBase * 0.09
    fun calcularSeguridadSocial(): Double = salarioBase * 0.205
    fun calcularPrestacionesSociales(): Double = salarioBase * 0.2183
}