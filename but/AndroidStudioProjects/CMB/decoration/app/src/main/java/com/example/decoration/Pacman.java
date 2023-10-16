package com.example.decoration;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class Pacman extends View {
    Path chemin;
    Resources res;
    Paint pinceau;
    Paint pinceau2;
    float rayon;
    public Pacman(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.pinceau=new Paint();
        this.pinceau2=new Paint();
        this.pinceau.setColor(0xFFFFFF00);
        this.pinceau.setStyle(Paint.Style.STROKE);
        this.pinceau.setStrokeWidth(10F);
        this.chemin=new Path();
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawRect(0,0,this.getWidth(),this.getHeight(),this.pinceau2);
        canvas.drawCircle(this.getWidth(),this.getHeight(),this.rayon);
        this.chemin.moveTo(this.getWidth(),this.getHeight());
        this.chemin.lineTo(this.getWidth()+this.rayon,this.getHeight()+this.rayon);
        this.chemin.lineTo(this.getWidth()+this.rayon,this.getHeight()-this.rayon);
        this.chemin.lineTo(this.getWidth(),this.getHeight());

        canvas.drawPath(this.chemin,this.pinceau);
    }
    public void setRes(Resources r){
        this.res=r;
        this.rayon=findViewById(R.id.rayon);
    }
}
