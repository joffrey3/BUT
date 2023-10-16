package com.example.fleche;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class Fleche implements View.OnClickListener {
    Bitmap imageD;
    Bitmap imageG;
    Button boutonD;
    Button boutonG;
    ImageView image;
    Resources res;

    public Fleche(ImageView img, Button btnG, Button btnD,Resources r) {
        this.image=img;
        this.boutonD=btnD;
        this.boutonG=btnG;
        this.res=r;
        this.imageD= BitmapFactory.decodeResource(this.res,R.drawable.fleche_droite);
        this.imageG= BitmapFactory.decodeResource(this.res,R.drawable.fleche_gauche);
    }

    @Override
    public void onClick(View view) {
        if(view==this.boutonD){
            this.image.setImageBitmap(this.imageD);
        }
        if(view==this.boutonG){
            this.image.setImageBitmap(this.imageG);
        }
    }
}
