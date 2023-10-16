package com.example.mastermind.jeu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.mastermind.R;

public class GrandeCase extends View {
    Paint pinceau;
    Paint pinceau2;
    public GrandeCase(Context context, AttributeSet attrs){
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
        canvas.drawCircle(this.getWidth()/2,this.getHeight()/2,this.getWidth()/3,this.pinceau2);

    }

}