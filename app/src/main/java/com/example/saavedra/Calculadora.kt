package com.example.saavedra

class Calculadora(
    private var num2: Double,
    private var num1: Double
) {

    fun sumar(): Double {
        return num1 + num2
    }

    fun restar(): Double {
        return num1 - num2
    }

    fun multiplicar(): Double {
        return num1 * num2
    }

    fun dividir(): String {
        return if (num2 == 0.0) {
            "No se puede dividir entre cero"
        } else {
            (num1 / num2).toString()
        }
    }
}