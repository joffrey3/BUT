package com.example.fleche;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView image = this.findViewById(R.id.image);
        Button boutonG = this.findViewById(R.id.flecheGauche);
        Button boutonD = this.findViewById(R.id.flecheDroite);
        Fleche f= new Fleche(image,boutonG,boutonD,this.getResources());
        boutonG.setOnClickListener(f);
        boutonD.setOnClickListener(f);
    }
}