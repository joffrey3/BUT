package com.example.arc_en_ciel;

import static android.view.MotionEvent.ACTION_DOWN;
import static android.view.MotionEvent.ACTION_MOVE;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;

public class ArcEnCiel implements View.OnTouchListener {

    Color[] baseCouleur = {Color.RED,Color.ORANGE,Color.YELLOW,Color.GREEN,Color.BLUE,Color.INDIGO,Color.PURPLE};
    Color couleur;

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int var =motionEvent.getActionMasked();
        int compteur=motionEvent.getPointerCount();
        for(int increment=0;increment<compteur;increment++){
            int id= motionEvent.getPointerId(increment);
            if (var == ACTION_DOWN) {
                if (view instanceof Fenetre) {
                    this.couleur=((Fenetre) view).getColor();
                    for (int i=0;i<baseCouleur.length;i++) {
                        ((Fenetre) view).setColor(this.couleur);
                    }
                }
            }
        }
        return true;
    }
}
