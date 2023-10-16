package com.example.desoxyribonucleique;

import static android.view.MotionEvent.ACTION_DOWN;
import static android.view.MotionEvent.ACTION_MOVE;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Listener implements View.OnClickListener {
    Button A,T,C,G;
    EditText champ;
    public Listener(Button bouton1, Button bouton2, Button bouton3, Button bouton4, EditText barre){
        this.A=bouton1;
        this.T=bouton2;
        this.C=bouton3;
        this.G=bouton4;
        this.champ=barre;
    }
    @Override
    public void onClick(View view) {
        if(view instanceof Button){
            if(view==this.A){
                this.champ.setText(this.champ.getText()+"A");
            }
            if(view==this.T){
                this.champ.setText(this.champ.getText()+"T");
            }
            if(view==this.C){
                this.champ.setText(this.champ.getText()+"C");
            }
            if(view==this.G){
                this.champ.setText(this.champ.getText()+"G");
            }
        }
    }

}
