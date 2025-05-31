#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>
#include "budget.h"
#include "data.h"
#include "ordering.h"
#include <stdbool.h>
#include <math.h>

/**
 * sorts entries based on sorttype given by user input
 */
void sortbytype(struct node *head){

     int sortype;
            system("clear");
            printf("Sort Menu\n");
            printf("0. Sort by ID\n");
            printf("1. Sort by Date\n");
            printf("2. Sort by Amount\n");
            printf("3. Sort by Description\n");
            printf("choice: ");
            scanf("%d",&sortype);
            sort(&head,sortype);
            printf("entries sorted succesfully!\n\n\n");
            printlist(head);
            printf("enter x too return to main menu");
            

            
}

/**
 * prints all entries to console
 */
void printlist(struct node *head){
    if(head->next!=NULL){
        
        struct node *currentnode=head;
        printf("Finances Summary\n");
        printf("%-10s %-10s %-10s %-15s %-20s %-10s\n","ID", "Date", "Type", "Subtype", "Description","Amount");
        printf("---------------------------------------------------------------------------------------------------\n");
       
        while(currentnode!=NULL){
           
            printf("%d\t%-12s %-11s %-15s %-20s$%f\n",
            currentnode->data.ID,
            currentnode->data.date,
            currentnode->data.type,
            currentnode->data.subtype,
            currentnode->data.description,
            currentnode->data.amount
        );
            
            currentnode=currentnode->next;
        }
    }
}

/**
 * prints the entries with the corresponding months
 */
void filter_entry_by_month(struct node *head,int year,int month){
    //int tempyear=(1000*(date[0]-'0')+100*(date[1]-'0')+10*(date[2]-'0')+(date[3]-'0'));//converts the year part of the date string into an int
    //int tempmonth=(10(date[5]-'0')+(date[6]-'0'));
    
    struct node *temp=head;
    
    printf("Entries for %d-%02d\n",year,month);
        printf("ID\tDate\tType\tSubtype\tDescription\tAmount\n");
        printf("---------------------------------------------------------------------------------------------------\n");
    while (temp!=NULL)
    {
        int tempyear=(1000*(temp->data.date[0]-'0')+100*(temp->data.date[1]-'0')+10*(temp->data.date[2]-'0')+(temp->data.date[3]-'0'));//converts the year part of the date string into an int
        int tempmonth=(10*(temp->data.date[5]-'0')+(temp->data.date[6]-'0'));
        
       if(year==tempyear&&month==tempmonth){
           printf("%d\t%s\t%s\t%s\t%s\t%f\n",
            temp->data.ID,
            temp->data.date,
            temp->data.type,
            temp->data.subtype,
            temp->data.description,
            temp->data.amount
        ); 
       }
       temp=temp->next;
    }
    
}

/**
 * stalls the program until the users inputs the passed char param
 */
void waitforinput(char x){
    while(getchar()!=x){
        //waits
    }
    

}

/**
 * Displays the distrobution of expoenses to console
 */
void display_expense_distrobution(struct node *head){
    //expenses=wants+needs
    float total_expense, total_income=0,needs=0,wants=0,net_balance,need_ratio=0,want_ratio=0;

    struct node *temp=head;
    
    while(temp!=NULL){
        
        if(temp->data.type[0]=='i'){
            total_income+=temp->data.amount;
        }
        else if(temp->data.type[0]=='e'){
            if(temp->data.subtype[0]=='n'||temp->data.type[0]=='N'){
                needs+=temp->data.amount;
            }
            else if(temp->data.subtype[0]=='w'||temp->data.type[0]=='W'){
                wants+=temp->data.amount;
            }
        }
        

        temp=temp->next;
    }
    total_expense=wants+needs;
    if(total_expense!=0){
        need_ratio=needs/total_expense*100;
        want_ratio=wants/total_expense*100;
    }
    net_balance=total_income-total_expense;
    
    printf("Total Income: %f\n",total_income);
    printf("Total Expenses: %f\n",total_expense);
    printf("Needs: %f (%f%% of expenses)\n",needs,need_ratio);
    printf("Wants: %f (%f%% of expenses)\n",wants,want_ratio);
    printf("Net Balance: %f\n",net_balance);
    printf("press x to return to main menu.\n");
     


}


