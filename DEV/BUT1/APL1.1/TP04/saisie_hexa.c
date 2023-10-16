#include <stdio.h>
#include <stdlib.h>
int main (void) {
int entier=1234;
printf("Entrez un entier en hexadecimal : ");
scanf("%X", &entier);
printf("Le résultat decimal est : %d\n", entier);
}
