

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>
#include "ordering.h"


/**
 * creats a node struct when provided a row struct
 */
struct node* createnode(struct row Data){
    struct node *newnode=(struct node*)malloc(sizeof(struct node));
    if(newnode==NULL){
        printf("malloc failed");
        exit(1);
    }
    newnode->data=Data;
    newnode->next=NULL;
    return newnode;

} 

/**
 * creates a row struct with given data
 */
struct row *createrow(int id,char date[11],char type[20],char subtype[20], char description[50], float amount){
    struct row *newrow=(struct row*)malloc(sizeof(struct row));
    if(newrow==NULL){
        printf("malloc failed");
        exit(1);
    } 
    newrow->ID=id;
    strcpy(newrow->date,date);
    strcpy(newrow->type,type);
    strcpy(newrow->subtype,subtype);
    strcpy(newrow->description,description);
   newrow->amount=amount;
    return newrow;
}

/**
 * inserts the given row to the end of of the list pointed by the given head
 */
void insertatend(struct node** head, struct row data){
    struct node *newnode = createnode(data);

    if(*head==NULL){
        *head=newnode;
        return;
    }
    struct node *temp=*head;
    while(temp->next!=NULL){
        temp=temp->next;
    }
    temp->next=newnode;


    

}

/**
 * removes the node at the given index of the list
 */
void removeatindex(struct node **head, int index){
    struct node *remove;
    if(head==NULL){return;}
    if(index==0){//if first element is removed then head pointer needs to be updated 
        remove=*head;
        *head=(*head)->next;
        free(remove); 
        return;}
    struct node *temp=*head;
    
    int count=0;
    while (temp!=NULL&&count<index-1)
    {
        count++;
        temp=temp->next;
    }
    if(temp!=NULL&&temp->next!=NULL){
        remove=temp->next;
        temp->next=temp->next->next;
        free(remove);
    }
    

}



/**
 * sorts the linked list based on the sortype
 * 0=by id
 * 1=by date
 * 2=by description
 * 3=by amount
 */
void sort(struct node **head,int sortype){
    if(*head==NULL||(*head)->next==NULL){
        return;
    }
    struct node *newhead=NULL;
    
    struct node *biggest;
        
    struct node *temp=*head;
    int index;
    int n;
while(*head!=NULL){
    biggest=*head;
    temp=*head;
    n=0;
    index=0;
while(temp!=NULL){
    
    
    switch(sortype){
        case 0:
            if(temp->data.ID<=biggest->data.ID){
                biggest=temp;
                index=n;
            }
        break;
        case 1:
        //these 2 variables are just the dates converted to ints done manually
        int tempdate=(10000000*(temp->data.date[0]-'0')+1000000*(temp->data.date[1]-'0')+100000*(temp->data.date[2]-'0')+10000*(temp->data.date[3]-'0')+1000*(temp->data.date[5]-'0')+100*(temp->data.date[6]-'0')+10*(temp->data.date[8]-'0')+(temp->data.date[9]-'0'));
        int biggestdate=(10000000*(biggest->data.date[0]-'0')+1000000*(biggest->data.date[1]-'0')+100000*(biggest->data.date[2]-'0')+10000*(biggest->data.date[3]-'0')+1000*(biggest->data.date[5]-'0')+100*(biggest->data.date[6]-'0')+10*(biggest->data.date[8]-'0')+(biggest->data.date[9]-'0'));
            if(tempdate<=biggestdate){
                biggest=temp;
                index=n;
            }
        break;
        case 2:
             if(temp->data.amount<=biggest->data.amount){
                biggest=temp;
                index=n;
            }
        break;
        case 3:
             if(temp->data.description[0]<=biggest->data.description[0]){
                biggest=temp;
                index=n;
            }

        break;

    }
    n++;
    temp=temp->next;
}
    insertatend(&newhead,biggest->data);
    removeatindex(head,index);

    
}
    *head=newhead;
}

