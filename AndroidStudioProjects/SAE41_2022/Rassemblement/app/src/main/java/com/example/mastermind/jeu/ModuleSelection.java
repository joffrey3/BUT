package com.example.mastermind.jeu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.mastermind.R;

public class ModuleSelection extends View{
    private Tableau tableau;
    private ModuleIndice indice;
    private Bitmap ok;
    private int inc;
    private final int[] tab;
    private final int buttonMargin;
    private final Paint peintureBlanc;
    private final Paint peintureRouge;
    private final Paint peintureVert;
    private final Paint peintureBleu;
    private final Paint peintureJaune;
    private final Paint peintureNoir;
    private final Paint peinturePlateau;
    private final Paint peintureBoutonPlateau;
    private final Paint peintureJetonVide;

    public ModuleSelection(Context context, AttributeSet attrs){
        super(context, attrs);
        this.buttonMargin=25;
        this.tab = new int[4];
        this.tab[0]=-1;
        this.tab[1]=-1;
        this.tab[2]=-1;
        this.tab[3]=-1;
        this.peintureBlanc=new Paint();
        this.peintureRouge=new Paint();
        this.peintureVert=new Paint();
        this.peintureBleu=new Paint();
        this.peintureJaune=new Paint();
        this.peintureNoir=new Paint();
        this.peinturePlateau=new Paint();
        this.peintureBoutonPlateau=new Paint();
        this.peintureJetonVide=new Paint();
        this.peintureBlanc.setColor(getResources().getColor(R.color.white));
        this.peintureRouge.setColor(getResources().getColor(R.color.red));
        this.peintureVert.setColor(getResources().getColor(R.color.green));
        this.peintureBleu.setColor(getResources().getColor(R.color.blue));
        this.peintureJaune.setColor(getResources().getColor(R.color.yellow));
        this.peintureNoir.setColor(getResources().getColor(R.color.black));
        this.peinturePlateau.setColor(getResources().getColor(R.color.couleur_table_jeu));
        this.peintureBoutonPlateau.setColor(getResources().getColor(R.color.couleur_bouton_table));
        this.peintureBoutonPlateau.setStyle(Paint.Style.FILL_AND_STROKE);
        this.peintureBoutonPlateau.setStrokeWidth(25);
        this.peintureBoutonPlateau.setPathEffect(new CornerPathEffect(25));
        this.peintureJetonVide.setColor(getResources().getColor(R.color.couleur_case_vide));
    }
    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        float canvasWidth = getWidth();
        float canvasHeight = getHeight();
        for(int i=0;i<6;i++) {
            if(i==0){
                canvas.drawRect(i * canvasHeight / 6, 0, (i+1) * canvasWidth / 6, canvasHeight / 2, this.peintureBlanc);
                //canvas.drawBitmap(this.back,i*canvasWidth / 6, 0,this.peintureBlanc);
            }else if(i==5){
                canvas.drawRect(i* canvasWidth / 6, 0, (i+1) * canvasWidth / 6, canvasHeight / 2, this.peintureBlanc);
                //canvas.drawBitmap(this.ok,i*canvasWidth / 6, 0,this.peintureBlanc);
            }else{
                canvas.drawRect(i * canvasWidth / 6, 0, (i+1)* canvasWidth / 6, canvasHeight / 2, this.peinturePlateau);
                canvas.drawRect(i* canvasWidth / 6 + this.buttonMargin, this.buttonMargin, (i+1) * canvasWidth / 6 - this.buttonMargin, canvasHeight / 2 - this.buttonMargin, this.peintureBoutonPlateau);
                if(this.tab[i-1]==-1) {
                    canvas.drawCircle(i * canvasWidth / 6 + canvasWidth / 12, canvasHeight / 4, canvasWidth / 18, this.peintureJetonVide);
                }else{
                    canvas.drawCircle(i * canvasWidth / 6 + canvasWidth / 12, canvasHeight / 4, canvasWidth / 18, this.getPinceau(tab[i-1]));
                }
            }
        }
        for(int i=0;i<6;i++) {
            canvas.drawRect(i*canvasWidth/6, canvasHeight/2, (i+1)*canvasWidth/6, canvasHeight, this.peinturePlateau);
            canvas.drawRect(i*canvasWidth/6+this.buttonMargin, canvasHeight/2+this.buttonMargin,(i+1)*(canvasWidth)/6-this.buttonMargin,canvasHeight-this.buttonMargin, this.peintureBoutonPlateau);
            canvas.drawCircle(i*canvasWidth/6+canvasWidth/12, 3*canvasHeight/4, canvasWidth/18, this.getPinceau(i));
        }
    }
    public void colorier(int n){
        this.invalidate();
        if(inc<4) {
            this.tab[this.inc] = n;
            this.inc++;
        }
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
                case 0: return peintureBlanc;
                case 1: return peintureRouge;
                case 2: return peintureVert;
                case 3: return peintureBleu;
                case 4: return peintureJaune;
                case 5: return peintureNoir;
            }
            return null;
    }
    public void setRes(Resources r){
        Bitmap back = BitmapFactory.decodeResource(r, com.example.mastermind.R.drawable.back);
        this.ok= BitmapFactory.decodeResource(r, com.example.mastermind.R.drawable.ok);
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