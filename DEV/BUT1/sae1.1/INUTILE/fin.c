#include <stdio.h>
#include <stdlib.h>
#include <graph.h>
#include <time.h>
#include "fonction.h"
#define L 200
#define H 200

int page_accueil()
{
	unsigned long int b=CouleurParComposante(255,255,255),N=CouleurParComposante(0,0,0),R=CouleurParComposante(255,0,0),V=CouleurParComposante(0,255,0),B=CouleurParComposante(0,0,255),Y=CouleurParComposante(255,255,0),v=CouleurParComposante(255,0,255),Bl=CouleurParComposante(0,255,255),G=CouleurParComposante(128,128,128);
	EffacerEcran(b);
	ChargerImageFond("image2.jpg");
	int flag=1;
    ChoisirCouleurDessin(B);
    RemplirRectangle(400,200,200,50);
    ChoisirCouleurDessin(N);
    DessinerRectangle(400,200,200,50);
    EcrireTexte(500,225,"Jouer",2);
    ChoisirCouleurDessin(B);
    RemplirRectangle(50,50,50,50);
    ChoisirCouleurDessin(N);
    DessinerRectangle(50,50,50,50);
    EcrireTexte(75,75,"Quitter",2);
    for(;flag!=0;){
    	if (SourisCliquee()==1){
    		SourisPosition();
    		if (_X>=400 && _X<=600 && _Y>=200 && _Y<=250){
    			return 2;
    		}
    		if (_X>=900 && _X<=950 && _Y>=50 && _Y<=100){
    			return 6;
    		}
    		if (_X>=50 && _X<=100 && _Y>=50 && _Y<=100){
    			return 0;
    		}
    	}
    }
}

int page_image()
{
    int flag=1, i=0;
    char * chaine[20];
    unsigned long int b=CouleurParComposante(255,255,255),N=CouleurParComposante(0,0,0),R=CouleurParComposante(255,0,0),V=CouleurParComposante(0,255,0),B=CouleurParComposante(0,0,255),Y=CouleurParComposante(255,255,0),v=CouleurParComposante(255,0,255),Bl=CouleurParComposante(0,255,255),G=CouleurParComposante(128,128,128);
    EffacerEcran(b);
    ChargerImageFond("image2.jpg");
    ChoisirCouleurDessin(B);
    RemplirRectangle(50,50,50,50);
    ChoisirCouleurDessin(N);
    DessinerRectangle(50,50,50,50);
    EcrireTexte(50,50,"Retour",2);
    ChoisirCouleurDessin(B);
    RemplirRectangle(400,200,200,50);
    ChoisirCouleurDessin(N);
    DessinerRectangle(400,200,200,50);
    EcrireTexte(400,225,"Choisir une image",2);
    ChoisirCouleurDessin(B);
    RemplirRectangle(400,900,200,50);
    ChoisirCouleurDessin(N);
    DessinerRectangle(400,900,200,50);
    EcrireTexte(500,925,"Lancer",2);
    ChargerImage("image3.png",200,400,0,0,200,100);
    ChargerImage("image4.jpg",400,400,0,0,200,100);
    ChargerImage("image5.jpg",600,400,0,0,200,100);
    Touche();
    for(;flag!=0;){
        if (SourisCliquee()==1){
            SourisPosition();
            if (_X>=200 && _X<=400 && _Y>=400 && _Y<=500){
                ChoisirCouleurDessin(N);
                DessinerRectangle(200+i*200,400,200,50);
                chaine="image3.png";
                i=0;
                ChoisirCouleurDessin(V);
                DessinerRectangle(200+i*200,400,200,50);
            }
            if (_X>=400 && _X<=600 && _Y>=400 && _Y<=500){
                ChoisirCouleurDessin(N);
                DessinerRectangle(200+i*200,400,200,50);
                chaine="image4.jpg";
                i=1;
                ChoisirCouleurDessin(V);
                DessinerRectangle(200+i*200,400,200,50);
            }
            if (_X>=600 && _X<=800 && _Y>=400 && _Y<=500){
               ChoisirCouleurDessin(N);
                DessinerRectangle(200+i*200,400,200,50);
                chaine="image5.jpg";
                i=2;
                ChoisirCouleurDessin(V);
                DessinerRectangle(200+i*200,400,200,50);
            }
            if (_X>=400 && _X<=600 && _Y>=900 && _Y<=950){
                return chaine;
            }
            if (_X>=50 && _X<=100 && _Y>=50 && _Y<=100){
                return NULL;
            }
        }
    }
    return EXIT_SUCCESS;
}

