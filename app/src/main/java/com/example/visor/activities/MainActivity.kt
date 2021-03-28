package com.example.visor.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.visor.R
import com.example.visor.api.CoinGeckoApi
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
        // TODO: Usar coinGeckoApi para listar las monedas
        EtiquetaSaludo.text="Hola desde Casa"
    }
}