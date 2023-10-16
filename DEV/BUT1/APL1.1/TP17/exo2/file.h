#ifndef FILE_H
#define FILE_H

#include "structure.h"

int file_empty(file f);

void file_push(file f, char *s);

char *file_top(file f);

char *file_pop(file f);

void file_clear(file f);

#endif