int page_taille(void)
{
   unsigned long int b=CouleurParComposante(255,255,255),N=CouleurParComposante(0,0,0),R=CouleurParComposante(255,0,0),V=CouleurParComposante(0,255,0),B=CouleurParComposante(0,0,255),Y=CouleurParComposante(255,255,0),v=CouleurParComposante(255,0,255),Bl=CouleurParComposante(0,255,255),G=CouleurParComposante(128,128,128);
   EffacerEcran(b);
   ChargerImageFond("image2.jpg");
   int flag=1,i ,j ,x ,y ,t[2];
   char taille[6]={'3','4','5','6','7','8'};
   ChoisirCouleurDessin(B);
   RemplirRectangle(400,100,200,50);
   ChoisirCouleurDessin(N);
   DessinerRectangle(400,100,200,50);
   EcrireTexte(500,125,"Choisir la taille",2);
   ChoisirCouleurDessin(B);
   RemplirRectangle(150,200,100,50);
   ChoisirCouleurDessin(N);
   DessinerRectangle(150,200,100,50);
   EcrireTexte(200,225,"Lignes",2);
   ChoisirCouleurDessin(B);
   RemplirRectangle(650,200,100,50);
   ChoisirCouleurDessin(N);
   DessinerRectangle(650,200,100,50);
   EcrireTexte(700,225,"Colonnes",2);
   ChoisirCouleurDessin(B);
   RemplirRectangle(50,50,50,50);
   ChoisirCouleurDessin(N);
   DessinerRectangle(50,50,50,50);
   EcrireTexte(75,75,"Retour",2);
   ChoisirCouleurDessin(B);
   RemplirRectangle(400,900,200,50);
   ChoisirCouleurDessin(N);
   DessinerRectangle(400,900,200,50);
   EcrireTexte(500,925,"Lancer",2);
   for(i=0;i<=1;i++){
      for(j=3;j<=8;j++){
         ChoisirCouleurDessin(B);
         RemplirRectangle(175+i*500,j*100,50,50);
         ChoisirCouleurDessin(N);
         DessinerRectangle(175+i*500,j*100,50,50);
         EcrireTexte(175+i*500+25,j*100+25,"1",2);
      }
   }
   for(;flag!=0;){
      if (SourisCliquee()==1){
         SourisPosition();
         if (_X>=175 && _X<=225 && _Y>=300 && _Y<=350){
            ChoisirCouleurDessin(B);
            RemplirRectangle(175+i*500,j*100,50,50);
            ChoisirCouleurDessin(N);
            DessinerRectangle(175+i*500,j*100,50,50);
            EcrireTexte(175+i*500+25,j*100+25,"1",2);
            x=3;
            i=0;
            j=3;
            ChoisirCouleurDessin(B);
            RemplirRectangle(175+i*500,j*100,50,50);
            ChoisirCouleurDessin(N);
            DessinerRectangle(175+i*500,j*100,50,50);
            EcrireTexte(175+i*500+25,j*100+25,"1",2);

         }
         if (_X>=175 && _X<=225 && _Y>=400 && _Y<=450){
            ChoisirCouleurDessin(B);
            RemplirRectangle(175+i*500,j*100,50,50);
            ChoisirCouleurDessin(N);
            DessinerRectangle(175+i*500,j*100,50,50);
            EcrireTexte(175+i*500+25,j*100+25,"1",2);
            x=4;
            i=0;
            j=4;
            ChoisirCouleurDessin(B);
            RemplirRectangle(175+i*500,j*100,50,50);
            ChoisirCouleurDessin(N);
            DessinerRectangle(175+i*500,j*100,50,50);
            EcrireTexte(175+i*500+25,j*100+25,"1",2);
         }
         if (_X>=175 && _X<=225 && _Y>=500 && _Y<=550){
            ChoisirCouleurDessin(B);
            RemplirRectangle(175+i*500,j*100,50,50);
            ChoisirCouleurDessin(N);
            DessinerRectangle(175+i*500,j*100,50,50);
            EcrireTexte(175+i*500+25,j*100+25,"1",2);
            x=5;
            i=0;
            j=5;
            ChoisirCouleurDessin(B);
            RemplirRectangle(175+i*500,j*100,50,50);
            ChoisirCouleurDessin(N);
            DessinerRectangle(175+i*500,j*100,50,50);
            EcrireTexte(175+i*500+25,j*100+25,"1",2);
         }
         if (_X>=175 && _X<=225 && _Y>=600 && _Y<=650){
            ChoisirCouleurDessin(B);
            RemplirRectangle(175+i*500,j*100,50,50);
            ChoisirCouleurDessin(N);
            DessinerRectangle(175+i*500,j*100,50,50);
            EcrireTexte(175+i*500+25,j*100+25,"1",2);
            x=6;
            i=0;
            j=6;
            ChoisirCouleurDessin(B);
            RemplirRectangle(175+i*500,j*100,50,50);
            ChoisirCouleurDessin(N);
            DessinerRectangle(175+i*500,j*100,50,50);
            EcrireTexte(175+i*500+25,j*100+25,"1",2);
         }
         if (_X>=175 && _X<=225 && _Y>=700 && _Y<=750){
            ChoisirCouleurDessin(B);
            RemplirRectangle(175+i*500,j*100,50,50);
            ChoisirCouleurDessin(N);
            DessinerRectangle(175+i*500,j*100,50,50);
            EcrireTexte(175+i*500+25,j*100+25,"1",2);
            x=7;
            i=0;
            j=7;
            ChoisirCouleurDessin(B);
            RemplirRectangle(175+i*500,j*100,50,50);
            ChoisirCouleurDessin(N);
            DessinerRectangle(175+i*500,j*100,50,50);
            EcrireTexte(175+i*500+25,j*100+25,"1",2);
         }
         if (_X>=175 && _X<=225 && _Y>=800 && _Y<=850){
            ChoisirCouleurDessin(B);
            RemplirRectangle(175+i*500,j*100,50,50);
            ChoisirCouleurDessin(N);
            DessinerRectangle(175+i*500,j*100,50,50);
            EcrireTexte(175+i*500+25,j*100+25,"1",2);
            x=8;
            i=0;
            j=8;
            ChoisirCouleurDessin(B);
            RemplirRectangle(175+i*500,j*100,50,50);
            ChoisirCouleurDessin(N);
            DessinerRectangle(175+i*500,j*100,50,50);
            EcrireTexte(175+i*500+25,j*100+25,"1",2);
         }
         if (_X>=675 && _X<=725 && _Y>=300 && _Y<=350){
            ChoisirCouleurDessin(B);
            RemplirRectangle(175+i*500,j*100,50,50);
            ChoisirCouleurDessin(N);
            DessinerRectangle(175+i*500,j*100,50,50);
            EcrireTexte(175+i*500+25,j*100+25,"1",2);
            y=3;
            i=1;
            j=3;
            ChoisirCouleurDessin(B);
            RemplirRectangle(175+i*500,j*100,50,50);
            ChoisirCouleurDessin(N);
            DessinerRectangle(175+i*500,j*100,50,50);
            EcrireTexte(175+i*500+25,j*100+25,"1",2);
         }
         if (_X>=675 && _X<=725 && _Y>=400 && _Y<=450){
            ChoisirCouleurDessin(B);
            RemplirRectangle(175+i*500,j*100,50,50);
            ChoisirCouleurDessin(N);
            DessinerRectangle(175+i*500,j*100,50,50);
            EcrireTexte(175+i*500+25,j*100+25,"1",2);
            y=4;
            i=1;
            j=4;
            ChoisirCouleurDessin(B);
            RemplirRectangle(175+i*500,j*100,50,50);
            ChoisirCouleurDessin(N);
            DessinerRectangle(175+i*500,j*100,50,50);
            EcrireTexte(175+i*500+25,j*100+25,"1",2);
         }
         if (_X>=675 && _X<=725 && _Y>=500 && _Y<=550){
            ChoisirCouleurDessin(B);
            RemplirRectangle(175+i*500,j*100,50,50);
            ChoisirCouleurDessin(N);
            DessinerRectangle(175+i*500,j*100,50,50);
            EcrireTexte(175+i*500+25,j*100+25,"1",2);
            y=5;
            i=1;
            j=5;
            ChoisirCouleurDessin(B);
            RemplirRectangle(175+i*500,j*100,50,50);
            ChoisirCouleurDessin(N);
            DessinerRectangle(175+i*500,j*100,50,50);
            EcrireTexte(175+i*500+25,j*100+25,"1",2);
         }
         if (_X>=675 && _X<=725 && _Y>=600 && _Y<=650){
            ChoisirCouleurDessin(B);
            RemplirRectangle(175+i*500,j*100,50,50);
            ChoisirCouleurDessin(N);
            DessinerRectangle(175+i*500,j*100,50,50);
            EcrireTexte(175+i*500+25,j*100+25,"1",2);
            y=6;
            i=1;
            j=6;
            ChoisirCouleurDessin(B);
            RemplirRectangle(175+i*500,j*100,50,50);
            ChoisirCouleurDessin(N);
            DessinerRectangle(175+i*500,j*100,50,50);
            EcrireTexte(175+i*500+25,j*100+25,"1",2);
         }
         if (_X>=675 && _X<=725 && _Y>=700 && _Y<=750){
            ChoisirCouleurDessin(B);
            RemplirRectangle(175+i*500,j*100,50,50);
            ChoisirCouleurDessin(N);
            DessinerRectangle(175+i*500,j*100,50,50);
            EcrireTexte(175+i*500+25,j*100+25,"1",2);
            y=7;
            i=1;
            j=7;
            ChoisirCouleurDessin(B);
            RemplirRectangle(175+i*500,j*100,50,50);
            ChoisirCouleurDessin(N);
            DessinerRectangle(175+i*500,j*100,50,50);
            EcrireTexte(175+i*500+25,j*100+25,"1",2);
         }
         if (_X>=675 && _X<=725 && _Y>=800 && _Y<=850){
            ChoisirCouleurDessin(B);
            RemplirRectangle(175+i*500,j*100,50,50);
            ChoisirCouleurDessin(N);
            DessinerRectangle(175+i*500,j*100,50,50);
            EcrireTexte(175+i*500+25,j*100+25,"1",2);
            y=8;
            i=1;
            j=8;
            ChoisirCouleurDessin(B);
            RemplirRectangle(175+i*500,j*100,50,50);
            ChoisirCouleurDessin(N);
            DessinerRectangle(175+i*500,j*100,50,50);
            EcrireTexte(175+i*500+25,j*100+25,"1",2);
         }
         if (_X>=400 && _X<=600 && _Y>=900 && _Y<=950){
            t[0]=x;
            t[1]=y;
            return 4;
         }
         if (_X>=50 && _X<=100 && _Y>=50 && _Y<=100){
            return 1;
         }
      }
   }
}

