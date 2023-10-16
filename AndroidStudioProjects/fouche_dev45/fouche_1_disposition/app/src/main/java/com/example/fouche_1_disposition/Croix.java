package com.example.fouche_1_disposition;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
//Exercice 2
public class Croix extends View {
    Paint pinceau;
    Paint pinceau2;
    Path chemin;
    public Croix(Context context, AttributeSet attrs){
        super(context,attrs);
        this.chemin = new Path();
        this.pinceau= new Paint();
        this.pinceau.setColor(0xFF0000FF);
        this.pinceau2= new Paint();
        this.pinceau2.setColor(0xFFFFFF00);
        float trait =20F/*findViewById(R.dimen.tailledutrait)*/;
        this.pinceau2.setStrokeWidth(trait);
    }
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        canvas.drawRect(0,0,this.getWidth(),this.getHeight(),this.pinceau);
        canvas.drawLine(this.getWidth()/2-100,this.getHeight()/2-100,this.getWidth()/2+100,this.getHeight()/2+100,this.pinceau2);
        canvas.drawLine(this.getWidth()/2-100,this.getHeight()/2+100,this.getWidth()/2+100,this.getHeight()/2-100,this.pinceau2);
    }
}
