#include<stdio.h>
#include<stdlib.h>
#include<time.h>

int main (void){
	int x, y, i=0 , j, flag=0;
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
	}
	int tab[x][y], alea_x, alea_y, pos_x, pos_y;
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

	char dir='0';
	while (dir!='q'){
		printf("Entrez une direction h,b,d,g pour deplacer les pièces du taquin (q pour quitter) : ");
		scanf("%c",&dir);
		printf("\n");
		if (dir=='h'){
			if (pos_x==x-1){
				printf("Bordure de taquin\n");	
			}else{
				tab[pos_x][pos_y]=tab[pos_x+1][pos_y];
				tab[pos_x+1][pos_y]=0;
				pos_x=pos_x+1;
			}
			for (i=0;i<x;i++){
				for (j=0;j<y;j++){
					printf("%2d ",tab[i][j]);
				}
				printf("\n");
			}
		}
		if (dir=='b'){
			if (pos_x==0){
				printf("Bordure de taquin\n");	
			}else{
				tab[pos_x][pos_y]=tab[pos_x-1][pos_y];
				tab[pos_x-1][pos_y]=0;
				pos_x=pos_x-1;
			}
			for (i=0;i<x;i++){
				for (j=0;j<y;j++){
					printf("%2d ",tab[i][j]);
				}
				printf("\n");
			}
		}
		if (dir=='g'){
			if (pos_y==0){
				printf("Bordure de taquin\n");	
			}else{
				tab[pos_x][pos_y]=tab[pos_x][pos_y-1];
				tab[pos_x][pos_y-1]=0;
				pos_y=pos_y-1;
			}
			for (i=0;i<x;i++){
				for (j=0;j<y;j++){
					printf("%2d ",tab[i][j]);
				}
				printf("\n");
			}
		}
		if (dir=='d'){
			if (pos_y==y-1){
				printf("Bordure de taquin\n");	
			}else{
				tab[pos_x][pos_y]=tab[pos_x][pos_y+1];
				tab[pos_x][pos_y+1]=0;
				pos_y=pos_y+1;
			}
			for (i=0;i<x;i++){
				for (j=0;j<y;j++){
					printf("%2d ",tab[i][j]);
				}
				printf("\n");
			}
			if (tab[pos_x][pos_y]==tab[0][0]){
				flag=0;
				for (i=0;i<x*y;i++){
					if (i!=tab[x][y]){
						flag=1;
					}
				}
			}
			if (flag==1){
				printf("You win\n");
				dir='q';
			}
		}
	}
}