int page_taquin(x,y,image)
{
    int x, y, i=0 , j,k,l;
    unsigned long int b=CouleurParComposante(255,255,255),N=CouleurParComposante(0,0,0),R=CouleurParComposante(255,0,0),V=CouleurParComposante(0,255,0),B=CouleurParComposante(0,0,255),Y=CouleurParComposante(255,255,0),v=CouleurParComposante(255,0,255),Bl=CouleurParComposante(0,255,255),G=CouleurParComposante(128,128,128);
    EffacerEcran(b);
    ChargerImageFond("image2.jpg");
    ChoisirCouleurDessin(B);
    RemplirRectangle(400,900,200,50);
    ChoisirCouleurDessin(N);
    DessinerRectangle(400,900,200,50);
    EcrireTexte(410,75,"Recommencer",2);
   ChoisirCouleurDessin(B);
    RemplirRectangle(50,50,50,50);
    ChoisirCouleurDessin(N);
    DessinerRectangle(50,50,50,50);
    EcrireTexte(75,75,"retour aux tailles",2);
    ChoisirCouleurDessin(B);
    RemplirRectangle(150,50,50,50);
    ChoisirCouleurDessin(N);
    DessinerRectangle(150,50,50,50);
    EcrireTexte(175,75,"retour aux  images",2);
    ChoisirCouleurDessin(B);
    RemplirRectangle(250,50,50,50);
    ChoisirCouleurDessin(N);
    DessinerRectangle(250,50,50,50);
    EcrireTexte(275,75,"retour a l'accueil",2);
    srand(time(NULL));
    /*printf("Le taquin va commencer\n");
    for (;i!=1;){
        printf("Lignes : ");
        scanf("%d",&x);
        printf("Colonnes : ");
        scanf("%d",&y);
        if ((x>=3) && (x<=8) && (y>=3) && (y<=8)){
            i=1;
        }else{
            printf("Les dimensions ne correspondent pas aux valeurs souhaitées (entre 3 et 8)\n ");
        }
    }*/

    ChoisirEcran(0);
    for (i=0;i<y;i++){
        for (j=0;j<x;j++){
         ChargerImage(image,600+i*L/y+i,400+j*H/x+j,0+i*L/y+i,0+j*H/x+j,L/y,H/x);
        }
    }
    /*ChoisirEcran(0);
    for (i=0;i<x;i++){
        for (j=0;j<y;j++){
            if (i!=0 || j!=0){
                ChargerImage("image.jpg",0+j*H/y+j,0+i*L/x+i,0+i*L/x,0+j*H/y,L/y,H/x);
            }
        }
    }*/
    int tab[x][y], alea_x, alea_y, pos_x, pos_y;
    ChoisirEcran(0);
    for (i=0;i<x;i++){
        for (j=0;j<y;j++){
            tab[i][j]=-1;
        }
    }
    for (i=0;i<(x*y);i++){
        alea_x=rand()%x;
        alea_y=rand()%y;
        if (i==0){
            pos_x=alea_x;
            pos_y=alea_y;
        }
        if(tab[alea_x][alea_y]!=-1){
            i=i-1;
        }else {
            tab[alea_x][alea_y]=i;
        }
    }
    for (i=0;i<x;i++){
        for (j=0;j<y;j++){
            printf("%2d ",tab[i][j]);
        }
        printf("\n");
    }
    for (i=0;i<x;i++){
        for (j=0;j<y;j++){
            if (i!=0 || j!=0){
                for (k=0;k<x;k++){
                    for (l=0;l<y;l++){
                        if (tab[k][l]==i*y+j){
                            ChargerImage(image,200+l*L/y+l,400+k*H/x+k,0+j*L/y,0+i*H/x,L/y,H/x);
                        }
                    }
                }
                printf("%d\n",i*y+j);
            }
        }
    }
    /*CopierZone(1,0,0,0,210,210,400,0);
    Touche();
    CopierZone(2,0,0,0,210,210, 0,400);*/
    int t=Touche();
    for(;t!=XK_Escape;){
        if(t==XK_Up){
            if (pos_x==x-1){
                printf("Bordure de taquin\n");  
            }else{
                tab[pos_x][pos_y]=tab[pos_x+1][pos_y];
                tab[pos_x+1][pos_y]=0;
                pos_x=pos_x+1;
                EffacerEcran(b);
                ChargerImageFond("image2.jpg");
                ChoisirCouleurDessin(B);
                RemplirRectangle(400,900,200,50);
                ChoisirCouleurDessin(N);
                DessinerRectangle(400,900,200,50);
                EcrireTexte(410,75,"Recommencer",2);
                ChoisirCouleurDessin(B);
                RemplirRectangle(50,50,50,50);
                ChoisirCouleurDessin(N);
                DessinerRectangle(50,50,50,50);
                EcrireTexte(75,75,"retour aux tailles",2);
                ChoisirCouleurDessin(B);
                RemplirRectangle(150,50,50,50);
                ChoisirCouleurDessin(N);
                DessinerRectangle(150,50,50,50);
                EcrireTexte(175,75,"retour aux  images",2);
                ChoisirCouleurDessin(B);
                RemplirRectangle(250,50,50,50);
                ChoisirCouleurDessin(N);
                DessinerRectangle(250,50,50,50);
                EcrireTexte(275,75,"retour a l'accueil",2);
                for (i=0;i<y;i++){
                    for (j=0;j<x;j++){
                        ChargerImage(image,600+i*L/y+i,400+j*H/x+j,0+i*L/y+i,0+j*H/x+j,L/y,H/x);
                    }
                }

                for (i=0;i<x;i++){
                    for (j=0;j<y;j++){
                        if (i!=0 || j!=0){
                            for (k=0;k<x;k++){
                                for (l=0;l<y;l++){
                                    if (tab[k][l]==i*y+j){
                                        ChargerImage(image,200+l*L/y+l,400+k*H/x+k,0+j*L/y,0+i*H/x,L/y,H/x);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            for (i=0;i<x;i++){
                for (j=0;j<y;j++){
                    printf("%2d ",tab[i][j]);
                }
                printf("\n");
            }
        }
        if(t==XK_Down){
            if (pos_x==0){
                printf("Bordure de taquin\n");  
            }else{
                tab[pos_x][pos_y]=tab[pos_x-1][pos_y];
                tab[pos_x-1][pos_y]=0;
                pos_x=pos_x-1;
                EffacerEcran(b);
                ChargerImageFond("image2.jpg");
    ChoisirCouleurDessin(B);
    RemplirRectangle(400,900,200,50);
    ChoisirCouleurDessin(N);
    DessinerRectangle(400,900,200,50);
    EcrireTexte(410,75,"Recommencer",2);
   ChoisirCouleurDessin(B);
    RemplirRectangle(50,50,50,50);
    ChoisirCouleurDessin(N);
    DessinerRectangle(50,50,50,50);
    EcrireTexte(75,75,"retour aux tailles",2);
    ChoisirCouleurDessin(B);
    RemplirRectangle(150,50,50,50);
    ChoisirCouleurDessin(N);
    DessinerRectangle(150,50,50,50);
    EcrireTexte(175,75,"retour aux  images",2);
    ChoisirCouleurDessin(B);
    RemplirRectangle(250,50,50,50);
    ChoisirCouleurDessin(N);
    DessinerRectangle(250,50,50,50);
    EcrireTexte(275,75,"retour a l'accueil",2);
    for (i=0;i<y;i++){
        for (j=0;j<x;j++){
         ChargerImage(image,600+i*L/y+i,400+j*H/x+j,0+i*L/y+i,0+j*H/x+j,L/y,H/x);
        }
    }

                for (i=0;i<x;i++){
                    for (j=0;j<y;j++){
                        if (i!=0 || j!=0){
                            for (k=0;k<x;k++){
                                for (l=0;l<y;l++){
                                    if (tab[k][l]==i*y+j){
                                        ChargerImage(image,200+l*L/y+l,400+k*H/x+k,0+j*L/y,0+i*H/x,L/y,H/x);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            for (i=0;i<x;i++){
                for (j=0;j<y;j++){
                    printf("%2d ",tab[i][j]);
                }
                printf("\n");
            }
        }
        if(t==XK_Right){
            if (pos_y==0){
                printf("Bordure de taquin\n");  
            }else{
                tab[pos_x][pos_y]=tab[pos_x][pos_y-1];
                tab[pos_x][pos_y-1]=0;
                pos_y=pos_y-1;
                EffacerEcran(b);
                ChargerImageFond("image2.jpg");
    ChoisirCouleurDessin(B);
    RemplirRectangle(400,900,200,50);
    ChoisirCouleurDessin(N);
    DessinerRectangle(400,900,200,50);
    EcrireTexte(410,75,"Recommencer",2);
   ChoisirCouleurDessin(B);
    RemplirRectangle(50,50,50,50);
    ChoisirCouleurDessin(N);
    DessinerRectangle(50,50,50,50);
    EcrireTexte(75,75,"retour aux tailles",2);
    ChoisirCouleurDessin(B);
    RemplirRectangle(150,50,50,50);
    ChoisirCouleurDessin(N);
    DessinerRectangle(150,50,50,50);
    EcrireTexte(175,75,"retour aux  images",2);
    ChoisirCouleurDessin(B);
    RemplirRectangle(250,50,50,50);
    ChoisirCouleurDessin(N);
    DessinerRectangle(250,50,50,50);
    EcrireTexte(275,75,"retour a l'accueil",2);
    for (i=0;i<y;i++){
        for (j=0;j<x;j++){
         ChargerImage(image,600+i*L/y+i,400+j*H/x+j,0+i*L/y+i,0+j*H/x+j,L/y,H/x);
        }
    }

                for (i=0;i<x;i++){
                    for (j=0;j<y;j++){
                        if (i!=0 || j!=0){
                            for (k=0;k<x;k++){
                                for (l=0;l<y;l++){
                                    if (tab[k][l]==i*y+j){
                                        ChargerImage(image,200+l*L/y+l,400+k*H/x+k,0+j*L/y,0+i*H/x,L/y,H/x);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            for (i=0;i<x;i++){
                for (j=0;j<y;j++){
                    printf("%2d ",tab[i][j]);
                }
                printf("\n");
            }
        }
        if(t==XK_Left){
            if (pos_y==y-1){
                printf("Bordure de taquin\n");  
            }else{
                tab[pos_x][pos_y]=tab[pos_x][pos_y+1];
                tab[pos_x][pos_y+1]=0;
                pos_y=pos_y+1; 
                EffacerEcran(b);
                ChargerImageFond("image2.jpg");
    ChoisirCouleurDessin(B);
    RemplirRectangle(400,900,200,50);
    ChoisirCouleurDessin(N);
    DessinerRectangle(400,900,200,50);
    EcrireTexte(410,75,"Recommencer",2);
   ChoisirCouleurDessin(B);
    RemplirRectangle(50,50,50,50);
    ChoisirCouleurDessin(N);
    DessinerRectangle(50,50,50,50);
    EcrireTexte(75,75,"retour aux tailles",2);
    ChoisirCouleurDessin(B);
    RemplirRectangle(150,50,50,50);
    ChoisirCouleurDessin(N);
    DessinerRectangle(150,50,50,50);
    EcrireTexte(175,75,"retour aux  images",2);
    ChoisirCouleurDessin(B);
    RemplirRectangle(250,50,50,50);
    ChoisirCouleurDessin(N);
    DessinerRectangle(250,50,50,50);
    EcrireTexte(275,75,"retour a l'accueil",2);
    for (i=0;i<y;i++){
        for (j=0;j<x;j++){
         ChargerImage(image,600+i*L/y+i,400+j*H/x+j,0+i*L/y+i,0+j*H/x+j,L/y,H/x);
        }
    }

                for (i=0;i<x;i++){
                    for (j=0;j<y;j++){
                        if (i!=0 || j!=0){
                            for (k=0;k<x;k++){
                                for (l=0;l<y;l++){
                                    if (tab[k][l]==i*y+j){
                                        ChargerImage(image,200+l*L/y+l,400+k*H/x+k,0+j*L/y,0+i*H/x,L/y,H/x);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            for (i=0;i<x;i++){
                for (j=0;j<y;j++){
                    printf("%2d ",tab[i][j]);
                }
                printf("\n");
            }
        }
        t=Touche();
    }
    return EXIT_SUCCESS;
}

int page_victoire(image)
{
   int x, y, i=0 , j,k,l,flag=1;
   unsigned long int b=CouleurParComposante(255,255,255),N=CouleurParComposante(0,0,0),R=CouleurParComposante(255,0,0),V=CouleurParComposante(0,255,0),B=CouleurParComposante(0,0,255),Y=CouleurParComposante(255,255,0),v=CouleurParComposante(255,0,255),Bl=CouleurParComposante(0,255,255),G=CouleurParComposante(128,128,128);
   EffacerEcran(b);
   ChargerImageFond("image2.jpg");
   ChoisirCouleurDessin(B);
    RemplirRectangle(400,900,200,50);
    ChoisirCouleurDessin(N);
    DessinerRectangle(400,900,200,50);
    EcrireTexte(410,75,"Recommencer",2);
   ChoisirCouleurDessin(B);
   RemplirRectangle(50,50,50,50);
   ChoisirCouleurDessin(N);
   DessinerRectangle(50,50,50,50);
   EcrireTexte(75,75,"retour aux tailles",2);
   ChoisirCouleurDessin(B);
   RemplirRectangle(150,50,50,50);
   ChoisirCouleurDessin(N);
   DessinerRectangle(150,50,50,50);
   EcrireTexte(175,75,"retour aux  images",2);
   ChoisirCouleurDessin(B);
   RemplirRectangle(250,50,50,50);
   ChoisirCouleurDessin(N);
   DessinerRectangle(250,50,50,50);
   EcrireTexte(275,75,"retour a l'accueil",2);
   ChargerImage(image,200,200,0,0,L,H);
   for(;flag!=0;){
      if (SourisCliquee()==1){
         SourisPosition();
         if (_X>=400 && _X<=600 && _Y>=900 && _Y<=950){
            return 4;
         }
         if (_X>=50 && _X<=100 && _Y>=50 && _Y<=100){
            return 3;
         }
         if (_X>=150 && _X<=200 && _Y>=50 && _Y<=100){
            return 2;
         }
         if (_X>=250 && _X<=300 && _Y>=50 && _Y<=100){
            return 1;
         }
      }
    }
}

int main()
{
    InitialiserGraphique();
    CreerFenetre(10,10,1000,1000);
    int p=1,t;
    char * im;
    for (;p!=0;){
        if(p==1){
        p=page_accueil();
        }
        if(p==2){
            if (page_image()==NULL){
                p=1;
            }
            else{
                p=3;
                im=page_image();
            }
        }
        if(p==3){
        t=page_taille();
        p=t[0];
        x=t[1];
        y=t[2];
        }
        if(p==4){
        p=page_taquin(x,y,im);
        }
        if(p==5){
        p=page_victoire(im);
        }
    }
    FermerGraphique();
    printf("oui");
    return EXIT_SUCCESS;
}
