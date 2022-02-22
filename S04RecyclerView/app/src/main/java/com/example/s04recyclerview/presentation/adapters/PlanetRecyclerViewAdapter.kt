package com.example.s04recyclerview.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.s04recyclerview.R
import com.example.s04recyclerview.domain.models.Planet

class PlanetRecyclerViewAdapter(val planets: List<Planet>) : RecyclerView.Adapter<PlanetRecyclerViewAdapter.ViewHolder>(){


    // Gestion d'un item de la collection (une planète)
    // L'équivalent d'une carte
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_planet, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return planets.size
    }
}