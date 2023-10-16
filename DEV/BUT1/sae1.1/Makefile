but : page.out

OFILES = page.o\
		 new_page_accueil.o\
		 new_page_image.o\
		 new_page_taille.o\
		 new_page_taquin.o\
		 new_page_victoire.o\
		 fonction.o\

 CC= gcc

 CFLAGS= -Wall -ansi -pedantic -g
 
page.o : page.c 
	gcc -c page.c

new_page_accueil.o : new_page_accueil.c 
	gcc -c new_page_accueil.c

new_page_image.o : new_page_image.c 
	gcc -c new_page_image.c

new_page_taille.o : new_page_taille.c 
	gcc -c new_page_taille.c

new_page_taquin.o : new_page_taquin.c 
	gcc -c new_page_taquin.c

new_page_victoire.o : new_page_victoire.c
	gcc -c new_page_victoire.c

fonction.o : fonction.c
	gcc -c fonction.c


page.out : $(OFILES)
	$(CC) $(CFLAGS) -o page.out $(OFILES) -lgraph

