# Processus

#### Ex1
Compilez et exécutez [ex1-stdio.c](src/ex1-stdio.c) et [ex1-syscall.c](src/ex1-syscall.c).
Expliquez.

#### Ex2
Compilez et exécutez [fork_and_fd1.c](src/fork_and_fd1.c) et [fork_and_fd2.c](src/fork_and_fd2.c).
Expliquez.

#### Ex3
Que fait le programme [copy1byte.c](src/copy1byte.c) ?
Décommentez la ligne du `fork`. Expliquez ce qui se passe.

#### Ex4 
Ecrire un programme qui crée un processus fils.

Dans le fils :

 * imprimer le retour de `fork()`, `getpid()`, `getppid()`.
 * bloquer 4 secondes (`sleep`).
 * se terminer avec `exit(2)`.

Dans le père :

 * imprimer le retour de `fork()`, `getpid()`, `getppid()`.
 * attendre la fin de son fils (`wait()`), et imprimer son code de retour.
 * afficher alors la liste de tous les processus actifs (`execl()` avec
	`ps -ef`).


#### Ex5  

Le but de l'exercice est de détecter la présence d'un zéro dans un
tableau `unsigned char` de taille `SIZE` en découpant le travail entre
plusieurs processus. On part du programme source suivant :

```c 
#define SIZE 1000
int search(const unsigned char * t,int start,int end)
{
	/* renvoie 1 s'il y a un 0 dans la tranche du tableau, 
	 * 0 sinon */

}

int main(int argc , char * argv[])
{
	unsigned char arr[SIZE];

	srandom(time(NULL));

	for (i = 0; i < SIZE; i++)
		arr[i] = (unsigned char) (random() % 255) + 1;

	printf("Enter a number between 0 and %d: ", SIZE);
	scanf(" %d", &i);
	if (i >= 0 && i < SIZE) arr[i] = 0;

	if (search(arr,0,SIZE-1)) 
		printf("Found !\n");
	else 
		printf("Not found !\n");
	return EXIT_SUCCES;
}
```

Combien y-at-il de 0 au plus dans le tableau ? Complétez la fonction
`search`, et testez.

 1.  Première version. Modifiez le programme pour que le processus crée
	un fils. Le fils et le père cherche chacun le zéro dans une moitié
	du tableau. Le fils communique le résultat à son père. Celui-ci, à
	l'aide de son propre travail, donnera la réponse.

 2.  Deuxième version. Votre programme accepte sur la ligne de commande
	un entier n entre 1 et 100. Le programme crée n fils
	qui cherche chacun dans une partie du tableau. Le père attend la fin
	de chacun de ses fils, récupère leur résultat et affiche la réponse.

 3.  Troisième version. On améliore la version précédente. Lorsque qu'un
	fils trouve le 0 dans le tableau, et que le père en est averti,
	faites en sorte que les autres fils vivants se terminent. On
	utilisera la primitive `kill()` qui perment d'envoyer le signal de
	terminaison (`SIGTERM`) à tout un groupe.


#### Ex6  
Exécutez  le programme [session.c](src/session.c) et interprétez  avec `ps` 
les informations `pid,ppid,pgid,sess,tpgid` des processus créés. 

#### Ex7
Ecrire un programme qui pour `n>0`  donné sur la ligne de commande, engendre l'arbre généalogique :
```
0|
 |\ 1
 | \
 | |\ 2
 | | \
 | | |\ ...
 | | | \
 | | | |\ n
 x x x x x	 
```

Chaque processus choisit un nombre au hasard entre 0 et 127. Le processus 0 affichera la plus grande valeur choisie par tous 
les processus.

Remarque : on pourra modifier la séquence de nombres aléatoires en utilisant srand dans chaque processus créé. (pourquoi ?)
