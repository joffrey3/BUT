#include <stdio.h>
#include <stdlib.h>
#include <graph.h>
#include <time.h>
#define L 200
#define H 200
int ChargerImage(char *f,int x,int y,int xx,int yy,int l,int h);

void ChargerImageFond(char *file);

void ChoisirEcran(int n);

void CopierZone(int src,int dst,int ox,int oy,int lar,int hau, int dx,int dy);

couleur CouleurParComposante(unsigned char r, unsigned char v, unsigned char b);
 
int page_taquin()
{
    int x, y, i=0 , j,k,l;
    InitialiserGraphique();
    CreerFenetre(10,10,1000,1000);
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
    printf("Le taquin va commencer\n");
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
    }/*
    ChoisirEcran(0);
    for (i=0;i<y;i++){
        for (j=0;j<x;j++){
         ChargerImage("image.jpg",600+i*L/y+i,400+j*H/x+j,0+i*L/y+i,0+j*H/x+j,L/y,H/x);
        }
    }*/
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
                            ChargerImage("image.jpg",200+l*L/y+l,400+k*H/x+k,0+j*L/y,0+i*H/x,L/y,H/x);
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
                        ChargerImage("image.jpg",600+i*L/y+i,400+j*H/x+j,0+i*L/y+i,0+j*H/x+j,L/y,H/x);
                    }
                }

                for (i=0;i<x;i++){
                    for (j=0;j<y;j++){
                        if (i!=0 || j!=0){
                            for (k=0;k<x;k++){
                                for (l=0;l<y;l++){
                                    if (tab[k][l]==i*y+j){
                                        ChargerImage("image.jpg",200+l*L/y+l,400+k*H/x+k,0+j*L/y,0+i*H/x,L/y,H/x);
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
         ChargerImage("image.jpg",600+i*L/y+i,400+j*H/x+j,0+i*L/y+i,0+j*H/x+j,L/y,H/x);
        }
    }

                for (i=0;i<x;i++){
                    for (j=0;j<y;j++){
                        if (i!=0 || j!=0){
                            for (k=0;k<x;k++){
                                for (l=0;l<y;l++){
                                    if (tab[k][l]==i*y+j){
                                        ChargerImage("image.jpg",200+l*L/y+l,400+k*H/x+k,0+j*L/y,0+i*H/x,L/y,H/x);
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
         ChargerImage("image.jpg",600+i*L/y+i,400+j*H/x+j,0+i*L/y+i,0+j*H/x+j,L/y,H/x);
        }
    }

                for (i=0;i<x;i++){
                    for (j=0;j<y;j++){
                        if (i!=0 || j!=0){
                            for (k=0;k<x;k++){
                                for (l=0;l<y;l++){
                                    if (tab[k][l]==i*y+j){
                                        ChargerImage("image.jpg",200+l*L/y+l,400+k*H/x+k,0+j*L/y,0+i*H/x,L/y,H/x);
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
         ChargerImage("image.jpg",600+i*L/y+i,400+j*H/x+j,0+i*L/y+i,0+j*H/x+j,L/y,H/x);
        }
    }

                for (i=0;i<x;i++){
                    for (j=0;j<y;j++){
                        if (i!=0 || j!=0){
                            for (k=0;k<x;k++){
                                for (l=0;l<y;l++){
                                    if (tab[k][l]==i*y+j){
                                        ChargerImage("image.jpg",200+l*L/y+l,400+k*H/x+k,0+j*L/y,0+i*H/x,L/y,H/x);
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
    FermerGraphique();
    return EXIT_SUCCESS;
}