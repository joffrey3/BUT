# TP2 : Fichiers

#### Ex1
Le repertoire [bin](./bin) contient 4 exécutables : 
 - `mystere1`, 
 - `mystere2`, 
 - `mystere3`, 
 - `mystere4`.

En utilisant le programme `strace`, dites si les E/S sont séquentielles, et si elles utilisent un cache en 
lecture/écriture (précisez le cas échéant sa taille).

#### Ex2 
Écrire deux versions d'un programme qui copie "octet par octet" un fichier source dans un fichier destination :
		
```
./copy infile outfile
```

en utilisant : 

  1. les appels systèmes linux : `open`, `read`, `write`, `close`.
  2. les fonctions E/S standards (sdtio) : `fopen`, `fread`, `fwrite`, `fclose`.

Testez vos deux programmes  sur un fichier volumineux (utilisez la commande `dd` le pseudo fichier `dev/urandom` pour
générer un contenu aléatoire) et expliquez pourquoi le deuxième programme est beaucoup plus rapide que le
premier.

Remarque : pour être  dans les mêmes conditions, il faut être sur que le fichier à copier n'est pas en cache en mémoire. Générez un nouveau fichier de même taille, ou utilisez le programme [fadvise.c](./src/fadvise.c) qui permet de vider les blocs du cache pour un fichier quelconque.

#### Ex2 bis
Écrire un programme qui copie un fichier en utilisant `mmap`.

#### Ex3
Compilez et exécutez Le programme [coherence.c](./src/coherence.c). Qu'est ce que cela montre ?

#### Ex4
Le but est d'écrire une version simplifiée de la commande `ls -al`.

```bash
$./myls /
drwxr-xr-x  18 root root       4096 07	sept.	12:48 ..
drwxr-xr-x   6 root root       4096 03	nov.	09:40 srv
drwxr-xr-x  10 root root       4096 24	sept.	21:07 usr
dr-xr-xr-x 301 root root          0 18	sept.	07:10 proc
drwxr-xr-x 312 root root     258048 12	sept.	09:46 lib
drwxrwxrwt  25 root root       2140 27	sept.	13:02 tmp
drwxr-xr-x  18 root root       4096 07	sept.	12:48 .
drwxr-xr-x   5 root root       1024 07	sept.	12:57 boot
drwxr-xr-x  32 root root        760 27	sept.	09:57 run
drwxr-xr-x  11 root root       4096 25	juil.	18:14 opt
drwxr-x---  32 root root       4096 25	sept.	13:49 root
drwxr-xr-x 122 root root      12288 27	sept.	09:57 etc
drwxr-xr-x   4 root root       4096 10	déc.	08:27 home
drwxr-xr-x   6 root root     151552 24	sept.	21:07 bin
drwxr-xr-x   6 root root     151552 24	sept.	21:07 sbin
drwxr-xr-x  23 root root       3580 27	sept.	09:57 dev
drwxr-xr-x  10 root root       4096 13	sept.	13:33 media
drwxr-xr-x  15 root root       4096 18	sept.	07:10 var
drwxr-xr-x 312 root root     258048 12	sept.	09:46 lib64
dr-xr-xr-x  13 root root          0 18	sept.	07:10 sys
drwx------   2 root root      16384 02	sept.	11:30 lost+found
-rw-r--r--   1 root root       2333 28	juin	20:49 fonts.conf
drwxr-xr-x   2 root root       4096 02	sept.	11:40 mnt
```

 - pour parcourir les entrées du repertoire passé en argument :
   ```c
   #include <sys/types.h>
   #include <dirent.h>
   
   DIR *opendir(const char *name);
   ```
 
   ```c
   #include <dirent.h>

   struct dirent *readdir(DIR *dirp);
   struct dirent {
              ino_t          d_ino;       /* Inode number */
              off_t          d_off;       /* Not an offset; see below */
              unsigned short d_reclen;    /* Length of this record */
              unsigned char  d_type;      /* Type of file; not supported
                                             by all filesystem types */
              char           d_name[256]; /* Null-terminated filename */
          };
   ```

 - les autres informations sont accessibles grâce à la fonction :

   ```c
   #include <sys/types.h>
   #include <sys/stat.h>
   #include <unistd.h>

   int stat(const char *pathname, struct stat *statbuf);

   struct stat {
              dev_t     st_dev;         /* ID of device containing file */
              ino_t     st_ino;         /* Inode number */
              mode_t    st_mode;        /* File type and mode */
              nlink_t   st_nlink;       /* Number of hard links */
              uid_t     st_uid;         /* User ID of owner */
              gid_t     st_gid;         /* Group ID of owner */
              dev_t     st_rdev;        /* Device ID (if special file) */
              off_t     st_size;        /* Total size, in bytes */
              blksize_t st_blksize;     /* Block size for filesystem I/O */
              blkcnt_t  st_blocks;      /* Number of 512B blocks allocated */

              /* Since Linux 2.6, the kernel supports nanosecond
                 precision for the following timestamp fields.
                 For the details before Linux 2.6, see NOTES. */

              struct timespec st_atim;  /* Time of last access */
              struct timespec st_mtim;  /* Time of last modification */
              struct timespec st_ctim;  /* Time of last status change */

          #define st_atime st_atim.tv_sec      /* Backward compatibility */
          #define st_mtime st_mtim.tv_sec
          #define st_ctime st_ctim.tv_sec
          };
   ```

	Faire `man 7 inode`.
