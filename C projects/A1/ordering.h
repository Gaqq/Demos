#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>
#include "data.h"

struct node* createnode(struct row Data);
struct row *createrow(int id,char date[11],char type[20],char subtype[20], char description[50], float amount);
void insertatend(struct node** head, struct row data);
void removeatindex(struct node **head, int index);
void printlist(struct node *head);
void sort(struct node **head,int sortype);
void sortbytype(struct node *head);