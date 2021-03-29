package com.example.visor.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.visor.R
import com.example.visor.api.CoinGeckoApi
import com.example.visor.models.Moneda
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {
    override val coroutineContext: CoroutineContext get() = Dispatchers.Main

    private val coinGeckoApi = CoinGeckoApi.new()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configurarVista()
    }

    private fun configurarVista() {
        // TODO: Usar coinGeckoApi para listar las moneda
        val monedas= listOf(
            Moneda(
                nombre="Moneda 1",
                precioActual=12f
            ),
            Moneda(
                nombre="Moneda 2",
                precioActual=88f
            ),
        )
    }


}