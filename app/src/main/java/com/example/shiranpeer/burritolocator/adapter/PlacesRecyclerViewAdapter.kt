package com.example.shiranpeer.burritolocator.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

import com.example.shiranpeer.burritolocator.model.Place
import com.example.shiranpeer.burritolocator.viewholder.PlacesViewHolder

class PlacesRecyclerViewAdapter(private val placesList: MutableList<Place>) : RecyclerView.Adapter<PlacesViewHolder>() {

    override fun getItemCount(): Int {
        return placesList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlacesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return PlacesViewHolder.create(layoutInflater, parent)
    }

    override fun onBindViewHolder(holder: PlacesViewHolder, position: Int) {
        val place = placesList[position]

        holder.bind(place)
    }

    fun addItems(places: List<Place>) {
        placesList.addAll(places)
        notifyDataSetChanged()
    }
}