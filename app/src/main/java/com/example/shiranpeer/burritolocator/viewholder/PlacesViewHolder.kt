package com.example.shiranpeer.burritolocator.viewholder

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

import com.example.shiranpeer.burritolocator.Constant
import com.example.shiranpeer.burritolocator.R
import com.example.shiranpeer.burritolocator.databinding.PlaceItemBinding
import com.example.shiranpeer.burritolocator.model.Place
import com.example.shiranpeer.burritolocator.screen.PlacesOnMapActivity
import com.example.shiranpeer.burritolocator.util.StringUtil

class PlacesViewHolder(private val binding: PlaceItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(place: Place) {
        binding.name.text = place.name
        binding.vicinity.text = place.vicinity
        binding.textViewDollar.text = StringUtil.dollarBuilder(place.priceLevel)

        binding.root.setOnClickListener { showOnMap(place, binding.root.context) }
        binding.executePendingBindings()
    }

    private fun showOnMap(place: Place, context: Context) {

        val intent = Intent(context, PlacesOnMapActivity::class.java)
        intent.putExtra(Constant.EXTRA_NAME, place.name)
        intent.putExtra(Constant.EXTRA_ADDRESS, place.vicinity)
        intent.putExtra(Constant.EXTRA_LAT, place.geometry!!.location!!.lat)
        intent.putExtra(Constant.EXTRA_LNG, place.geometry!!.location!!.lng)
        intent.putExtra(Constant.EXTRA_PRICE_LEVEL, place.priceLevel)

        context.startActivity(intent)
    }

    companion object {

        fun create(layoutInflater: LayoutInflater, parent: ViewGroup): PlacesViewHolder {
            val binding = DataBindingUtil.inflate<PlaceItemBinding>(layoutInflater, R.layout.place_item, parent, false)

            return PlacesViewHolder(binding)
        }
    }

}