/**
 * finds the corresponding row based on given id
 */
struct row *find_id(struct node *head, int id){
    struct node *temp=head;
    
    while(temp!=NULL){
        if(temp->data.ID==id){
            return &(temp->data);
        }
        temp=temp->next;
    }
    return NULL;
}

/**
 * returns the size of the list of entries
 */
int size(struct node *head){
    struct node* temp=head;
    int count=0;
    while (temp!=NULL)
    {
        count++;
        temp=temp->next;
    }
    
    return count;
}

/**
 * validates input
 * takes user input until it is within the bounds of upper and lower
 */
int validinputint(int upper,int lower){
    int input;
    

    while(true){
        
    scanf("%d",&input);
    if(lower<=input&&input<=upper){
        break;
    }
    printf("invalid input try again: ");
}
    return input;
}
/**
 * validates input
 * takes user input until it is within the bounds of upper and lower
 */
float validinputfloat(float upper,float lower){
    
    float input;
     
    
 
    while(1==1){
       scanf("%f",&input);
    if(lower<=input&&input<=upper){
        break;
    }
    printf("invalid input try again: ");
}
return input;
}

/**
 * adds an entry created from data given as user input
 */
void addentry(struct node *head){

     int id=100+size(head)+1;
            char date[16],type[20],subtype[20],description[50];
            float amount;
            printf("Use todays date? (y/n): ");
            char selection;
            scanf(" %c",&selection);
            
            if(selection=='y'){//find todays date and save it to date
                
                time_t rawtime;
                time(&rawtime);
                struct tm *timeinfo=localtime(&rawtime);

                strftime(date,sizeof(date),"%Y-%m-%d",timeinfo);
            }
            else if(selection=='n'){//take inputed date and save it
                printf("enter date in the following format YYYY-MM-DD: ");
                scanf("%s",date);
            }
            //get type and save it to type variable
            printf("Type (income/expense): ");
            scanf("%s",type);
            //get subtype 
            printf("Subtype/Category: ");
            scanf("%s",subtype);
            //get description
            printf("Description: ");
            scanf("%s",description);
            //get amount
            printf("Amount: ");
            amount=validinputfloat(INFINITY,0);

            //create row struct with variables and add to list
            insertatend(&head,*createrow(id,date,type,subtype,description,amount));

}

/**
 * modifies the entry specified by user input
 */
void modentry(struct node * head){
    system("clear");
            printlist(head);
            //int id_to_mod;
            struct row *entry_to_mod;
            printf("\n\nEnter the ID of entry to modify: ");
            //scanf("%d",&id_to_mod);
            entry_to_mod=find_id(head,validinputint(100+size(head),101));
            printf("Current Details:\n");
            printf("ID: %d\n",entry_to_mod->ID);
            printf("Date: %s\n",entry_to_mod->date);
            printf("Type: %s\n",entry_to_mod->type);
            printf("Subtype: %s\n",entry_to_mod->subtype);
            printf("Description: %s\n",entry_to_mod->description);
            printf("Amount: %f\n",entry_to_mod->amount);
            
            int pick;
            printf("\nWhat would you like to modify?\n1. Date\n2. Amount\nChoice: ");
            scanf("%d",&pick);
            if(pick==1){
                printf("Enter new date (YYYY-MM-DD): ");
                char newdate[11];
                scanf(" %s",newdate);
                strcpy(entry_to_mod->date,newdate);
            }
            else if(pick==2){
                printf("Enter new amount: ");
                int newamount=validinputfloat(INFINITY,0);
                
            
                entry_to_mod->amount=newamount;
            }
}