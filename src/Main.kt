// taller

import kotlin.math.PI
import kotlin.math.sqrt

open class Dwelling(private var residents: Int) {
    open val buildingMaterial: String = "Material"
    open val capacity: Int = 0

    fun hasRoom(): Boolean {
        return residents < capacity
    }

    fun getRoom() {
        if (hasRoom()) {
            residents++
        } else {
        }
    }

    open fun floorArea(): Double {
        return 0.0
    }

    fun printInfo() {
        println("\nTipo de vivienda: ${this::class.simpleName}")
        println("Material: $buildingMaterial")
        println("Capacidad: $capacity")
        println("Área de piso: ${floorArea()}")
    }
}

class SquareCabin(
    residents: Int,
    val length: Double
) : Dwelling(residents) {
    override val buildingMaterial = "Madera"
    override val capacity = 6
    override fun floorArea(): Double {
        return length * length
    }
}

open class RoundHut(
    residents: Int,
    val radius: Double
) : Dwelling(residents) {
    override val buildingMaterial = "Paja"
    override val capacity = 4
    override fun floorArea(): Double {
        return PI * radius * radius
    }

    fun calculateMaxCarpetSize(): Double {
        val diameter = 2 * radius
        return sqrt(2.0) * (diameter / 2)
    }
}

class RoundTower(
    residents: Int,
    radius: Double,
    val floors: Int = 2
) : RoundHut(residents, radius) {
    override val buildingMaterial = "Piedra"
    override val capacity = 4 * floors
    override fun floorArea(): Double {
        return super.floorArea() * floors
    }
}

fun main() {

    val squareCabin = SquareCabin(3, 5.0)
    val roundHut = RoundHut(2, 10.0)
    val roundTower = RoundTower(4, 15.5)

    val dwellings = listOf(squareCabin, roundHut, roundTower)

    dwellings.forEach {
        it.printInfo()
        println("¿Tiene espacio disponible? ${it.hasRoom()}")
        it.getRoom()
        println("¿Ahora tiene espacio? ${it.hasRoom()}")

        if (it is RoundHut) {
            println("Tamaño máximo del tapete: ${"%.2f".format(it.calculateMaxCarpetSize())}")
        }
    }

    println("\nPrograma terminado correctamente.")
}
