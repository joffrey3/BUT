package com.example.mastermind;

import android.util.Log;

public class Tableau {
    int[][] tab_jeu;
    int[][] tab_verifB;
    int[][] tab_verifN;
    int[] combiSecrete;
    int ligne=0;
    public Tableau(){
        this.tab_jeu=new int[10][4];
        this.tab_verifB=new int[10][4];
        this.tab_verifN=new int[10][4];
        this.combiSecrete=new int[4];
        for(int i=0;i<10;i++){
            for(int j=0;j<4;j++){
                this.tab_jeu[i][j] = -1;
                this.tab_verifB[i][j] = -1;
                this.tab_verifN[i][j] = -1;
                if(i==0){
                    this.combiSecrete[j]=j;
                }
            }
        }
    }

    public void ajouter(int n1,int n2,int n3,int n4){
        if(this.ligne==10){
            return;
        }
        int[] combinaison={n1,n2,n3,n4};
        for (int j = 0; j < 4; j++) {
            this.tab_jeu[this.ligne][j]=combinaison[j];
        }
    }
    public void verifier(){
        //Log.e("value: ",Integer.toString(this.tab_verifN[9][0]));
        if(this.ligne==10){
            return;
        }
        int i=0;
        int[] verrou= {0,0,0,0};
        int[] verrou2= {0,0,0,0};
        for (int j = 0; j < 4; j++) {
            if(this.tab_jeu[this.ligne][j]==this.combiSecrete[j]) {
                Log.e("value3: ","oui");
                this.tab_verifN[this.ligne][i]=1;
                verrou2[j]=1;
                verrou[j]=1;
                i++;
            }
        }
        i=0;
        for (int j = 0; j < 4; j++) {
            for (int k = 0; k < 4; k++) {
                if (this.tab_jeu[this.ligne][j] == this.combiSecrete[k] && verrou[k]!=1 && verrou2[j]!=1) {
                    this.tab_verifB[this.ligne][i] = 1;
                    i++;
                    verrou[k]=1;
                    k=4;
                }
            }
        }
        //Log.e("value2: ",Integer.toString(this.tab_verifN[9][0]));
        this.ligne++;
    }
    public int[][] getTab_jeu(){
        return this.tab_jeu;
    }
    public int[][] getTab_verifN(){
        return this.tab_verifN;
    }
    public int[][] getTab_verifB(){
        return this.tab_verifB;
    }
}
