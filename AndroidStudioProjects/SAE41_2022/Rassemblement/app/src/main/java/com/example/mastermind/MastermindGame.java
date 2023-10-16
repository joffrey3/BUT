package com.example.mastermind;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import android.content.res.Resources;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.example.mastermind.jeu.Listener;
import com.example.mastermind.jeu.ModuleIndice;
import com.example.mastermind.jeu.ModuleSelection;
import com.example.mastermind.jeu.Tableau;

public class MastermindGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.mastermind_game);

        //Button menuBtn = (Button) findViewById(R.id.open_menu_button);

        //Joffrey
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

        //Simon
        /*menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                //finish();
            }
        });*/
    }
    @Override
    public void onBackPressed(){
        startActivity(new Intent(getApplicationContext(),MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
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