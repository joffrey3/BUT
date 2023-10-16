#include <sys/types.h>
#include <dirent.h>
#include <sys/stat.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <fcntl.h>

const unsigned int SEQUENCE=1;

static inline double tstamp(void) 
{                                                                                    
	struct timespec tv;
	clock_gettime(CLOCK_REALTIME, &tv);
	return tv.tv_sec + tv.tv_nsec * 1.0e-9;
}

DIR *opendir(const char *name);

struct dirent *readdir(DIR *dirp);

//struct dirent {
//           ino_t          d_ino;       /* Inode number */
//           off_t          d_off;       /* Not an offset; see below */
//           unsigned short d_reclen;    /* Length of this record */
//           unsigned char  d_type;      /* Type of file; not supported
//                                          by all filesystem types */
//           char           d_name[256]; /* Null-terminated filename */
//       };


int stat(const char *pathname, struct stat *statbuf);

//struct stat {
//           dev_t     st_dev;         /* ID of device containing file */
//           ino_t     st_ino;         /* Inode number */
//           mode_t    st_mode;        /* File type and mode */
//           nlink_t   st_nlink;       /* Number of hard links */
//           uid_t     st_uid;         /* User ID of owner */
//           gid_t     st_gid;         /* Group ID of owner */
//           dev_t     st_rdev;        /* Device ID (if special file) */
//           off_t     st_size;        /* Total size, in bytes */
//           blksize_t st_blksize;     /* Block size for filesystem I/O */
//           blkcnt_t  st_blocks;      /* Number of 512B blocks allocated */
//
//           /* Since Linux 2.6, the kernel supports nanosecond
//              precision for the following timestamp fields.
//              For the details before Linux 2.6, see NOTES. */
//
//           struct timespec st_atim;  /* Time of last access */
//           struct timespec st_mtim;  /* Time of last modification */
//           struct timespec st_ctim;  /* Time of last status change */
//
//       #define st_atime st_atim.tv_sec      /* Backward compatibility */
//       #define st_mtime st_mtim.tv_sec
//       #define st_ctime st_ctim.tv_sec
//       };

int main (int argc, char* argv[]){
double t1,t2;
  t1=tstamp();
  DIR* fr;
  int nb,nb2;
  char* buf[4];
  if(argc<2 || argc>2){
    perror("argc elements error");
    exit(1);
  }
  fr=opendir(argv[1]);
  //fr=open(argv[1],O_RDONLY);
  /*if(fr == -1){
    perror("open fileread error()");
    exit(2);
  }*/
  //nb=read(fr,buf,SEQUENCE);
  nb=readdir(fr);
  /*while(nb>0){
    write(STDOUT_FILENO,buf,SEQUENCE);
    //nb=read(fr,buf,SEQUENCE);
    nb=readdir(fr);
  }*/
  if(nb==-1){
        perror("read error()");
  }
  //close(fr);
  t2=tstamp();
  printf("time = %lf\n",t2-t1);
}