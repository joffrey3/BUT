#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#include<graph.h>
#include<string.h>

/*On définit des fonctions qui nous servirons plus tard*/

int execution(int pos_p1,int p1,int*binaire,int(*)[64]);

int instruction(int pos_p1,int p1,int* binaire,int pos_A,int pos_B,int(*)[64]);

int caractere_special(int pos_p1,int p1,int* binaire,int pos,int rec, int(*)[64]);

int main(void){
	/* On commence par ouvrir les fichiers en forme pour trouver le nombre de lignes */
  int tab[8000],tab4[8000][64], i=0,j=1,p1=400,p2=200,pos_p1,pos_p2,ligne_pointeur1,colonne_pointeur1,endroit_pointeur1,ligne_pointeur2,colonne_pointeur2,endroit_pointeur2,nb_combat,victoire_p1=0,victoire_p2=0;
	char* couleur1="blue",* couleur2="green";
	FILE* commande ,* commande2;
	char indic[20];
	commande = fopen("commande","r");
  	if (commande==NULL){
     	printf("Accès au fichier non possible\n");
     	return EXIT_SUCCESS;
  	}
	while(!feof(commande)){
		fgets(indic,20,commande);
		p1=p1+1;
	}
	commande2 = fopen("commande2","r");
  	if (commande2==NULL){
     	printf("Accès au fichier non possible\n");
     	return EXIT_SUCCESS;
  	}
	while(!feof(commande2)){
		fgets(indic,20,commande2);
		p2=p2+1;
		}
	fclose(commande);
	fclose(commande2);
	for(i=0;i<8000;i++){
	  tab[i]=0;
	}
	for(i=0;i<8000;i++){
		for(j=0;j<64;j++){
	  	tab4[i][j]=0;
		}
	}

	/*On initialise la partie graphique*/
	InitialiserGraphique();
	CreerFenetre(0,0,1920,1080);
	for(nb_combat=1;nb_combat<=100;nb_combat++){
		ChoisirCouleurDessin(CouleurParNom("white"));
		RemplirRectangle(0,0,8000,8000);
		ChoisirCouleurDessin(CouleurParNom("black"));
	for(i=0;i<8000;i++){
		DessinerRectangle(i%100*10,i/100*10,10,10);
	}
	srand(time(NULL));
	pos_p1=rand()%8000;
	pos_p2=rand()%8000;
	for(;(pos_p2+p2)%8000>=pos_p1 && pos_p2<=(pos_p1+p1)%8000;){
	  pos_p2=rand()%8000;
	  }
	for(i=0;i<=p1;i++){
	  ChoisirCouleurDessin(CouleurParNom(couleur1));
	  if(pos_p1%100*10+i*10<1000){
	    RemplirRectangle(pos_p1%100*10+i*10,pos_p1/100*10,10,10);
		tab[pos_p1+i]=1;
	  }else{
	    j=(pos_p1%100+i)/100;
	  	if(pos_p1/100*10+j*10<800){
	    	RemplirRectangle(pos_p1%100*10+i*10-1000*j,pos_p1/100*10+10*j,10,10);
	    	tab[pos_p1+i]=1;
	  	}
	  	else{
	  		RemplirRectangle(pos_p1%100*10+i*10-1000*j,pos_p1/100*10+10*j-800,10,10);
	  		tab[pos_p1+i-8000]=1;
	  	}
	  }
	}
	for(i=0;i<=p2;i++){
	  ChoisirCouleurDessin(CouleurParNom(couleur2));
	  if(pos_p2%100*10+i*10<1000){
	    RemplirRectangle(pos_p2%100*10+i*10,pos_p2/100*10,10,10);
		tab[pos_p2+i]=1;
	  }else{
	    j=(pos_p2%100+i)/100;
	  	if(pos_p2/100*10+j*10<800){
	    	RemplirRectangle(pos_p2%100*10+i*10-1000*j,pos_p2/100*10+10*j,10,10);
	    	tab[pos_p2+i]=1;
	  	}
	  	else{
	  		RemplirRectangle(pos_p2%100*10+i*10-1000*j,pos_p2/100*10+10*j-800,10,10);
	  		tab[pos_p2+i-8000]=1;
	  	}
	  }
	}
	  colonne_pointeur1=pos_p1%100*10;
	  ligne_pointeur1=pos_p1/100*10;
	  colonne_pointeur2=pos_p2%100*10;
	  ligne_pointeur2=pos_p2/100*10;
	  ChoisirCouleurDessin(CouleurParNom("black"));
	  EcrireTexte(colonne_pointeur1,ligne_pointeur1+9,"x",0);
	  EcrireTexte(colonne_pointeur2,ligne_pointeur2+9,"x",0);
	  endroit_pointeur1=ligne_pointeur1/10*100+colonne_pointeur1/10;
	  endroit_pointeur2=ligne_pointeur2/10*100+colonne_pointeur2/10;
	  while(tab[endroit_pointeur1]!=0 && tab[endroit_pointeur2]!=0 ){
	  	ChoisirCouleurDessin(CouleurParNom(couleur1));
	  	RemplirRectangle(endroit_pointeur1%100*10,endroit_pointeur1/100*10,10,10);
	  	ChoisirCouleurDessin(CouleurParNom(couleur2));
	  	RemplirRectangle(endroit_pointeur2%100*10,endroit_pointeur2/100*10,10,10);
	  	if (endroit_pointeur1!=7999){
	    	endroit_pointeur1=endroit_pointeur1+1;
		}else{
			endroit_pointeur1=0;
		}
	  	if (endroit_pointeur2!=7999){
	    	endroit_pointeur2=endroit_pointeur2+1;
		}else{
			endroit_pointeur2=0;
		}
		ChoisirCouleurDessin(CouleurParNom("black"));
	    EcrireTexte(endroit_pointeur1%100*10+2.5,endroit_pointeur1/100*10+9,"x",0);
	    EcrireTexte(endroit_pointeur2%100*10+2.5,endroit_pointeur2/100*10+9,"x",0);
	  }
	  if (tab[endroit_pointeur1]==1){
	  	victoire_p1=victoire_p1+1;
	  }
	  if (tab[endroit_pointeur2]==1){
	  	victoire_p2=victoire_p2+1;
	  }
	  EcrireTexte(1200,100,"Nombre de combats : ",2);
	  ChoisirCouleurDessin(CouleurParNom(couleur1));
	  EcrireTexte(1050,150,"Victoires du programme 1 : ",1);
	  RemplirRectangle(1350-(victoire_p1*300/nb_combat+1),200,victoire_p1*300/nb_combat+1,50);
	  ChoisirCouleurDessin(CouleurParNom(couleur2));
	  EcrireTexte(1400,150,"Victoires du programme 2 : ",1);
	  RemplirRectangle(1350,200,victoire_p2*300/nb_combat+1,50);
	  ChoisirCouleurDessin(CouleurParNom("black"));
	  EcrireTexte(1200,300,"Nombre de tour : ",2);
	  ChoisirCouleurDessin(CouleurParNom(couleur1));
	  EcrireTexte(1050,350,"Tours du programme 1 : ",1);
	  RemplirRectangle(1350-(victoire_p1*300/nb_combat+1),400,victoire_p1*300/nb_combat+1,50);
	  ChoisirCouleurDessin(CouleurParNom(couleur2));
	  EcrireTexte(1400,350,"Tours du programme 2 : ",1);
	  RemplirRectangle(1350,400,victoire_p2*300/nb_combat+1,50);
	  ChoisirCouleurDessin(CouleurParNom("black"));
	  EcrireTexte(1200,500,"Nombre de cases : ",2);
	  ChoisirCouleurDessin(CouleurParNom(couleur1));
	  EcrireTexte(1050,550,"Cases du programme 1 : ",1);
	  RemplirRectangle(1350-(p1/2/nb_combat+1),600,p1/2/nb_combat+1,50);
	  ChoisirCouleurDessin(CouleurParNom(couleur2));
	  EcrireTexte(1400,550,"Cases du programme 2 : ",1);
	  RemplirRectangle(1350,600,p2/2/nb_combat+1,50);
	  Touche();
	}
	FermerGraphique();
	/* On réouvre les fichiers pour pouvoir sortir les informations*/
 	FILE* registre;

	commande = fopen("commande","r");
  	if (commande==NULL){
     	printf("Accès au fichier non possible\n");
     	return EXIT_SUCCESS;
  	}
	commande2 = fopen("commande2","r");
  	if (commande2==NULL){
     	printf("Accès au fichier non possible\n");
     	return EXIT_SUCCESS;
  	}
	registre = fopen("registre","w");
	while(!feof(commande)){
/* On commence avec les commandes/instructions*/
		fgets(indic,20,commande);
	char* chiffre="0123456789 ";
	char texte[4],binarite[1];
	int nb_A=0,nb_B=0, i2=0, i3, nb_chiffre[2]={0,0},tab2[28],tab3[28],binaire[64],inverse_A=0,inverse_B=0,nb_ligne;
	if(nb_ligne<=p1){
	texte[0]=indic[0];
	texte[1]=indic[1];
	texte[2]=indic[2];
	if(strcmp(texte,"MOV")==0){
		binaire[0]=0;
		binaire[1]=0;
		binaire[2]=0;
		binaire[3]=1;
	}
	if(strcmp(texte,"ADD")==0){
		binaire[0]=0;
		binaire[1]=0;
		binaire[2]=1;
		binaire[3]=0;
	}
	if(strcmp(texte,"SUB")==0){
		binaire[0]=0;
		binaire[1]=0;
		binaire[2]=1;
		binaire[3]=1;
	}
	if(strcmp(texte,"JMP")==0){
		binaire[0]=0;
		binaire[1]=1;
		binaire[2]=0;
		binaire[3]=0;
	}
	if(strcmp(texte,"JMZ")==0){
		binaire[0]=0;
		binaire[1]=1;
		binaire[2]=0;
		binaire[3]=1;
	}
	if(strcmp(texte,"JMG")==0){
		binaire[0]=0;
		binaire[1]=1;
		binaire[2]=1;
		binaire[3]=0;
	}
	if(strcmp(texte,"DJZ")==0){
		binaire[0]=0;
		binaire[1]=1;
		binaire[2]=1;
		binaire[3]=1;
	}
	if(strcmp(texte,"CMP")==0){
		binaire[0]=1;
		binaire[1]=0;
		binaire[2]=0;
		binaire[3]=0;
	}
	if(strcmp(texte,"DAT")==0){
		binaire[0]=0;
		binaire[1]=0;
		binaire[2]=0;
		binaire[3]=0;
	}
/*On transforme les entiers qui sont en chaine de charactères en binaire qu'ils soient positifs ou negatifs*/
		for(;indic[i2+5]!=' ';i2++){
			for(i3=0;chiffre[i3]!=' ';i3++){
				if (indic[5]=='-'){
					inverse_A=1;
				}
				if (indic[5+i2]==chiffre[i3]){
					nb_A=nb_A*10+i3;
				}
			}
		}
		nb_chiffre[0]=i2;
		for(;indic[i2+7]!=' ';i2++){
			for(i3=0;chiffre[i3]!=' ';i3++){
				if (indic[7+i2]=='-'){
					inverse_B=1;
				}			
				if (indic[5+2+i2]==chiffre[i3]){
					nb_B=nb_B*10+i3;
				}
			}
		}
		nb_chiffre[1]=i2-nb_chiffre[0];
	if (inverse_A==1){
		nb_A=-nb_A;
	}
	if (inverse_B==1){
		nb_B=-nb_B;
	}
	for(;nb_A>=8000 ||  nb_A<0;){
		if(nb_A>=8000){
			nb_A=nb_A-8000;

		}
		if(nb_A<0){
			nb_A=nb_A+8000;
		}
	}
	for(;nb_B>=8000 ||  nb_B<0;){
		if(nb_B>=8000){
			nb_B=nb_B-8000;
		}
		if(nb_B<0){
			nb_B=nb_B+8000;
		}
	}
	/*On transforme en entier les charactères spéciaux*/
	if(indic[4]=='#'){
		binaire[4]=0;
		binaire[5]=0;
	}
	if(indic[4]==' '){
		binaire[4]=0;
		binaire[5]=1;
	}
	if(indic[4]=='@'){
		binaire[4]=1;
		binaire[5]=0;
	}
	if(indic[6+nb_chiffre[0]]=='#'){
		binaire[6]=0;
		binaire[7]=0;
	}
	if(indic[6+nb_chiffre[0]]==' '){
		binaire[6]=0;
		binaire[7]=1;
	}
	if(indic[6+nb_chiffre[0]]=='@'){
		binaire[6]=1;
		binaire[7]=0;
	}
	/*On boucle sur 28 nombres les entiers jusqu'a 8000*/
	if(nb_A!=0){
		for(i=0;nb_A!=1;i++){
			tab2[i]=nb_A%2;
			nb_A=nb_A/2;
		}
		tab2[i]=1;
	}
	if(nb_B!=0){
		for(i=0;nb_B!=1;i++){
			tab3[i]=nb_B%2;
			nb_B=nb_B/2;
		}
		tab3[i]=1;
	}
	for(i=0;i<28;i++){
		binaire[i+8]=tab2[27-i];
	}
	for(i=0;i<28;i++){
		binaire[i+36]=tab3[27-i];
	}
	for(i=0;i<64;i++){
		if(binaire[i]==0){
			binarite[0]=chiffre[0];
			fwrite(binarite,sizeof(char),1,registre);
		}
		if(binaire[i]==1){
			binarite[0]=chiffre[1];
			fwrite(binarite,sizeof(char),1,registre);
		}
	}
	binarite[0]='\n';
	fwrite(binarite,sizeof(char),1,registre);
	nb_ligne=nb_ligne+1;
	for(i=0;i<64;i++){
		tab4[(pos_p1+p1)%8000][i]=binaire[i];
	}
	printf("\n");
}
}
/*On ferme les dossiers et on tente de relier les deux programmes par l'execution*/
printf("\n");
	fclose(commande);
	fclose(commande2);
  fclose(registre);

  /*int flag=1,sortie1,sortie2,binaire[64];
  for(;flag!=0;){
  	for (i=0;i<64;i++){
  	binaire[i]=tab4[(pos_p1+p1)%8000][i];
  }
  	sortie1=execution(pos_p1,p1,binaire,tab4);
  	sortie2=execution(pos_p2,p2,binaire,tab4);
  	if(sortie1==0){
  		flag=0;
  	}
		if(sortie2==0){
  		flag=0;
  	}
}*/
  	return EXIT_SUCCESS;
}

