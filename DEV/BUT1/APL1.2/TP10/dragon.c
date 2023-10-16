#include <stdio.h>
#include <stdlib.h>
#include <graph.h>
#include <math.h>

int courbe(int n,double l,int pos_x,int pos_y,int flag);

int main(void){
  InitialiserGraphique();
  CreerFenetre(10,10,1000,1000);
  courbe(2,180.0,360,360,3);
  Touche();
  FermerGraphique();
}


int courbe(int n,double l,int pos_x,int pos_y,int flag) {
  if(flag==0){
    DessinerSegment(pos_x,pos_y,pos_x+l,pos_y+l);
  }
  if(flag==1){
    DessinerSegment(pos_x,pos_y,pos_x,pos_y+l);
  }
  if(flag==2){
    DessinerSegment(pos_x,pos_y,pos_x+l,pos_y);
  }
  if (n!=0){
    courbe(n-1,l,pos_x,pos_y,1);
    courbe(n-1,l,pos_x,pos_y+l,2);
    return 1;
  }
  else{
  return 0;
  }
}