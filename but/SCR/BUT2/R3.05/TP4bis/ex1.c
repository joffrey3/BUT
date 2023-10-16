#include<stdio.h>
#include<stdlib.h>

void print_int(void * adr)
{
    char *ptr=(char *)adr;
    printf(" %d ",*ptr);
}
void print_string(void * adr)
{
    char *ptr=*(char **)adr;
    int i=0;
    printf(" ");
    for(int i=0;i<7;i++){
        printf("%c",ptr[i]);
    }
    printf(" ");
}

int cmp_int(const void * adr,const void* size)
{
    int *ptr= (int *)adr;
	/*int taille= *(int *)size;
	for(int i=0;i<taille;i++){
		for(int j=0;j<taille;j++){
			if(ptr[j]>ptr[j+1]){
				int temp=ptr[j];
				ptr[j]=ptr[j+1];
				ptr[j+1]=temp;
			}
		}
	}*/
	return *ptr;
}
int comp_string(const void * adr,const void* size)
{
    /*char *ptr=*(char **)adr;
    int i=0;
    printf(" ");
    for(int i=0;i<7;i++){
        printf("%c",ptr[i]);
    }
    printf(" ");*/
	//char **ptr= (char **)adr;
	//return *ptr;
}

void iter(void *base,size_t n ,size_t sizeElem,void(*f)(void *))
{
	int i;
	char *ptr = (char*)base; 
	for(i=0;i<n;i++) 
		f((void*)(ptr+i*sizeElem)); 
	
	/* avec gcc, on peut faire de l'arithmétique directement 
	   avec le type void*, f(base+i*sizeElem) serait correct
	 */ 
}

int main(){
	int t1[10]={12,-7,1,-16,3,19,7,1,5,0};
	char * t2[]={"chou","joujou","bijou","genou",
		     			"caillou","hibou","pou"};

	iter(t1,10,sizeof(int),print_int);
    printf("\n");
	iter(t2,7,sizeof(char*),print_string);
    printf("\n");

	qsort(t1,7,sizeof(int),cmp_int);
	qsort(t2,7,sizeof(char * ),comp_string);

	iter(t1,10,sizeof(int),print_int);
    printf("\n");
	iter(t2,7,sizeof(char*),print_string);
    printf("\n");
}