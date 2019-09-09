package com.example.peluchitosappbottonnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_buscar.view.*

class BuscarFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    var pelucheBuscar : MutableList<Peluchito> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_buscar, container, false)

        var peluche = arguments?.getParcelableArrayList<Peluchito>("peluches")!!

        view.b_buscar.setOnClickListener(){
            for(i in peluche){
                if(i.nombre == view.nombre2.text.toString()){
                    pelucheBuscar.add(i)
                    Toast.makeText(view.context, "Busqueda exitosa", Toast.LENGTH_SHORT).show()
                    break
                }else {
                    Toast.makeText(view.context, "No hay peluche con ese nombre", Toast.LENGTH_SHORT).show()
                }
            }

            recyclerView  = view.findViewById(R.id.recycler2) as RecyclerView
            recyclerView.setHasFixedSize(true)
            recyclerView.layoutManager = LinearLayoutManager(view.context, RecyclerView.VERTICAL,false)

            val pelucheAdapter = PeluchitoAdapter(pelucheBuscar,view.context)
            recyclerView.adapter = pelucheAdapter

            pelucheBuscar = ArrayList()
        }

        return view
    }
}
