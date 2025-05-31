#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>
#include "data.h"

void sortbytype(struct node *head);

void printlist(struct node *head);

void filter_entry_by_month(struct node *head,int year,int month);

void waitforinput(char x);

void display_expense_distrobution(struct node *head);

struct row *find_id(struct node *head, int id);

int size(struct node *head);

int validinputint(int upper,int lower);
float validinputfloat(float upper,float lower);

void modentry(struct node * head);

void addentry(struct node *head);
