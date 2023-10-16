#ifndef PILE_H
#define PILE_H

# include <stdio.h>
# include <stdlib.h>

struct maillon_s{char valeur;struct maillon_s* suivant;};

typedef struct maillon_s maillon;
typedef maillon* liste;

void push(char val,liste* l);

void pop(liste* l);

int empty(liste* l);

#endif /*PILE_H*/