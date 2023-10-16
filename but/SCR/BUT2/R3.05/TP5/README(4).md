# Redirections, tubes 
#### Ex1

1. Écrire un programme C pour calculer la taille du tampon système
    associé à un tube. (on pourra rendre l'écriture non bloquante avec
    `fcntl`)

2.  Écrire un programme C qui a le même comportement que la commande
    shell

    ```bash
    ls -i -l /tmp >> log
    ```

3.  Écrire un programme C qui a le même comportement que la commande
    shell

    ```bash
    ls . | wc -l
    ```
#### Ex2
Soit le graphe de processus suivant (un tube est établi entre Pf2 et
Pf1f1)

```bash
	| P
	|____
	|    \  Pf1  
	|     \
	|      \
	|\Pf2  |\
	| \    | \Pf1f1
	|  \   |  \
	O   O  O   O
	    ()-->--()
```

1.  Ecrivez un programme pipe-ex.c qui implante le graphe ci-dessus
    (y compris le tube) et tel que :  
    -   Pf2 écrive en permanence toutes les 3 secondes son PID dans
        le tube en affichant ce qu'il écrit
    -   Pf1f1 lise en permanence chaque seconde depuis tube
        `sizeof(pid_t)` en affichant ce qu'il lit

    Vérifiez que le programme fonctionne comme prévu, i.e il affiche
    :

    ```bash
    16411 sent 16411
    	16412 received 16411
    16411 sent 16411
    	16412 received 16411
    .....

    ```

2.  Lancez le programme ci-dessus et faites les essais suivants
    (relancez le programme après chaque essai). Expliquez à chaque
    fois vos observations.
    1.  Envoyez le signal `SIGSTOP` à Pf2, puis le signal SIGCONT à
        Pf2.
    2.  Envoyez le signal `SIGSTOP` à Pf1f1, puis le signal SIGCONT à
        Pf1f1.
    3.  Envoyez le signal `SIGTERM` à Pf2.
    4.  Envoyez le signal `SIGTERM` à Pf1f1.  
3.  Modifiez le programme pipe-ex.c en assurant que tous les
    processus ferment les descripteurs du tube non utilisés. Faites
    les mêmes essais que ci-dessus et expliquez ce que vous
    observez.
4.  Modifiez encore une fois le programme pipe-ex.c pour que les
    deux processus Pf1, Pf2 écrivent dans le tube simultanement et
    que seul Pf1f1 le lise. Qu'observez-vous ?

#### Ex3
Voici un programme qui calcule le nième terme de la suite de Fibonacci de 
manière récursive (ce n'est pas la meilleure approche comme vous le savez).

```c
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <assert.h>
long int fibo (long int n)
{
	return (n<=1)?n:fibo(n-1)+fibo(n-2);
}



int main(int argc, char *argv[])
{
	long int n;
	assert(argc > 1);
	n=strtol(argv[1],NULL,0);
	printf("fibo(%ld) = %ld\n",n,fibo(n));
	return 0;
}
```

L'arbre d'appel correspondant pour n=4 :

```bash
                       fibo(4)
                       /     \
                      /	      \
                fibo(2)        fibo(3)
               /     \        /     \
              /	      \      /       \
        fibo(0)    fibo(1) fibo(1) fibo(2)  
                                   /	\
                                  /      \ 
                             fibo(0)	fibo(1)
```

Modifiez le programme pour qu'il crée 2 fils. Le premier calculera fibo(n-2), le deuxième fibo(n-1). 
Le père récupérera les résultats et les additionnera. La communication sera assurée par des tubes.



#### Ex4
Le but est de mettre en oeuvre le cribble d'Ératosthène à l'aide d'une chaîne de processus reliés entre eux par des pipes. 

- un premier processus `P` crée un fils avec qui il est relié par un tube, et qui génére  l'ensemble des nombres entre 2 et `N` (passé à la ligne de commande.
- Lorsqu'un nombre n'a pas été cribblé par les différents filtres,  et arrive jusqu'à `P`, il est premier, et `P` crée un nouveau filtre.


```bash
┌────────┐
│   P    │
└────────┘

┌────────┐     ──────     ┌────────┐
│seq 2 N ├───►()    ()───►│   P    │
└────────┘     ──────     └────────┘

┌────────┐     ──────     ┌────────┐     ──────     ┌────────┐
│seq 2 N ├───►()    ()───►│   F2   ├───►()    ()───►│   P    │
└────────┘     ──────     └────────┘     ──────     └────────┘

┌────────┐     ──────     ┌────────┐     ──────     ┌────────┐     ──────     ┌────────┐
│seq 2 N ├───►()    ()───►│   F2   ├───►()    ()───►│   F3   ├───►()    ()───►│   P    │
└────────┘     ──────     └────────┘     ──────     └────────┘     ──────     └────────┘

┌────────┐     ──────     ┌────────┐     ──────     ┌────────┐     ──────     ┌────────┐     ──────     ┌────────┐
│seq 2 N ├───►()    ()───►│   F2   ├───►()    ()───►│   F3   ├───►()    ()───►│   F5   ├───►()    ()───►│   P    │
└────────┘     ──────     └────────┘     ──────     └────────┘     ──────     └────────┘     ──────     └────────┘
```

Écrire un programme correspondant à ce schéma

#### Ex5
Le but est d'implanter une architecture client/serveur en utilisant des tubes nommés. (Il existe pour cela
un autre mécanisme dédié à la communication locale interprocessus avec les sockets)

```
             +-------------+  
+----------> | clt1 pipe   | --------------------------+
|            +-------------+                           |
|                                                      |
|                                       +-- client1 <--+
|                                       |
|                                       |
|                     +-------------+ <-+
+-- serveur <-------- | serveur pipe| <---- client2 <-------+
|                     +-------------+ <-+                   |
|                                       |                   |
|                                       |                   |
|                                       +-- client3 <---+   |
|            +-------------+                            |   |
+----------> | clt3 pipe   | ---------------------------+   |
|            +-------------+                                |
|                                                           |
|            +-------------+                                |
+----------> | clt2 pipe   | -------------------------------+
             +-------------+
 ```


**Le serveur**  
Il permet de consulter les notes d'étudiants à un examen d'ASR. 
Il récupére en boucle les requêtes des clients dans un tube nommé `srv.pipe`. Pour écouter en boucle 
les demandes des clients (lecture bloquante), le serveur ouvre le tube en mode lecture/écriture (il y a toujours
un écrivain, même lorsqu'on n'a plus  aucun client). 

Chaque requête est composée  :
 - du pid du client
 - du numéro de l'étudiant dont on veut la note.


Pour chaque requête, le serveur crée un fils qui renvoie la note de l'étudiant correspondant à la requête, en utlisant
le tube nommé `/tmp/clt.pid`. On prendra soin de traiter correctement le signal `SIGCHLD`.

**Le client**
 - Il crée le tube nommé pour la réponse à sa requête.
 - Il envoie sa requête dans le tube `srv.pipe`.
 - Il récupère la réponse du serveur dans son tube nommé, et le détruit.


