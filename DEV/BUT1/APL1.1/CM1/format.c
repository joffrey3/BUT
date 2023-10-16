/* auteur : ... */
#include <stdio.h>
#include <stdlib.h>
 
int main(void) {
  printf("%u\n", 65); /* L'entier ne peut pas etre negatif */
  printf("%s\n", "65"); /* il faut l'ecrire sous la forme d'une chaine de charactères donc on met des guillemets */
  printf("%.0f\n", 65.0); /* pour que ce nombre soit considérer comme un double il lui faut un .0 qui ne sera pas affiché comme indiqué dans .0f */
  printf("%hhd\n", 65); /* l'entier doit etre compris entre -128 et 127 */
  return EXIT_SUCCESS;
}