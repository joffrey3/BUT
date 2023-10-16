package com.example.mastermind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ModuleSelection selection = findViewById(R.id.moduleselection);
        ModuleIndice indice= findViewById(R.id.moduleindice);
        Resources res =this.getResources();
        Tableau tab =new Tableau();
        selection.setRes(res);
        selection.setTab(tab);
        indice.setTab(tab);
        selection.setIndice(indice);
        Listener observateur= new Listener();
        selection.setOnTouchListener(observateur);

    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onRestart() {
        super.onRestart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}