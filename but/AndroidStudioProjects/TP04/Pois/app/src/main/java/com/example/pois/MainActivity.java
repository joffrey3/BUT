package com.example.pois;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fenetre f = findViewById(R.id.fenetre);
        Pois p = new Pois();
        f.setOnTouchListener(p);
    }
}