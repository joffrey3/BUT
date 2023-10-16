package com.example.mastermind;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class BacDeCouleur extends View {
    Paint pinceau;
    Paint pinceau2;
    Paint pinceau3;
    public BacDeCouleur(Context context, AttributeSet attrs){
        super(context, attrs);
        this.pinceau=new Paint();
        this.pinceau2=new Paint();
        this.pinceau3=new Paint();
        this.pinceau.setColor(0xFF5B3C11);
        this.pinceau2.setColor(0xFFCFCFCF);
        this.pinceau3.setColor(0xFFFFFFFF);
    }

    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawRect(0,0,this.getWidth()/6,this.getHeight()/2,this.pinceau);
        canvas.drawRect(10,10,(this.getWidth()-10)/6,(this.getHeight()-10)/2,this.pinceau2);
        canvas.drawCircle(this.getWidth()/18,this.getHeight()/18,this.getWidth()/18,this.pinceau3);

    }

}