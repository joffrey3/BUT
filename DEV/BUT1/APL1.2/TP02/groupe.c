#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int main(void) {
   struct group {
      char   *gr_name;        /* group name */
      char   *gr_passwd;      /* group password */
      gid_t   gr_gid;         /* group ID */
      char  **gr_mem;         /* NULL-terminated array of pointers
                              to names of group members */
   };
   /*struct students21 {
      char   name;
   };
   struct students21 *getgrnam(const char *name);
   int getgrnam_r(const char *restrict name, struct group *restrict grp,
   char *restrict buf, size_t buflen,
   struct group **restrict result);
   struct students21 paul={"paul"};
   struct students21 pierre={"pierre"};
   printf("%d",sizeof(students21.name));
   printf("\n");*/
   struct students21 {
   char name[30];
   };
   printf("Les noms du groupe students21 sont : ");
   struct students21 paul={"paul"};
   struct students21 pierre={"pierre"};
   printf("%s ",paul.name);
   printf("\n");
}