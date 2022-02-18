package ni.edu.uca.iva

data class Precio(private val total: Double) {
    val iva: Double
        get() = total * 0.15

    val netoTotal: Double
        get() = total + iva

}