package com.example.mastermind;

import android.view.MotionEvent;
import android.view.View;

public class Listener implements View.OnTouchListener {

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        //view.invalidate();
        int variable=motionEvent.getActionMasked();
        if(variable==motionEvent.ACTION_DOWN){
            if (view instanceof ModuleSelection){
                float x =motionEvent.getX(0);
                float y =motionEvent.getY(0);
                if(y>150.0 && y<300.0 && x>0.0 && x<900.0) {
                    Float f=new Float(x/150);
                    ((ModuleSelection) view).colorier(f.intValue());
                }
                if(y>0.0 && y<150.0 && x>0.0 && x<150.0) {
                    ((ModuleSelection) view).retirer();
                }
                if(y>0.0 && y<150.0 && x>750.0 && x<900.0) {
                    ((ModuleSelection) view).getIndice().invalidate();
                    ((ModuleSelection) view).accepter();
                }
            }
        }
        return true;
    }
}
