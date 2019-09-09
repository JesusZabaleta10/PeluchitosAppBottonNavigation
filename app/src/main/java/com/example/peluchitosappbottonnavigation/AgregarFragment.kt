package com.example.peluchitosappbottonnavigation

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_agregar.view.*

class AgregarFragment : Fragment() {

    var interfaz: Comunicador ?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_agregar, container, false)

        view.b_agregar.setOnClickListener {

            var identificacion = view.identificador.text.toString()
            var nombre = view.nombre.text.toString()
            var cantidad = view.cantidad.text.toString()
            var precio = view.precio.text.toString()

            if((identificacion == "") || (nombre == "") || (cantidad == "") || (precio == "")){
                Toast.makeText(view.context, "No se han llenado todos los campos", Toast.LENGTH_SHORT).show()
            }else{
                interfaz?.enviarDatos(identificacion,nombre,cantidad,precio)
                Toast.makeText(view.context, "Has agregado un peluche", Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            interfaz = context as Comunicador
        }catch (e:Exception){
            Log.d("exception", e.toString())
        }
    }
}
