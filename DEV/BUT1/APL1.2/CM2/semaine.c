# include <stdio.h>
# include <stdlib.h>
# include <string.h>

int main(int argc, char const *argv[])
{
	int i,k;
	char chaine[9];
	char nombre[10]={'0','1','2','3','4','5','6','7','8','9'};
	double val;
	printf("Entrez une date : ");
	fgets(chaine,9,stdin);
	char j[2];
	j[0]=chaine[0];
	j[1]=chaine[1];
	char m[2];
	m[0]=chaine[3];
	m[1]=chaine[4];
	char a[2];
	a[0]=chaine[6];
	a[1]=chaine[7];
	int jour=0;
	int mois=0;
	int annee=20;
	for(i=0;i<2;i++){
		for(k=0;k<10;k++){
			if(j[i]==nombre[k]){
				jour=10*jour+k;
			}
		}
	}
	for(i=0;i<2;i++){
		for(k=0;k<10;k++){
			if(m[i]==nombre[k]){
				mois=10*mois+k;
			}
		}
	}
	for(i=0;i<2;i++){
			for(k=0;k<10;k++){
			if(a[i]==nombre[k]){
				annee=10*annee+k;
			}
		}
	}
	int total=annee*365+jour;
	for(;mois-1>0;mois=mois-1){
		if (mois==1 || mois==3 || mois==5 || mois==7 || mois==8 || mois==10){
			total =total+31;
		}
		if (mois==4 || mois==6 || mois==9 || mois==11){
			total =total+30;
		}
		if (mois==2){
			total =total+28;
		}
	}
	total=(total-2)%7;
	char* semaine[7]={"lundi","mardi","mercredi","jeudi","vendredi","samedi","dimanche"};
	printf(" c'est un %s\n",semaine[total]);
}