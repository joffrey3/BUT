package com.example.decoration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Pacman p1=findViewById(R.id.pacman1);
        p1.setRes(this.getResources());
        Pacman p2=findViewById(R.id.pacman2);
        p2.setRes(this.getResources());
        Pacman p3=findViewById(R.id.pacman3);
        p3.setRes(this.getResources());
        Pacman p4=findViewById(R.id.pacman4);
        p4.setRes(this.getResources());
    }
}