int execution(int pos_p1,int p1,int* binaire,int*tab4){
	int pos_A=0, pos_B=0,pos_ind,i;
	printf("%d",pos_A);
	printf("\n");
	printf("%d",pos_B);
	printf("\n");
	instruction(pos_p1,p1,binaire,pos_A,pos_B,tab4);
	return 0;
}

int instruction(int pos_p1,int p1,int* binaire,int pos_A,int pos_B,int*tab4){
	pos_A=caractere_special(pos_p1,p1,binaire,pos_A,0,tab4);
	pos_B=caractere_special(pos_p1,p1,binaire,pos_B,2,tab4);
	if (binaire[0]==0 && binaire[1]==0 && binaire[2]==0 && binaire[3]==1){
		tab4[pos_B]=tab4[pos_A];
		return tab4[pos_B];
	}
	if (binaire[0]==0 && binaire[1]==0 && binaire[2]==1 && binaire[3]==0){
 		tab4[pos_B]=tab4[pos_B]+tab4[pos_A];
		return tab4[pos_B];
 	}
	if (binaire[0]==0 && binaire[1]==0 && binaire[2]==1 && binaire[3]==1){
 		tab4[pos_B]=tab4[pos_B]-tab4[pos_A];
		return tab4[pos_B];
	}
	if (binaire[0]==0 && binaire[1]==1 && binaire[2]==0 && binaire[3]==0){
 		tab4[pos_B]=tab4[pos_B]-tab4[pos_A];
		return tab4[pos_B];
	}
	if (binaire[0]==0 && binaire[1]==1 && binaire[2]==0 && binaire[3]==1){
		int cursor;
 		cursor=tab4[pos_A];
 		return cursor;
	}
	if (binaire[0]==0 && binaire[1]==1 && binaire[2]==1 && binaire[3]==0){
		int cursor;
		if(pos_B!=0){
 			cursor=tab4[pos_A];
 		}
 		return cursor;
	}
	if (binaire[0]==0 && binaire[1]==1 && binaire[2]==1 && binaire[3]==1){
		int cursor;
 		if(pos_B==0){
 			cursor=tab4[pos_A];
 		}
 		return cursor;
	}
	if (binaire[0]==1 && binaire[1]==0 && binaire[2]==0 && binaire[3]==0){
 	
	}
	if (binaire[0]==0 && binaire[1]==0 && binaire[2]==0 && binaire[3]==0){
 	
	}
}

int caractere_special(int pos_p1,int p1,int* binaire,int pos,int rec,int*tab4){
	int i,ind;
	if (binaire[4+rec]==0 && binaire[5+rec]==0){
		for(i=8+rec*14;i<=35+rec*14;i++){
			pos=pos*2+binaire[i];
		}
		return pos;
	}
	if (binaire[4+rec]==0 && binaire[5+rec]==1){
		for(i=8+rec*14;i<=35+rec*14;i++){
			pos=pos*2+binaire[i];
		}
 		return pos+pos_p1+p1;
 	}
	if (binaire[4+rec]==1 && binaire[5+rec]==0){
		for(i=8+rec*14;i<=35+rec*14;i++){
			ind=ind*2+binaire[i];
		}
		binaire=tab4[pos_p1+p1];
		for(i=8+rec*14;i<=35+rec*14;i++){
			pos=pos*2+binaire[i];
		}
 		return pos;
	}
}*/