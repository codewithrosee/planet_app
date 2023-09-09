package com.practice.planetinfo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PlanetInformationAdapter extends RecyclerView.Adapter<PlanetInformationAdapter.PlanetInformtaionViewHolder> {

    ArrayList<PlanetInformation> items = new ArrayList<>();

    public PlanetInformationAdapter(ArrayList<PlanetInformation> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public PlanetInformtaionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_planet_information, parent, false);
        return new PlanetInformtaionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetInformtaionViewHolder holder, int position) {
        holder.bindView(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class PlanetInformtaionViewHolder extends RecyclerView.ViewHolder {

        ImageView ivPlanet;
        TextView tvPosition, tvPlanetName;

        public PlanetInformtaionViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPlanet = itemView.findViewById(R.id.ivPlanet);
            tvPosition = itemView.findViewById(R.id.position);
            tvPlanetName = itemView.findViewById(R.id.title);
        }

        void bindView(PlanetInformation planetInformation) {
            ivPlanet.setImageResource(planetInformation.image);
            tvPlanetName.setText(planetInformation.name);
            tvPosition.setText("" + planetInformation.position);

        }
    }
}
