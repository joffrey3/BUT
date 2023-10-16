package com.example.pois;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Fenetre extends View {
    Paint pinceau;
    Paint pinceau2;
    int change;
    List<List<Number>> tab = new ArrayList<ArrayList<Number>>();
    public Fenetre(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.pinceau=new Paint();
        this.pinceau2=new Paint();
        this.pinceau.setColor(0xFF000000);
        this.pinceau2.setColor(0xFFFF00FF);
        this.change=-1;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRect(0,0,this.getWidth(),this.getHeight(),this.pinceau);
        if(this.change==0) {
            canvas.drawCircle(500,500, 500, this.pinceau2);
        }
    }
    public void changement(int n,int id,float X,float Y){
        if(n==0){
            List<Number> liste=new ArrayList<Number>()
            liste.add(id);
            liste.add(X);
            liste.add(Y);
            tab.add(liste);
        }
        this.change=n;
    }
}
