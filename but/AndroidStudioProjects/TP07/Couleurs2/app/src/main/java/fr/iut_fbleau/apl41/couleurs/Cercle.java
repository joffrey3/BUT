package fr.iut_fbleau.apl41.couleurs;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class Cercle extends View {
    Paint pinceau;
    int couleur;
    public Cercle(Context context, AttributeSet attrs){
        super(context,attrs);
        this.pinceau= new Paint();
        this.couleur=0xFF000000;
        this.pinceau.setColor(this.couleur);
    }
    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawCircle(21,21,21,this.pinceau);
    }

    public void setColor(int color){
        this.couleur=color;
        this.pinceau.setColor(this.couleur);
    }
}
