package com.example.fouche_1_disposition;

import static android.view.MotionEvent.ACTION_DOWN;
import static android.view.MotionEvent.ACTION_MOVE;
import static android.view.MotionEvent.ACTION_UP;

import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class Listener implements View.OnTouchListener {
    TextView x;
    TextView y;
    public Listener(TextView textX, TextView textY){
        this.x=textX;
        this.y=textY;
    }
    @Override
    public boolean onTouch(MotionEvent motionEvent,View view){
        view.invalidate();
        int var =motionEvent.getActionMasked();
        int compteur=motionEvent.getPointerCount();
        for(int increment=0;increment<compteur;increment++){
            int id= motionEvent.getPointerId(increment);
            if(id==0) {
                if (var == ACTION_DOWN) {
                    this.x.setText(Float.toString(view.getX()));
                    this.y.setText(Float.toString(view.getY()));
                }
                if (var == ACTION_UP) {
                        this.x.setText("∅");
                        this.y.setText("∅");
                }
                if (var == ACTION_MOVE) {
                        this.x.setText(Float.toString(view.getX()));
                        this.y.setText(Float.toString(view.getY()));
                }
            }
        }
        return true;
    }
}
