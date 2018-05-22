package com.example.shiranpeer.burritolocator.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.shiranpeer.burritolocator.model.Place;
import com.example.shiranpeer.burritolocator.viewholder.PlacesViewHolder;

import java.util.List;

public class PlacesRecyclerViewAdapter extends RecyclerView.Adapter<PlacesViewHolder> {

    private List<Place> placesList;

    public PlacesRecyclerViewAdapter(List<Place> list) {
        placesList = list;
    }

    @Override
    public int getItemCount() {
        return placesList.size();
    }

    @Override
    public PlacesViewHolder
    onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =
                LayoutInflater.from(parent.getContext());

        return PlacesViewHolder.create(layoutInflater, parent);
    }

    @Override
    public void onBindViewHolder(PlacesViewHolder holder, int position) {
        final Place place = placesList.get(position);

        holder.bind(place);
    }

    public void addItems(List<Place> places) {
        placesList.addAll(places);
        notifyDataSetChanged();
    }
}