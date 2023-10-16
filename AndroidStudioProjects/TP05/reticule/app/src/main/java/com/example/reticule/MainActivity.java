package com.example.reticule;

import android.os.Bundle;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Fenetre f;
    private static final String DEFAULTPOSITION  = "0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        f = findViewById(R.id.fenetre);
        Pois p = new Pois();
        f.setOnTouchListener(p);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("positionReticuleX",Integer.toString(this.f.getPosX()));
        outState.putString("positionReticuleX",Integer.toString(this.f.getPosY()));
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        f.setPosX(Integer.parseInt(savedInstanceState.getString("positionReticuleX",DEFAULTPOSITION)));
        f.setPosY(Integer.parseInt(savedInstanceState.getString("positionReticuleY",DEFAULTPOSITION)));

    }
}