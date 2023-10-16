package com.example.pois;

import static android.view.MotionEvent.ACTION_DOWN;
import static android.view.MotionEvent.ACTION_MOVE;
import static android.view.MotionEvent.ACTION_POINTER_DOWN;
import static android.view.MotionEvent.ACTION_POINTER_UP;
import static android.view.MotionEvent.ACTION_UP;

import android.view.MotionEvent;
import android.view.View;

public class Pois implements View.OnTouchListener {

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        view.invalidate();
        int var =motionEvent.getActionMasked();
        int compteur=motionEvent.getPointerCount();
        for(int increment=0;increment<compteur;increment++){
            int id= motionEvent.getPointerId(increment);
            if (var == ACTION_DOWN) {
                if (view instanceof Fenetre) {
                    ((Fenetre) view).changement(0, id,motionEvent.getX(increment),motionEvent.getY(increment));
                }
            }
            if (var == ACTION_UP) {
                if (view instanceof Fenetre) {
                    ((Fenetre) view).changement(1, id,motionEvent.getX(increment),motionEvent.getY(increment));
                }
            }
            if (var == ACTION_MOVE) {
                if (view instanceof Fenetre) {
                    ((Fenetre) view).changement(2, id,motionEvent.getX(increment),motionEvent.getY(increment));
                }
            }
            if (var == ACTION_POINTER_DOWN) {
                if (view instanceof Fenetre) {
                    ((Fenetre) view).changement(3, id,motionEvent.getX(increment),motionEvent.getY(increment));
                }
            }
            if (var == ACTION_POINTER_UP) {
                if (view instanceof Fenetre) {
                    ((Fenetre) view).changement(4, id,motionEvent.getX(increment),motionEvent.getY(increment));
                }
            }
        }
        return true;
    }
}
