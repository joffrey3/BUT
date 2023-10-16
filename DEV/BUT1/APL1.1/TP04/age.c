#include <stdio.h> 
#include <stdlib.h>
int main (void){
int jour_actuel, mois_actuel, annee_actuel,jour_naissance, mois_naissance, annee_naissance, age;
printf("Quelle est la date d'aujourd'hui ? \n");
scanf("%d/%d/%d", &jour_actuel, &mois_actuel, &annee_actuel);
printf("Quelle est votre date d'anniversaire ? \n");
scanf("%d/%d/%d", &jour_naissance, &mois_naissance, &annee_naissance);
age =annee_actuel-annee_naissance;
if (mois_actuel<mois_naissance){
	age = age-1;
}
if (mois_actuel==mois_naissance){
	if (jour_actuel<jour_naissance){
		age = age-1;
}
}
printf("Votre age est : %d\n",age);
}
