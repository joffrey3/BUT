package com.example.mastermind.jeu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.mastermind.R;

public class ModuleIndice extends View {
    Tableau tableau;
    Paint pinceau0;
    Paint pinceau1;
    Paint pinceau2;
    Paint pinceau3;
    Paint pinceau4;
    Paint pinceau5;
    Paint pinceau6;
    Paint pinceau7;
    public ModuleIndice(Context context, AttributeSet attrs){
        super(context, attrs);
        this.pinceau0=new Paint();
        this.pinceau1=new Paint();
        this.pinceau2=new Paint();
        this.pinceau3=new Paint();
        this.pinceau4=new Paint();
        this.pinceau5=new Paint();
        this.pinceau6=new Paint();
        this.pinceau7=new Paint();
        this.pinceau0.setColor(getResources().getColor(R.color.white));
        this.pinceau1.setColor(getResources().getColor(R.color.red));
        this.pinceau2.setColor(getResources().getColor(R.color.green));
        this.pinceau3.setColor(getResources().getColor(R.color.blue));
        this.pinceau4.setColor(getResources().getColor(R.color.yellow));
        this.pinceau5.setColor(getResources().getColor(R.color.black));
        this.pinceau6.setColor(getResources().getColor(R.color.couleur_table_jeu));
        this.pinceau7.setColor(getResources().getColor(R.color.couleur_case_vide));
    }

    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        int[][] tab_jeu=this.tableau.getTab_jeu();
        int[][] tab_verifN=this.tableau.getTab_verifN();
        int[][] tab_verifB=this.tableau.getTab_verifB();
        for(int i=0;i<10;i++) {
            for(int j=0;j<6;j++) {
                canvas.drawRect(j * getWidth() / 6, i*getHeight()/10, (j+1)*getWidth()/6,(i+1)*getHeight()/10, this.pinceau6);
                if(j==0){
                    if (tab_verifB[9 - i][0] != -1) {
                        canvas.drawCircle(getWidth() / 24, i * getHeight() / 10 + getHeight() / 40, getWidth() / 36, this.getPinceau(0));
                    }else {
                        canvas.drawCircle(getWidth() / 24, i * getHeight() / 10 + getHeight() / 40, getWidth() / 36, this.pinceau7);
                    }
                    if (tab_verifB[9 - i][1] != -1) {
                        canvas.drawCircle(3 * getWidth() / 24, i * getHeight() / 10 + getHeight() / 40, getWidth() / 36, this.getPinceau(0));
                    }else {
                        canvas.drawCircle(3 * getWidth() / 24, i * getHeight() / 10 + getHeight() / 40, getWidth() / 36, this.pinceau7);
                    }
                    if (tab_verifB[9 - i][2] != -1) {
                        canvas.drawCircle(getWidth() / 24, i * getHeight() / 10 + 3 * getHeight() / 40, getWidth() / 36, this.getPinceau(0));
                    }else {
                        canvas.drawCircle(getWidth() / 24, i * getHeight() / 10 + 3 * getHeight() / 40, getWidth() / 36, this.pinceau7);
                    }
                    if (tab_verifB[9 - i][3] != -1) {
                        canvas.drawCircle(3 * getWidth() / 24, i * getHeight() / 10 + 3 * getHeight() / 40, getWidth() / 36, this.getPinceau(0));
                    }else {
                        canvas.drawCircle(3 * getWidth() / 24, i * getHeight() / 10 + 3 * getHeight() / 40, getWidth() / 36, this.pinceau7);
                    }
                }else if(j==5){
                    if (tab_verifN[9 - i][0] != -1) {
                        canvas.drawCircle(j * getWidth() / 6 + getWidth() / 24, i * getHeight() / 10 + getHeight() / 40, getWidth() / 36, this.getPinceau(5));
                    }else {
                        canvas.drawCircle(j * getWidth() / 6 + getWidth() / 24, i * getHeight() / 10 + getHeight() / 40, getWidth() / 36, this.pinceau7);
                    }
                    if (tab_verifN[9 - i][1] != -1) {
                        canvas.drawCircle(j * getWidth() / 6 + 3 * getWidth() / 24, i * getHeight() / 10 + getHeight() / 40, getWidth() / 36, this.getPinceau(5));
                    }else {
                        canvas.drawCircle(j * getWidth() / 6 + 3 * getWidth() / 24, i * getHeight() / 10 + getHeight() / 40, getWidth() / 36, this.pinceau7);
                    }
                    if (tab_verifN[9 - i][2] != -1) {
                        canvas.drawCircle(j * getWidth() / 6 + getWidth() / 24, i * getHeight() / 10 + 3 * getHeight() / 40, getWidth() / 36, this.getPinceau(5));
                    }else {
                        canvas.drawCircle(j * getWidth() / 6 + getWidth() / 24, i * getHeight() / 10 + 3 * getHeight() / 40, getWidth() / 36, this.pinceau7);
                    }
                    if (tab_verifN[9 - i][3] != -1) {
                        canvas.drawCircle(j * getWidth() / 6 + 3 * getWidth() / 24, i * getHeight() / 10 + 3 * getHeight() / 40, getWidth() / 36, this.getPinceau(5));
                    }else {
                        canvas.drawCircle(j * getWidth() / 6 + 3 * getWidth() / 24, i * getHeight() / 10 + 3 * getHeight() / 40, getWidth() / 36, this.pinceau7);
                    }
                }
                else{
                    if(tab_jeu[9-i][j-1]==-1) {
                        canvas.drawCircle(j * getWidth() / 6 + getWidth() / 12, i * getHeight() / 10 + getHeight() / 20, getWidth() / 18, this.pinceau7);
                    }else{
                       canvas.drawCircle(j * getWidth() / 6 + getWidth() / 12, i * getHeight() / 10 + getHeight() / 20, getWidth() / 18, this.getPinceau(tab_jeu[9-i][j-1]));
                    }
                }
            }
        }
    }
    public void setTab(Tableau t){
        this.tableau=t;
        int[][] tab_jeu=this.tableau.getTab_jeu();
        /*for(int i=0;i<10;i++){
            for(int j=0;j<4;j++){
                System.out.println(Integer.toString(tab_jeu[i - 9][j]));
            }
        }*/
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
}
