#include<stdio.h>
/* segment bss et data */
#define N 100000
//int t[N]; /* version 1 */
int t[N]={1}; /* version 2 */
int main()
{
  char x;
  printf("&t\t=\t%p\n",&t);
  //scanf("%d",&x);
  return 0;
}
