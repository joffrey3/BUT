#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int main(void) {
	struct complexe {
  	double reel;
  	double imaginaire;
  	};
  	printf("Les complexes sont : \n");
  	struct complexe x={2,2};
  	struct complexe y={3,3};
  	printf("%.0f + %.0fi\n",x.reel,x.imaginaire);
  	printf("%.0f + %.0fi\n",y.reel,y.imaginaire);
  	printf("Le module au carré est : %f \n", (x.reel*x.reel)-(x.imaginaire*x.imaginaire)+(y.reel*y.reel)-(y.imaginaire*y.imaginaire));
  	printf("Le conjugé est de x: %.0f + %.0fi et de y : %.0f + %.0fi \n",x.reel,-x.imaginaire,y.reel,-y.imaginaire);
  	printf("L'inverse est de x: %f %fi et de y : %f %fi \n",1/x.reel,1/x.imaginaire,1/y.reel,1/y.imaginaire);
}