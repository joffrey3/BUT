package com.example.reticule;

import static android.view.MotionEvent.ACTION_DOWN;
import static android.view.MotionEvent.ACTION_MOVE;
import static android.view.MotionEvent.ACTION_POINTER_DOWN;
import static android.view.MotionEvent.ACTION_POINTER_UP;
import static android.view.MotionEvent.ACTION_UP;

import android.view.MotionEvent;
import android.view.View;

public class Pois implements View.OnTouchListener {
    float X;
    float Y;
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int var =motionEvent.getActionMasked();
        int compteur=motionEvent.getPointerCount();
        for(int increment=0;increment<compteur;increment++){
            int id= motionEvent.getPointerId(increment);
            if (var == ACTION_DOWN) {
                if (view instanceof Fenetre) {
                    if (view instanceof Fenetre) {
                        this.X=motionEvent.getX();
                        this.Y=motionEvent.getY();
                        ((Fenetre) view).position(id);
                    }
                }
            }
            if (var == ACTION_MOVE) {
                view.invalidate();
                if (view instanceof Fenetre) {
                    ((Fenetre) view).changement(id,new Float(motionEvent.getX(increment)-this.X),new Float(motionEvent.getY(increment)-this.Y));
                }
            }
        }
        return true;
    }
}
