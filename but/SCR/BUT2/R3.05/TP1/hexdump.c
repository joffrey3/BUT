#include <stddef.h>
#include <stdio.h>
#include <stdlib.h>

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

void hexdump( void * ptr, size_t size){
	char * pointeur = (char*)ptr;
	printf("%X  ",pointeur);
	for(int i=0;i<size*4;i++){

		printf("%.2X  ",pointeur[i]);
	}
	printf("|");
	for(int i=0;i<size*4;i++){
		if(pointeur[i]!=0){
			//instanceof(pointeur[i],int);
			if(1){
				printf("%c",pointeur[i]);
			}
		}else{
			printf("%c",0x2e);
		}
	}
	printf("|");
  printf("\n");
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


	
	unsigned int test=4;
	// appelez hexdump pour chaque variable
	hexdump(&a,sizeof(int));
	hexdump(&c,sizeof(char));
	hexdump(&ex1,sizeof(int));
	hexdump(&ex2,sizeof(char));
	hexdump(&ex3,sizeof(int));
	hexdump(&ex4,sizeof(int));
	return 0;
}
