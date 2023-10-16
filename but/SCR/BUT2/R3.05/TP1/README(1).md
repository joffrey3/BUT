# TP1 : Mémoire


#### Ex1
Soit le [programme](./src/adresses_virtuelles.c) suivant qui affiche les adresses virtuelles de certaines variables lors de l'exécution du  processus correspondant :
```c
/* adresses virtuelles d'un processus */

#include<stdio.h>
#include<sys/types.h>
#include<unistd.h>
#include<stdlib.h>

int t[1000] = {[0 ... 999] = 2};

int main(int argc, char * argv[])
{
	int i=3;
	static int j = 3;
	char * m = (char*)malloc(1);
	printf("je suis le pid %d\n\n",getpid());
	/* ------- Affichage des adresses --------*/
	printf("main\t=\t%p\n",main);
	printf("&argc\t=\t%p\n",&argc);
	printf("&i\t=\t%p\n",&i);
	printf("&j\t=\t%p\n",&j);
	printf("t\t=\t%p\n",t);
	printf("m\t=\t%p\n",m);

	getchar();
}  
```

En utilisant le (pseudo) fichier `/proc/pid/maps`, vérifiez à quel segment de pages ces adresses appartiennent.   

#### Ex2
Soit le [programme](./src/bss_data.c) suivant :
```c
/* segment bss et data */
#define N 10000
int t[N]; /* version 1 */
//int t[N]={1}; /* version 2 */

int main()
{
	return 0;
}
```

  1. Compilez le programme. Avec la commande `size`, regardez les différents segments du programme. Où se trouve le tableau `t` ?   Augmentez la valeur de N. La taille de l'exécutable a-t-elle changé ? pourquoi ?
  2. Recommencez avec la version 2. Expliquez.

#### Ex3
Soit le [programme](./src/ij_ji.c) suivant :   

```c
/* accès mémoire */
#include<stdio.h>
#include<time.h>
#include <stdlib.h>
#define N 8192 

int t[N][N];

static inline double tstamp(void) 
{                             
	struct timespec tv;
	clock_gettime(CLOCK_REALTIME, &tv);
	return tv.tv_sec + tv.tv_nsec * 1.0e-9;
}

int main()
{
	int i,j;
	double t1,t2;
	t1=tstamp();
	/* version 1 */     for(i=0;i<N;i++) for(j=0;j<N;j++) t[i][j] = 1;  
	/* version 2 */ //  for(i=0;i<N;i++) for(j=0;j<N;j++) t[j][i] = 1;  
	t2=tstamp();
	printf("time = %lf\n",t2-t1);
	return 0;
}
```

Le temps d'exécution est-il différent pour les deux versions ? Pourquoi ?    

#### Ex4  
Le programme [sum_array.c](./src/sum_array.c) fait la somme des éléments d'un tableau en  accédant aux éléments séquentiellement (`-c` croissant, `-d` décroissant) ou de manière aléatoire (`-a`).   
Testez en faisant varier la taille du tableau. Expliquez.   

#### Ex5 
Ecrire une fonction  
```c
void hexdump(void * ptr,size_t size);   
```

qui affiche sur la sortie standard le contenu de la mémoire `[ptr,ptr+size[` au format :  

```
XXXXXXXX  BB BB BB BB BB BB BB BB  BB BB BB BB BB BB BB BB  |CCCCCCCCCCCCCCCC|
```

(comme la commande shell)   

  - `XXXXXXXXX` représente l'adresse du premier octet de la ligne
  - `BB` la valeur hexadécimale de chaque octet
  - `|CCCCCCCCCCCCCCCC|` la correspondance ascii de chaque octet (`.` si non affichable)  

Testez avec les objets suivants et expliquez :   
```c
/* alignement et objets */
struct exemple1 {
	int x;
	int y;
	int z;
	int w;
};

struct exemple2 {
	char x;
	char y;
	char z;
	char w;
};

struct exemple3 {
	int x;
	int y;
	char z;
	char w;
};

struct exemple4 {
	int x;
	char y;
	int z;
	char w;
};

union exemple5 {
	int x;
	char y;
	int z;
	char w;
};

int main()
{
	int a[4] = {1,2,3,4};
	char c[4] = {'a','b','c','d'};
	struct exemple1 ex1 = {1,2,3,4}; 
	struct exemple2 ex2 = {'a','b','c','d'}; 
	struct exemple3 ex3 = {1,2,'c','d'}; 
	struct exemple4 ex4 = {1,'c',2,'d'}; 
	union exemple5 ex5; 
	int x = 61;
	char y = 62;
	int z = 63;
	char w = 64;
	ex5.x=62;ex5.y=63;ex5.z=64;ex5.w=65;

	// appelez hexdump pour chaque variable
	

	return 0;
}
```
 
