package com.example.mastermind.jeu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.mastermind.R;

public class PetiteCase extends View {
    Paint pinceau;
    Paint pinceau2;
    float circlePosX;
    float circlePosY;
    float rayon;
    public PetiteCase(Context context, AttributeSet attrs){
        super(context, attrs);
        this.pinceau=new Paint();
        this.pinceau2=new Paint();
        this.pinceau.setColor(getResources().getColor(R.color.couleur_table_jeu));
        this.pinceau2.setColor(getResources().getColor(R.color.couleur_case_vide));
    }

    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawRect(0,0,this.getWidth(),this.getHeight(),this.pinceau);
        canvas.drawCircle(this.getWidth()/4,this.getHeight()/4,this.getWidth()/6,this.pinceau2);
        canvas.drawCircle(this.getWidth()/4,3*this.getHeight()/4,this.getWidth()/6,this.pinceau2);
        canvas.drawCircle(3*this.getWidth()/4,this.getHeight()/4,this.getWidth()/6,this.pinceau2);
        canvas.drawCircle(3*this.getWidth()/4,3*this.getHeight()/4,this.getWidth()/6,this.pinceau2);

    }

}