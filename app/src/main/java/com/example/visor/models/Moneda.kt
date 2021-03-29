package com.example.visor.models

import com.google.gson.annotations.SerializedName

data class Moneda(
    val id: String = "",

    @SerializedName("name")
    val nombre: String = "",

    @SerializedName("image")
    val icono: String = "",

    @SerializedName("current_price")
    val precioActual: Float = 0f,

    @SerializedName("price_change_percentage_24h")
    val variacionEn24hs: Double = 0.0,

    @SerializedName("marked_cap_rank")
    val ranking: Int = 0
){
    fun estaEnAlza():Boolean=variacionEn24hs>=0


    private fun variacionPorcentaje()= "%.2f".format(variacionEn24hs)

    fun variacionFormateada()= "(${variacionPorcentaje()}%${simboloDeVariacion()})"
    private fun simboloDeVariacion()= if (estaEnAlza()) " ▲" else " ▼"


}