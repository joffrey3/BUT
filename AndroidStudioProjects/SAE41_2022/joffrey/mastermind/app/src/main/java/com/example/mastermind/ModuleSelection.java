package com.example.mastermind;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class ModuleSelection extends View{
    Resources res;
    Tableau tableau;
    ModuleIndice indice;
    Bitmap back;
    Bitmap ok;
    int inc;
    int[] tab;
    Paint pinceau0;
    Paint pinceau1;
    Paint pinceau2;
    Paint pinceau3;
    Paint pinceau4;
    Paint pinceau5;
    Paint pinceau6;
    Paint pinceau7;
    Paint pinceau8;
    public ModuleSelection(Context context, AttributeSet attrs){
        super(context, attrs);
        this.tab = new int[4];
        this.tab[0]=-1;
        this.tab[1]=-1;
        this.tab[2]=-1;
        this.tab[3]=-1;
        this.pinceau0=new Paint();
        this.pinceau1=new Paint();
        this.pinceau2=new Paint();
        this.pinceau3=new Paint();
        this.pinceau4=new Paint();
        this.pinceau5=new Paint();
        this.pinceau6=new Paint();
        this.pinceau7=new Paint();
        this.pinceau8=new Paint();
        this.pinceau0.setColor(0xFFFFFFFF);
        this.pinceau1.setColor(0xFFFF0000);
        this.pinceau2.setColor(0xFF00FF00);
        this.pinceau3.setColor(0xFF0000FF);
        this.pinceau4.setColor(0xFFFFFF00);
        this.pinceau5.setColor(0xFF000000);
        this.pinceau6.setColor(0xFF5B3C11);
        this.pinceau7.setColor(0xFFCFCFCF);
        this.pinceau8.setColor(0xFF7F7F7F);
    }
    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        for(int i=0;i<6;i++) {
            if(i==0){
                canvas.drawRect(i*this.getWidth() / 6, 0, (i+1)*this.getWidth() / 6, this.getHeight() / 2, this.pinceau0);
                //canvas.drawBitmap(this.back,i*this.getWidth() / 6, 0,this.pinceau0);
            }else if(i==5){
                canvas.drawRect(i* this.getWidth() / 6, 0, (i+1) * this.getWidth() / 6, this.getHeight() / 2, this.pinceau0);
                //canvas.drawBitmap(this.ok,i*this.getWidth() / 6, 0,this.pinceau0);
            }else{
                canvas.drawRect(i * this.getWidth() / 6, 0, (i+1)* this.getWidth() / 6, this.getHeight() / 2, this.pinceau6);
                canvas.drawRect(i* this.getWidth() / 6 + 10, 10, (i+1) * this.getWidth() / 6 - 10, this.getHeight() / 2 - 10, this.pinceau7);
                if(this.tab[i-1]==-1) {
                    canvas.drawCircle(i * this.getWidth() / 6 + this.getWidth() / 12, this.getHeight() / 4, this.getWidth() / 18, this.pinceau8);
                }else{
                    canvas.drawCircle(i * this.getWidth() / 6 + this.getWidth() / 12, this.getHeight() / 4, this.getWidth() / 18, this.getPinceau(tab[i-1]));
                }
            }
        }
        for(int i=0;i<6;i++) {
            canvas.drawRect(i*this.getWidth()/6, this.getHeight()/2, (i+1)*this.getWidth()/6, this.getHeight(), this.pinceau6);
            canvas.drawRect(i*this.getWidth()/6+10, this.getHeight()/2+10,(i+1)*(this.getWidth()-10)/6,this.getHeight()-10, this.pinceau7);
            canvas.drawCircle(i*this.getWidth()/6+this.getWidth()/12, 3*this.getHeight()/4, this.getWidth()/18, this.getPinceau(i));
        }
    }
    public void colorier(int n){
        this.invalidate();
        if(inc<4) {
            this.tab[this.inc] = n;
            this.inc++;
        }
        return;
    }
    public void retirer(){
        this.invalidate();
        if(this.inc!=0){
            this.inc--;
            this.tab[this.inc] = -1;
        }
    }
    public void accepter(){
        this.invalidate();
        if(this.inc==4) {
            this.inc=0;
            this.tableau.ajouter(this.tab[0],this.tab[1],this.tab[2],this.tab[3]);
            this.tableau.verifier();
            for (int j = 0; j < 4; j++) {
                this.tab[j]=-1;
            }
        }
    }
    public Paint getPinceau(int n) {
            switch(n){
                case 0: return pinceau0;
                case 1: return pinceau1;
                case 2: return pinceau2;
                case 3: return pinceau3;
                case 4: return pinceau4;
                case 5: return pinceau5;
            }
            return null;
    }
    public void setRes(Resources r){
        this.res=r;
        this.back= BitmapFactory.decodeResource(res,R.drawable.back);
        this.ok= BitmapFactory.decodeResource(res,R.drawable.ok);
    }
    public void setTab(Tableau t){
        this.tableau=t;
    }
    public void setIndice(ModuleIndice i){
        this.indice=i;
    }
    public ModuleIndice getIndice(){
        return this.indice;
    }
}