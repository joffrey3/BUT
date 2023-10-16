#include <stdio.h>
#include <stdlib.h>
#include <graph.h>
#include <math.h>

int triangle(int n,int l,int pos_x,int pos_y);

int main(void){
  InitialiserGraphique();
  CreerFenetre(10,10,1000,1000);
  triangle(3,180,360,360);
  Touche();
  FermerGraphique();
}
int triangle(int n,int l,int pos_x,int pos_y) {
  DessinerSegment(pos_x,pos_y,pos_x-l/2,pos_y+l/2*sqrt(3));
  DessinerSegment(pos_x-l/2,pos_y+l/2*sqrt(3),pos_x+l/2,pos_y+l/2*sqrt(3));
  DessinerSegment(pos_x+l/2,pos_y+l/2*sqrt(3),pos_x,pos_y); 
  if (n!=0){
    triangle(n-1,l/2,pos_x,pos_y);
    triangle(n-1,l/2,pos_x-l/4,pos_y+(l/2*sqrt(3))/2);
    triangle(n-1,l/2,pos_x+l/4,pos_y+(l/2*sqrt(3))/2);
    return 1;
  }
  else{
  return 0;
  }
}