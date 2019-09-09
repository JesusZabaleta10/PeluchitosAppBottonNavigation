package com.example.peluchitosappbottonnavigation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.peluchitos_item.view.*

class PeluchitoAdapter : RecyclerView.Adapter<PeluchitoAdapter.PeluchitosViewHolder> {

    private var listPeluchitos: List<Peluchito>? = null
    private var context: Context? = null

    constructor(listPeluchitos: List<Peluchito>, context: Context){
        this.listPeluchitos = listPeluchitos
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeluchitosViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.peluchitos_item,parent,false)
        return PeluchitosViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listPeluchitos?.size!!
    }

    override fun onBindViewHolder(holder: PeluchitosViewHolder, position: Int) {
        var peluchitos = listPeluchitos!![position]
        holder.loadItem(peluchitos)
    }

    class PeluchitosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun loadItem(peluchitos: Peluchito){
            itemView.t_id2.text = peluchitos.id
            itemView.t_nombre2.text = peluchitos.nombre
            itemView.t_cantidad2.text = peluchitos.cantidad
            itemView.t_precio2.text = peluchitos.precio
        }
    }
}