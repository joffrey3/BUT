#include <stdio.h>
#include <stdlib.h>
#include <graph.h>
#include <time.h>

int ChargerImage(char *f,int x,int y,int xx,int yy,int l,int h);

void ChargerImageFond(char *file);

int main()
{
    int tab[2000];
    int x,y;
    FILE * f, * f1;
    InitialiserGraphique();
    CreerFenetre(10,10,1000,1000);
    f1=fopen ("image.bin","r");
    if (f1==NULL){
        printf("Accès impossible\n");
        return EXIT_FAILURE;
    }
    while(!feof(f1)){
    fread(tab,sizeof(int),1,f1);
    printf("%d\n",tab[x]);
    x=x+1;
    }
    x=tab[0];
    y=tab[x];
    printf("%d\n",x);
    printf("%d\n",y);
    fclose(f1);
    /*f=fopen ("image.jpg","w");
    if (f==NULL){
        printf("Accès impossible\n");
        return EXIT_FAILURE;
    }
    fwrite(tab,sizeof(char),200,f);
    fclose(f);*/
    DessinerRectangle(0,0,x,y);
    ChargerImage("image.bin",200,200,0,0,200,200);
    Touche();
    FermerGraphique();
    return EXIT_SUCCESS;
}