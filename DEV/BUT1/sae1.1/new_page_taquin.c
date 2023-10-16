#include <stdio.h>
#include <stdlib.h>
#include <graph.h>
#include <time.h>
#include "fonction.h"
#define L 600
#define H 600

int new_page_taquin(int x,int y,int chaine){
  
    EffacerEcran(CouleurParNom("black"));
    ChargerImageFond("image2.jpg");
     bouton(400,900,200,50,"black","white","Recommencer");
   bouton(50,50,350,50,"black","white","Retour aux tailles");
   bouton(450,50,350,50,"black","white","Retour aux images");
   bouton(850,50,350,50,"black","white","Retour a l'accueil");
    int i=0 , j,k,l,flag=1;
    srand(time(NULL));

    /* La première partie du code initialise, remplit et mélange un tableau de façon aléatoire */
    
    int tab[8][8], alea_x, alea_y, pos_x, pos_y;
    for(;flag!=0;){
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
    int indentation1,indentation2,indentation3,indentation4,temp,tab2[8][8],zero_x=pos_x,zero_y=pos_y,parite_zero,parite,nb_mouv=0;
	flag=1;
	for (indentation1=0;indentation1<x;indentation1++){
		for (indentation2=0;indentation2<x;indentation2++){
			tab2[indentation1][indentation2]=tab[indentation1][indentation2];
		}
	}
	for (;flag!=0;){
		if (zero_x==0 &&zero_y==0){
			parite_zero=nb_mouv%2;
			flag=0;
		}
		else{
			if(zero_x!=0){
				zero_x=zero_x-1;
				nb_mouv=nb_mouv+1;
			}
			if(zero_y!=0){
				zero_y=zero_y-1;
				nb_mouv=nb_mouv+1;
			}
		}
	}
	flag=1;
	nb_mouv=0;
	for (indentation1=0;indentation1<x;indentation1++){
		for (indentation2=0;indentation2<x;indentation2++){
			if (tab2[indentation1][indentation2]!=indentation1*y+indentation2){
				for (indentation3=0;indentation3<x;indentation3++){
					for (indentation4=0;indentation4<x;indentation4++){
						if (indentation1*y+indentation2==tab2[indentation3][indentation4]){
							temp=tab2[indentation1][indentation2];
							tab2[indentation1][indentation2]=tab2[indentation3][indentation4];
							tab2[indentation3][indentation4]=temp;
							nb_mouv=nb_mouv+1;
						}
					}
				}
			}
		}
	}
    parite=nb_mouv%2;
    if (parite_zero==parite){
    	flag=0;
    }
    else{
    	printf("taquin impossible");
    	flag=1;
    }
}
    flag=1;

    /* La prochaine partie remplace les valeurs par des morceaux  d'image */
    
    for (i=0;i<x;i++){
        for (j=0;j<y;j++){
            if (i!=0 || j!=0){
                for (k=0;k<x;k++){
                    for (l=0;l<y;l++){
                        if (tab[k][l]==i*y+j){
                                     if(chaine==3){
				       ChargerImage("image3.png",400+l*(L-300)/y+l,200+k*(H-300)/x+k,200+j*(L-300)/y,200+i*(H-300)/x,(L-300)/y,(H-300)/x);
                                        }
                                        if(chaine==4){
					  ChargerImage("image4.jpg",400+l*(L-150)/y+l,200+k*(H-150)/x+k,1000+j*(L-150)/y,400+i*(H-150)/x,(L-150)/y,(H-150)/x);
                                        }
                                        if(chaine==5){
                                        ChargerImage("image5.jpg",400+l*L/y+l,200+k*H/x+k,200+j*L/y,200+i*H/x,L/y,H/x);
                                        }
                                
                        }
                    }
                }
            }
        }
    }

    /* Cette partie affiche l'image normale à côté du taquin pour donner un modèle à suivre */
    
		  if(chaine==3){
		    ChargerImage("image3.png",1200,200,200,200,300,300);
                   }
                   if(chaine==4){
		     ChargerImage("image4.jpg",1200,200,1000,400,450,450);
                   }
		   if(chaine==5){
		     ChargerImage("image5.jpg",1200,200,200,200,600,600);
                   }

		   /* A partir de ce moment, on rentre dans une boucle infinie qui va nous permettre grâce aux touches directionnelles de déplacer les cases du puzzle */

    int t=Touche();
    for(;flag!=0;){


      /* Touche du Haut*/
      
        if(t==XK_Up){
            if (pos_x==x-1){
                printf("Bordure de taquin\n");  
            }else{
                tab[pos_x][pos_y]=tab[pos_x+1][pos_y];
                tab[pos_x+1][pos_y]=0;
                pos_x=pos_x+1;
                EffacerEcran(CouleurParNom("black"));
                ChargerImageFond("image2.jpg");
                bouton(400,900,200,50,"black","white","Recommencer");
		bouton(50,50,350,50,"black","white","Retour aux tailles");
		bouton(450,50,350,50,"black","white","Retour aux images");
		bouton(850,50,350,50,"black","white","Retour a l'accueil");
                for (i=0;i<x;i++){
                    for (j=0;j<y;j++){
                        if (i!=0 || j!=0){
                            for (k=0;k<x;k++){
                                for (l=0;l<y;l++){
                                    if (tab[k][l]==i*y+j){
                                       if(chaine==3){
				       ChargerImage("image3.png",400+l*(L-300)/y+l,200+k*(H-300)/x+k,200+j*(L-300)/y,200+i*(H-300)/x,(L-300)/y,(H-300)/x);
                                        }
                                        if(chaine==4){
					  ChargerImage("image4.jpg",400+l*(L-150)/y+l,200+k*(H-150)/x+k,1000+j*(L-150)/y,400+i*(H-150)/x,(L-150)/y,(H-150)/x);
                                        }
                                        if(chaine==5){
                                        ChargerImage("image5.jpg",400+l*L/y+l,200+k*H/x+k,200+j*L/y,200+i*H/x,L/y,H/x);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
	    }
        }
	  if(chaine==3){
		    ChargerImage("image3.png",1200,200,200,200,300,300);
                   }
                   if(chaine==4){
		     ChargerImage("image4.jpg",1200,200,1000,400,450,450);
                   }
		   if(chaine==5){
		     ChargerImage("image5.jpg",1200,200,200,200,600,600);
                   }

		   /* Touche du bas */
		   
        if(t==XK_Down){
            if (pos_x==0){
                printf("Bordure de taquin\n");  
            }else{
                tab[pos_x][pos_y]=tab[pos_x-1][pos_y];
                tab[pos_x-1][pos_y]=0;
                pos_x=pos_x-1;
                EffacerEcran(CouleurParNom("black"));
		ChargerImageFond("image2.jpg");
		bouton(400,900,200,50,"black","white","Recommencer");
		bouton(50,50,350,50,"black","white","Retour aux tailles");
		bouton(450,50,350,50,"black","white","Retour aux images");
		bouton(850,50,350,50,"black","white","Retour a l'accueil");
                for (i=0;i<x;i++){
                    for (j=0;j<y;j++){
                        if (i!=0 || j!=0){
                            for (k=0;k<x;k++){
                                for (l=0;l<y;l++){
                                    if (tab[k][l]==i*y+j){
                                       if(chaine==3){
				       ChargerImage("image3.png",400+l*(L-300)/y+l,200+k*(H-300)/x+k,200+j*(L-300)/y,200+i*(H-300)/x,(L-300)/y,(H-300)/x);
                                        }
                                        if(chaine==4){
					  ChargerImage("image4.jpg",400+l*(L-150)/y+l,200+k*(H-150)/x+k,1000+j*(L-150)/y,400+i*(H-150)/x,(L-150)/y,(H-150)/x);
                                        }
                                        if(chaine==5){
                                        ChargerImage("image5.jpg",400+l*L/y+l,200+k*H/x+k,200+j*L/y,200+i*H/x,L/y,H/x);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
	    }
	}
	 if(chaine==3){
		    ChargerImage("image3.png",1200,200,200,200,300,300);
                   }
                   if(chaine==4){
		     ChargerImage("image4.jpg",1200,200,1000,400,450,450);
                   }
		   if(chaine==5){
		     ChargerImage("image5.jpg",1200,200,200,200,600,600);
                   }

		   /* Touche De Droite */
		   
        if(t==XK_Right){
            if (pos_y==0){
                printf("Bordure de taquin\n");  
            }else{
                tab[pos_x][pos_y]=tab[pos_x][pos_y-1];
                tab[pos_x][pos_y-1]=0;
                pos_y=pos_y-1;
                EffacerEcran(CouleurParNom("black"));
		ChargerImageFond("image2.jpg");
		bouton(400,900,200,50,"black","white","Recommencer");
		bouton(50,50,350,50,"black","white","Retour aux tailles");
		bouton(450,50,350,50,"black","white","Retour aux images");
		bouton(850,50,350,50,"black","white","Retour a l'accueil");

                for (i=0;i<x;i++){
                    for (j=0;j<y;j++){
                        if (i!=0 || j!=0){
                            for (k=0;k<x;k++){
                                for (l=0;l<y;l++){
                                    if (tab[k][l]==i*y+j){
                                     if(chaine==3){
				       ChargerImage("image3.png",400+l*(L-300)/y+l,200+k*(H-300)/x+k,200+j*(L-300)/y,200+i*(H-300)/x,(L-300)/y,(H-300)/x);
                                        }
                                        if(chaine==4){
					  ChargerImage("image4.jpg",400+l*(L-150)/y+l,200+k*(H-150)/x+k,1000+j*(L-150)/y,400+i*(H-150)/x,(L-150)/y,(H-150)/x);
                                        }
                                        if(chaine==5){
                                        ChargerImage("image5.jpg",400+l*L/y+l,200+k*H/x+k,200+j*L/y,200+i*H/x,L/y,H/x);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
	    }
	}
	 if(chaine==3){
		    ChargerImage("image3.png",1200,200,200,200,300,300);
                   }
                   if(chaine==4){
		     ChargerImage("image4.jpg",1200,200,1000,400,450,450);
                   }
		   if(chaine==5){
		     ChargerImage("image5.jpg",1200,200,200,200,600,600);
                   }

		   /* Touche De Gauche */
		   
        if(t==XK_Left){
            if (pos_y==y-1){
                printf("Bordure de taquin\n");  
            }else{
                tab[pos_x][pos_y]=tab[pos_x][pos_y+1];
                tab[pos_x][pos_y+1]=0;
                pos_y=pos_y+1; 
                EffacerEcran(CouleurParNom("black"));
		ChargerImageFond("image2.jpg");
		bouton(400,900,200,50,"black","white","Recommencer");
		bouton(50,50,350,50,"black","white","Retour aux tailles");
		bouton(450,50,350,50,"black","white","Retour aux images");
		bouton(850,50,350,50,"black","white","Retour a l'accueil");

                for (i=0;i<x;i++){
                    for (j=0;j<y;j++){
                        if (i!=0 || j!=0){
                            for (k=0;k<x;k++){
                                for (l=0;l<y;l++){
                                    if (tab[k][l]==i*y+j){
                                       if(chaine==3){
				       ChargerImage("image3.png",400+l*(L-300)/y+l,200+k*(H-300)/x+k,200+j*(L-300)/y,200+i*(H-300)/x,(L-300)/y,(H-300)/x);
                                        }
                                        if(chaine==4){
					  ChargerImage("image4.jpg",400+l*(L-150)/y+l,200+k*(H-150)/x+k,1000+j*(L-150)/y,400+i*(H-150)/x,(L-150)/y,(H-150)/x);
                                        }
                                        if(chaine==5){
                                        ChargerImage("image5.jpg",400+l*L/y+l,200+k*H/x+k,200+j*L/y,200+i*H/x,L/y,H/x);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
	    }
	}
	 if(chaine==3){
		    ChargerImage("image3.png",1200,200,200,200,300,300);
                   }
                   if(chaine==4){
		     ChargerImage("image4.jpg",1200,200,1000,400,450,450);
                   }
		   if(chaine==5){
		     ChargerImage("image5.jpg",1200,200,200,200,600,600);
                   }

		   /* Ci-dessous vous pouvez admirer la magnifique et unique condition de sortie de la boucle amenant à la page victoire */
		   
		   flag=0;
		   for (i=0;i<x;i++){
		     for (j=0;j<y;j++){
		       if(tab[i][j]!=i*y+j){
			 flag=1;
		       }
		     }
		   }
		   if (flag==0){
		     return 5;
		   }

		   /* Pour finir, On a essayé de faire en sorte que le joueur puisse jouer à la souris mais on n'a échoué */
		   /*		   
	flag=1;
        while(flag!=0){
	if(SourisCliquee()==1 || !ToucheEnAttente()){
        SourisPosition();
        if (_X>=400 && _X<=600 && _Y>=200 && _Y<=250){
            return 4;
        }
        if (_X>=50 && _X<=100 && _Y>=50 && _Y<=100){
            return 1;
        }
        if (_X>=150 && _X<=200 && _Y>=50 && _Y<=100){
            return 2;
        }
        if (_X>=250 && _X<=300 && _Y>=50 && _Y<=100){
            return 3;
        }
	flag=0;
	}
        }*/
	flag=1;
	t=Touche();
        }
    return 2;
}

