main.out : main.o saisie.o file.o
	gcc -o main.out main.o saisie.o file.o
main.o : main.c structure.h file.h saisie.h
	gcc -c main.c structure.h file.h saisie.h
file.o : file.c structure.h
	gcc -c file.c structure.h
saisie.o : saisie.c structure.h
	gcc -c saisie.c structure.h
