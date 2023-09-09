package com.practice.planetinfo;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class PlanetInformationDialog extends BottomSheetDialog {

    public PlanetInformationDialog(@NonNull Context context) {
        super(context);
        View view = View.inflate(getContext(), R.layout.dialog_planet_information, null);
        setContentView(view);

        ArrayList<PlanetInformation> planetInformations = new ArrayList<>();
        planetInformations.add(new PlanetInformation("Mercury", 1, R.drawable.ic_mercury));
        planetInformations.add(new PlanetInformation("Venus", 2, R.drawable.ic_venus));
        planetInformations.add(new PlanetInformation("Earth", 3, R.drawable.ic_earth));
        planetInformations.add(new PlanetInformation("Mars", 4, R.drawable.ic_mars));
        planetInformations.add(new PlanetInformation("Jupiter", 5, R.drawable.ic_jupiter));
        planetInformations.add(new PlanetInformation("Saturn", 6, R.drawable.ic_saturn));
        planetInformations.add(new PlanetInformation("Uranus", 7, R.drawable.ic_uranus));
        planetInformations.add(new PlanetInformation("Neptune", 8, R.drawable.ic_neptune));

        RecyclerView rvPlanets = view.findViewById(R.id.rvPlanetInfo);
        PlanetInformationAdapter planetInformationAdapter = new PlanetInformationAdapter(planetInformations);
        rvPlanets.setAdapter(planetInformationAdapter);

    }
}
