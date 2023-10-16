# Processus, pointeur de fonction, généricité en C

#### Ex1   
Soit le [code](src/ex1.c) suivant :

```c 
#include<stdio.h>
#include<stdlib.h>

void iter(void *base,size_t n ,size_t sizeElem,void(*f)(void *))
{
	int i;
	char *ptr = (char*)base; 
	for(i=0;i<n;i++) 
		f((void*)(ptr+i*sizeElem)); 
	
	/* avec gcc, on peut faire de l'arithmétique directement 
	   avec le type void*, f(base+i*sizeElem) serait correct
	 */ 
}

int main(){
	int t1[10]={12,-7,1,-16,3,19,7,1,5,0};
	char * t2[]={"chou","joujou","bijou","genou",
		     			"caillou","hibou","pou"};

	iter(t1,10,sizeof(int),print_int);
	iter(t2,7,sizeof(char*),print_string);

	/*qsort(t1,7,sizeof(int),cmp_int);
	  qsort(t2,7,sizeof(char * ),comp_string);*/
}
```

Que fait la fonction `iter` ?

1.  Écrire les fonctions `print_int` et `print_string` pour afficher
    les deux tableaux avec `iter`.

2.  La fonction `qsort` permet de trier le tableau relativement à la
    fonction de comparaison passée en paramètre. Écrire les
    fonctions `cmp_int` et `comp_string` pour trier les tableaux `t1`
    et `t2`.

#### Ex2

Étant donné n (quelconque) f1,f2, ..., fn fonctions à valeur
void et sans paramètre, on se propose d'écrire une fonction `forkn`
réalisant la création de n processus, le i-ème fils exécutant la
fonction fi. `forkn` renverra le nombre de processus fils
effectivement créés, et rendra les pid des fils ainsi créés dans un
tableau. Une signature :

```c
int forkn(void (*tab_fonc[])(void), int nb_fils, pid_t *tab_pid);
```

`tab_fonc` est le tableau de pointeurs de fonction, `tab_pid` le
tableau qui récupére les pid des fils créés. Une utilisation
possible :

```c
#define MAX_PROC 10		
/* Nb max de fils */
int nproc;        
/* Nb effectif de fils */
int rep;		  
/* valeur de retour du forkn */
                                                    
void (*tab_fonc[MAX_PROC])(void);    
/* def. du tab de ptr sur fonctions */
pid_t tab_pid[MAX_PROC];             
/* def. tab des pid des fils */
                                                    
extern void f0(void), f1(void), ...; 

/* proto des fonctions à pointer 
   extern permet d'implanter les fonctions dans un
   autre module (.o) */
                                                    
...                                                 
tab_fonc[0] = f0; // initialisation du tableau       
tab_fonc[1] = f1;                                    
...                                                 
rep = forkn(tab_fonc, nproc, tab_pid);                
...                             
```

1.  Écrire la fonction `forkn` et tester. Les fonctions $f_i$
    pourront être écrites dans des modules séparés.

2.  Ajouter dans le père le traitement de la terminaison des ses
    fils avec `wait`.

3.  Modifier la fonction `forkn` afin que chaque fonction exécutée
    par un fils puisse être appeléé avec un argument générique (de
    type `void *`). Tester en affichant dans chaque fonction un
    message différent passé en argument.
