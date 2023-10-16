package com.example.arc_en_ciel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class Fenetre extends View {
    private static final int DEFAULTPOSITION  = 0;
    Paint pinceau;
    Paint pinceau2;
    int change;
    int[] liste = {DEFAULTPOSITION,DEFAULTPOSITION};
    int posFixeX=0;
    int posFixeY=0;
    public Fenetre(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.pinceau=new Paint();
        this.pinceau2=new Paint();
        this.pinceau.setColor(0xFF000000);
        this.pinceau2.setColor(0xFFFFFF00);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRect(0,0,this.getWidth(),this.getHeight(),this.pinceau);
        canvas.drawCircle(this.liste[0],this.liste[1], 100, this.pinceau2);
        canvas.drawCircle(this.liste[0],this.liste[1], 90, this.pinceau);
        canvas.drawLine(this.liste[0]-150,this.liste[1],this.liste[0]+150,this.liste[1],this.pinceau2);
        canvas.drawLine(this.liste[0],this.liste[1]-150,this.liste[0],this.liste[1]+150,this.pinceau2);
    }
    public void changement(int id,Float X,Float Y){
        this.liste[0]=this.posFixeX+X.intValue();
        this.liste[1]=this.posFixeY+Y.intValue();
    }
    public void position(int id){
        this.posFixeX=this.liste[0];
        this.posFixeY=this.liste[1];
    }
    public void setColor(int value){
        this.pinceau.setColor(value);
    }
    public int getColor(){
        return this.pinceau.getColor();
    }
}
