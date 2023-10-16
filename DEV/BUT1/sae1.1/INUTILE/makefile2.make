page.out : page.o new_page_accueil.o new_page_image.o new_page_taille.o new_page_taquin.o new_page_victoire.o
	gcc -o  page.o new_page_accueil.o new_page_image.o new_page_taille.o new_page_taquin.o new_page_victoire.o -lgraph
page.o : page.c fonction.h
	gcc -c -Wall page.c
new_page_accueil.o : new_page_accueil.c fonction.h
	gcc -c -Wall new_page_accueil.c
new_page_image.o : new_page_image.c fonction.h
	gcc -c -Wall new_page_image.c 
new_page_taille.o : new_page_taille.c fonction.h
	gcc -c -Wall new_page_taille.c 
new_page_taquin.o : new_page_taquin.c fonction.h
	gcc -c -Wall new_page_taquin.c 
new_page_victoire.o : new_page_victoire.c fonction.h
	gcc -c -Wall new_page_victoire.c 
fonction.o : fonction.c fonction.h
	gcc -c -Wall fonction.c  