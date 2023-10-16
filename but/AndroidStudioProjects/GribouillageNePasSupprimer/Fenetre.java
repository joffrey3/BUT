package com.example.gribouillage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class Fenetre extends View {
    Resources res;
    Bitmap image;
    Paint pinceau;
    Paint pinceau2;
    Paint pinceau3;
    float leftRectangle;
    float topRectangle;
    float rightRectangle;
    float bottomRectangle;
    float posXCercle;
    float posYCercle;
    float rayonCercle;
    float posXText;
    float posYText;
    float posXImage;
    float posYImage;
    public Fenetre(Context context, AttributeSet attrs){
        super(context,attrs);
        this.res = this.getResources();
        this.image= BitmapFactory.decodeResource(res,R.drawable.cercles);
        this.pinceau= new Paint();
        this.pinceau2= new Paint();
        this.pinceau3= new Paint();
        this.pinceau.setColor(0xFF000000);
        this.pinceau2.setColor(0xFF0000FF);
        this.pinceau3.setColor(0xFFFF00FF);
        this.leftRectangle=this.res.getDimension(R.dimen.leftRectangle);
        this.topRectangle=this.res.getDimension(R.dimen.topRectangle);
        this.rightRectangle=this.res.getDimension(R.dimen.rightRectangle);
        this.bottomRectangle=this.res.getDimension(R.dimen.bottomRectangle);
        this.posXCercle=this.res.getDimension(R.dimen.posXCercle);
        this.posYCercle=this.res.getDimension(R.dimen.posYCercle);
        this.rayonCercle=this.res.getDimension(R.dimen.rayonCercle);
        this.posXText=this.res.getDimension(R.dimen.posXText);
        this.posYText=this.res.getDimension(R.dimen.posYText);
        this.posXImage=this.res.getDimension(R.dimen.posXImage);
        this.posYImage=this.res.getDimension(R.dimen.posYImage);
    }
    @Override
    public void onDraw (Canvas canvas){
        canvas.drawRect(this.leftRectangle,this.topRectangle,this.rightRectangle,this.bottomRectangle,this.pinceau3);
        canvas.drawCircle(this.posXCercle,this.posYCercle,this.rayonCercle,this.pinceau2);
        canvas.drawText("Ceci est un test", this.posXText,this.posYText,this.pinceau);
        canvas.drawBitmap(this.image,this.posXImage,this.posYImage,this.pinceau);
    }
}
