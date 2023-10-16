package com.example.desoxyribonucleique;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button A,T,C,G;
    EditText champ;
    private static final String DEFAULTPOSITION  = "0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.A = findViewById(R.id.A);
        this.T = findViewById(R.id.T);
        this.C = findViewById(R.id.C);
        this.G = findViewById(R.id.G);
        this.champ=findViewById(R.id.champ);
        Listener p = new Listener(A,T,C,G,champ);
        A.setOnClickListener(p);
        T.setOnClickListener(p);
        C.setOnClickListener(p);
        G.setOnClickListener(p);
    }
}