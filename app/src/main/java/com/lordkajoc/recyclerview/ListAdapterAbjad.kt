package com.lordkajoc.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapterAbjad(private val listAbjad: ArrayList<KumpulanAbjad>) :
    RecyclerView.Adapter<ListAdapterAbjad.ViewHolder>() {
    //Class ViewHolder
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val abjad = itemView.findViewById<TextView>(R.id.tv_abjad)
    }

    //Membuat holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_abjad, parent, false)
        return ViewHolder(view)
    }

    //Melakukan penentuan data yang akan ditampilkan pada setiap item/baris
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.abjad.text = listAbjad[position].abjad
    }
    override fun getItemCount(): Int {
        return listAbjad.size
    }
}