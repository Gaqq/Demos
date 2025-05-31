#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>
#ifndef DATA_H
#define DATA_H

struct row{
    int ID;
    char date[11];
    char type[20];
    char subtype[20];
    float amount;
    char description[50];
};

struct node{
        struct row data;
        struct node *next;
};

struct node* readfinances(char filename[]);
#endif