package com.example.peluchitosappbottonnavigation

import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), Comunicador {

    var peluchito : MutableList<Peluchito> = ArrayList()

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()

        when (item.itemId) {
            R.id.agregar -> {
                val agregarFragment = AgregarFragment()
                transaction.replace(R.id.contenedor, agregarFragment).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.buscar -> {
                val buscarFragment = BuscarFragment()
                val bundle = Bundle()
                bundle.putParcelableArrayList("peluches", ArrayList<Peluchito>(peluchito))
                buscarFragment.arguments = bundle
                transaction.replace(R.id.contenedor, buscarFragment).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.eliminar -> {
                val eliminarFragment = EliminarFragment()
                transaction.replace(R.id.contenedor, eliminarFragment).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.inventario -> {
                val inventarioFragment = InventarioFragment()
                val bundle = Bundle()
                bundle.putParcelableArrayList("peluches", ArrayList<Peluchito>(peluchito))
                inventarioFragment.arguments = bundle
                transaction.replace(R.id.contenedor, inventarioFragment).commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()

        val agregarFragment = AgregarFragment()
        transaction.add(R.id.contenedor, agregarFragment).commit()

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

    override fun enviarDatos(id: String, nombre: String, cantidad: String, precio: String) {
        var peluche = Peluchito(id,nombre,cantidad,precio)
        peluchito.add(peluche)
    }

    override fun enviarNombreEliminar(nombreEliminar: String) {
        for (i in peluchito) {
            if (i.nombre == nombreEliminar) {
                Toast.makeText(this, "Se ha eliminado el peluche '$nombreEliminar'", Toast.LENGTH_SHORT).show()
                peluchito.remove(i)
                break
            }else{
                Toast.makeText(this, "No hay peluche con ese nombre", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
