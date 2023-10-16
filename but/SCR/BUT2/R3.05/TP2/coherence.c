#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <assert.h>
#include <sys/fcntl.h>
#define TESTFILE "coherence-test.txt"
void write_asr_c_pas_bien() 
{
	FILE* f = fopen(TESTFILE, "w");
	fprintf(f, "L'asr, c'est pas bien!\n");
	fclose(f);
}
void write_asr_c_bien() 
{
	FILE* f = fopen(TESTFILE, "w");
	fprintf(f, "L'asr, c'est bien!!\n");
	fclose(f);
}
void read_using_syscalls() 
{
	write_asr_c_pas_bien();
	// open file descriptor
	int fd = open(TESTFILE, O_RDONLY);
	// read first 12 bytes
	char buf[BUFSIZ];
	ssize_t nr1 = read(fd, buf, 12);
	assert(nr1 >= 0);
	write_asr_c_bien();
	// read rest of file, print to stdout
	ssize_t nr2 = read(fd, buf + nr1, BUFSIZ - nr1);
	close(fd);
	fwrite(buf, 1, nr1 + nr2, stdout);
}
void read_using_stdio() 
{
	write_asr_c_pas_bien();
	// open stdio file
	FILE* f = fopen(TESTFILE, "r");
	// read first 12 bytes
	char buf[BUFSIZ];
	size_t nr1 = fread(buf, 1, 12, f);
	write_asr_c_bien();
	// read rest of file, print to stdout
	size_t nr2 = fread(buf + nr1, 1, BUFSIZ - nr1, f);
	fclose(f);
	fwrite(buf, 1, nr1 + nr2, stdout);
}
static void usage() 
{
	fprintf(stderr, "Usage: ./coherence -l (linux syscalls)  or  ./coherence -s (stdio)\n");
	exit(1);
}
int main(int argc, char** argv) 
{
	int which = 0;
	int opt;
	while ((opt = getopt(argc, argv, "ls")) != -1) {
		switch (opt) {
			case 's':
				which = 's';
				break;
			case 'l':
				which = 'l';
				break;
			default:
				usage();
		}
	}
	if (which == 's') {
		read_using_stdio();
	} else if (which == 'l') {
		read_using_syscalls();
	} else {
		usage();
	}
}
