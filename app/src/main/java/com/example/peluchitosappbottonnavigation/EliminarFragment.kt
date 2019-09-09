package com.example.peluchitosappbottonnavigation

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_eliminar.view.*
import java.lang.Exception

class EliminarFragment : Fragment() {

    var interfaz: Comunicador ?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_eliminar, container, false)

        view.b_eliminar.setOnClickListener(){
            var nombrePeluche = view.nombre3.text.toString()
            interfaz?.enviarNombreEliminar(nombrePeluche)
        }

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try{
            interfaz = context as Comunicador
        }catch (e: Exception){
            Log.d("exception",e.toString())
        }
    }
}