Est-ce conforme à ce que l'on a vu en cours concernant l'alignement en mémoire ?    

#### Ex6
Dans le dossier [memoire](src/memoire), vous trouverez un programme qui permet de simuler 
des  remplacement de pages en mémoire. 
  1. Implanter la méthode FIFO : par exemple, avec 4 frames et la demande 4,5,6,8,4,9,6,12,4,6,10, vous devez obtenir la sortie suivante 

     ```
	 [denis@portabledenis memoire]$ ./main
	 ------------------------------------------------------------------------------
	 |temps    |    0 |   1 |   2 |   3 |   4 |   5 |   6 |   7 |   8 |   9 |  10 |
	 ------------------------------------------------------------------------------
	 |page     |    4 |   5 |   6 |   8 |   4 |   9 |   6 |  12 |   4 |   6 |  10 |
	 ------------------------------------------------------------------------------
	 |frame   0|    4 |   4 |   4 |   4 |   4 |   9 |   9 |   9 |   9 |   9 |  10 |
	 ------------------------------------------------------------------------------
	 |frame   1|    X |   5 |   5 |   5 |   5 |   5 |   5 |  12 |  12 |  12 |  12 |
	 ------------------------------------------------------------------------------
	 |frame   2|    X |   X |   6 |   6 |   6 |   6 |   6 |   6 |   4 |   4 |   4 |
	 ------------------------------------------------------------------------------
	 |frame   3|    X |   X |   X |   8 |   8 |   8 |   8 |   8 |   8 |   6 |   6 |
	 ------------------------------------------------------------------------------
	 |default  |    1 |   1 |   1 |   1 |   0 |   1 |   0 |   1 |   1 |   1 |   1 |
	 ------------------------------------------------------------------------------
	 ```
  2. Implanter la méthode de la seconde chance, amélioration de FIFO.
   On ajoute à chaque  page en mémoire un bit, de manière à leur donner une seconde chance avant de les enlever.   
   
     - à chaque fois qu'une page est accédée (sans défaut), son bit est mis à un. 
     - en cas de défaut, on cherche la victime comme pour la méthode FIFO. Si la page la plus ancienne
       à son bit à 0 (elle n'a pas été accèdée), elle est remplacée. Sinon, on lui laisse une chance (elle
       est vieille, mais encore utilisée). On repasse sont bit à 0, et on la met en fin de file. On regarde 
       la page suivante.

     Par exemple, avec 3 frames et la demande 0, 4, 1, 4, 2, 4, 3, 4, 2, 4, 0, 4, 1, 4, 2, 4, 3, 4, votre programme
     doit afficher la sortie suivante :

	 ```
	 [denis@portabledenis memoire]$ ./main 
	 ------------------------------------------------------------------------------------------------------------------------
	 |temps    |    0 |   1 |   2 |   3 |   4 |   5 |   6 |   7 |   8 |   9 |  10 |  11 |  12 |  13 |  14 |  15 |  16 |  17 |
	 ------------------------------------------------------------------------------------------------------------------------
	 |page     |    0 |   4 |   1 |   4 |   2 |   4 |   3 |   4 |   2 |   4 |   0 |   4 |   1 |   4 |   2 |   4 |   3 |   4 |
	 ------------------------------------------------------------------------------------------------------------------------
	 |frame   0|    0 |   0 |   0 |   0 |   2 |   2 |   2 |   2 |   2 |   2 |   2 |   2 |   1 |   1 |   1 |   1 |   3 |   3 |
	 ------------------------------------------------------------------------------------------------------------------------
	 |frame   1|    X |   4 |   4 |   4 |   4 |   4 |   4 |   4 |   4 |   4 |   4 |   4 |   4 |   4 |   4 |   4 |   4 |   4 |
	 ------------------------------------------------------------------------------------------------------------------------
	 |frame   2|    X |   X |   1 |   1 |   1 |   1 |   3 |   3 |   3 |   3 |   0 |   0 |   0 |   0 |   2 |   2 |   2 |   2 |
	 ------------------------------------------------------------------------------------------------------------------------
	 |default  |    1 |   1 |   1 |   0 |   1 |   0 |   1 |   0 |   0 |   0 |   1 |   0 |   1 |   0 |   1 |   0 |   1 |   0 |
	 ------------------------------------------------------------------------------------------------------------------------
     ```
