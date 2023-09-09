package com.practice.planetinfo;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.concurrent.TimeUnit;

public class SolarSystemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solar_system);

        ImageView sun = findViewById(R.id.sun);
        ImageView mercury = findViewById(R.id.mercury);
        ImageView venus = findViewById(R.id.venus);
        ImageView earth = findViewById(R.id.earth);
        ImageView moon = findViewById(R.id.moon);
        ImageView mars = findViewById(R.id.mars);
        ImageView jupiter = findViewById(R.id.jupiter);
        ImageView saturn = findViewById(R.id.saturn);
        ImageView uranus = findViewById(R.id.uranus);
        ImageView neptune = findViewById(R.id.neptune);


        sun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlanetInformationDialog planetInformationDialog = new PlanetInformationDialog(SolarSystemActivity.this);
                planetInformationDialog.show();
            }
        });

        startRotation(mercury, TimeUnit.SECONDS.toMillis(2)).start();
        startRotation(venus, TimeUnit.SECONDS.toMillis(3)).start();
        startRotation(earth, TimeUnit.SECONDS.toMillis(4)).start();
        startRotation(moon, TimeUnit.SECONDS.toMillis(2)).start();
        startRotation(mars, TimeUnit.SECONDS.toMillis(5)).start();
        startRotation(jupiter, TimeUnit.SECONDS.toMillis(7)).start();
        startRotation(saturn, TimeUnit.SECONDS.toMillis(8)).start();
        startRotation(uranus, TimeUnit.SECONDS.toMillis(10)).start();
        startRotation(neptune, TimeUnit.SECONDS.toMillis(12)).start();
    }

    public ValueAnimator startRotation(ImageView item, long duration) {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 360);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                int value = (Integer) valueAnimator.getAnimatedValue();
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) item.getLayoutParams();
                layoutParams.circleAngle = value;
                item.setLayoutParams(layoutParams);
            }
        });

        valueAnimator.setDuration(duration);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setRepeatMode(ValueAnimator.RESTART);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        return valueAnimator;

    }
}