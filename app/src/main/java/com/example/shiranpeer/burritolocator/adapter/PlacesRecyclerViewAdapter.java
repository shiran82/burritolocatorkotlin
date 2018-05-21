package com.example.shiranpeer.burritolocator.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.shiranpeer.burritolocator.model.Place;
import com.example.shiranpeer.burritolocator.R;
import com.example.shiranpeer.burritolocator.screen.PlacesOnMapActivity;

import java.util.List;

public class PlacesRecyclerViewAdapter extends
        RecyclerView.Adapter<PlacesRecyclerViewAdapter.ViewHolder> {

    private List<Place> placesList;
    private Context context;


    public PlacesRecyclerViewAdapter(List<Place> list, Context ctx) {
        placesList = list;
        context = ctx;
    }
    @Override
    public int getItemCount() {
        return placesList.size();
    }

    @Override
    public PlacesRecyclerViewAdapter.ViewHolder
    onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.places_item, parent, false);

        PlacesRecyclerViewAdapter.ViewHolder viewHolder =
                new PlacesRecyclerViewAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PlacesRecyclerViewAdapter.ViewHolder holder, int position) {
        String dollars = "";
        final Place place = placesList.get(position);
        holder.name.setText(place.getName());
        holder.address.setText(place.getVicinity());

        for (int i = 0; i < placesList.get(position).getPriceLevel(); i++) {
            dollars += "$";
        }

        holder.dollars.setText(dollars);


        holder.root.setOnClickListener(view -> showOnMap(place));

    }

    public void addItems(List<Place> places) {
        placesList.addAll(places);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView address;
        public TextView dollars;

        public LinearLayout root;

        public ViewHolder(View view) {

            super(view);

            name = view.findViewById(R.id.name);
            address = view.findViewById(R.id.vicinity);
            dollars = view.findViewById(R.id.text_view_dollar);

            root = view.findViewById(R.id.linear_layout_root);
        }
    }

    private void showOnMap(Place place){

        Intent intent = new Intent(context, PlacesOnMapActivity.class);
        intent.putExtra("name", place.getName());
        intent.putExtra("address", place.getVicinity());
        intent.putExtra("lat", place.getGeometry().getLocation().getLat());
        intent.putExtra("lng", place.getGeometry().getLocation().getLng());

        context.startActivity(intent);
    }
}