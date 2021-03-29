package com.example.visor

import com.example.visor.models.Moneda
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class ExampleUnitTest : DescribeSpec({
    describe("Moneda") {
        it("En alza con variacion positiva devuelve true"){
            Moneda(variacionEn24hs=2.0).estaEnAlza() shouldBe true
        }
        it("En baja con variacion negativa falso"){
            Moneda(variacionEn24hs=-0.1).estaEnAlza() shouldBe false
        }
        it("Compara formato ok"){
            Moneda(variacionEn24hs=2.56).variacionFormateada() shouldBe "(2,56% ▲)"
        }

        // TODO: Agregar tests acá
    }
})