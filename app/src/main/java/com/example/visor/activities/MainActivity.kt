package com.example.visor.activities


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.visor.R
import com.example.visor.api.CoinGeckoApi
import com.example.visor.models.Moneda
import j3.simple_recycler_adapter.SimpleRecyclerAdapter
import j3.simple_recycler_adapter.setup
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_moneda.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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

        val adapter = SimpleRecyclerAdapter<Moneda>(R.layout.item_moneda) { view, moneda, _ ->
            view.etiquetaNombre.text = moneda.nombre

            view.etiquetaPrecio.text = moneda.precioActual.toString()
            view.etiqueta_variacion.text=moneda.variacionFormateada()
            view.etiqueta_variacion.setTextColor(
                    resources.getColor(
                    if(moneda.estaEnAlza()) R.color.alza else R.color.baja
            ))
            Glide.with(this).load(moneda.icono).into(view.imagen_icono)
        }
        lista_monedas.setup(adapter)

        cargarMonedas(adapter)
        }

    private fun cargarMonedas(adapter: SimpleRecyclerAdapter<Moneda>) {
        launch {
            val monedas = coinGeckoApi.todasLasMonedas()
            adapter.populate(monedas)
        }
    }
}


