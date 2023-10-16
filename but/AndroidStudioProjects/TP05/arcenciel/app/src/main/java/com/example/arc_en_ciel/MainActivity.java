package com.example.arc_en_ciel;

import android.os.Bundle;

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
        ArcEnCiel p = new ArcEnCiel();
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