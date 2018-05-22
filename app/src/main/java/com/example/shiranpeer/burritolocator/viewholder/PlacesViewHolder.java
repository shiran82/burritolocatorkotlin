package com.example.shiranpeer.burritolocator.viewholder;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.shiranpeer.burritolocator.Constant;
import com.example.shiranpeer.burritolocator.R;
import com.example.shiranpeer.burritolocator.databinding.PlaceItemBinding;
import com.example.shiranpeer.burritolocator.model.Place;
import com.example.shiranpeer.burritolocator.screen.PlacesOnMapActivity;
import com.example.shiranpeer.burritolocator.util.StringUtil;

public class PlacesViewHolder extends RecyclerView.ViewHolder {

    private PlaceItemBinding binding;

    public PlacesViewHolder(PlaceItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Place place) {
        binding.name.setText(place.getName());
        binding.vicinity.setText(place.getVicinity());
        binding.textViewDollar.setText(StringUtil.dollarBuilder(place.getPriceLevel()));

        binding.getRoot().setOnClickListener(view -> showOnMap(place, binding.getRoot().getContext()));
        binding.executePendingBindings();
    }

    public static PlacesViewHolder create(LayoutInflater layoutInflater, ViewGroup parent) {
        PlaceItemBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.place_item, parent, false);

        return new PlacesViewHolder(binding);
    }

    private void showOnMap(Place place, Context context){

        Intent intent = new Intent(context, PlacesOnMapActivity.class);
        intent.putExtra(Constant.EXTRA_NAME, place.getName());
        intent.putExtra(Constant.EXTRA_ADDRESS, place.getVicinity());
        intent.putExtra(Constant.EXTRA_LAT, place.getGeometry().getLocation().getLat());
        intent.putExtra(Constant.EXTRA_LNG, place.getGeometry().getLocation().getLng());

        context.startActivity(intent);
    }

}

