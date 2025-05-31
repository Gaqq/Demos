#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>
#include "ordering.h"
#include "data.h"
#include "budget.h"







int main(int argc,  char *argv[]){
    
    if(argc<2){
        printf("file name not provided\n");
        exit(0);
    }
    
    struct node *head=readfinances(argv[1]);
    
    
    printf("Name: Jack Fraser\nId: 40266009\nAssigment: 1 \n");

    int run=1;

    while(run!=0){
        
        int choice=0;

        printf("Budget Tracking System\n=====================\n");
        printf("1. Display all entries\n");
        printf("2. Expense Distrobution\n");
        printf("3. Sort Entries\n");
        printf("4. Add Income/Expense Entry\n");
        printf("5. Modify Entry\n");
        printf("6. Filter by Month\n");
        printf("7. Exit \n");

        printf("Choice: ");
        scanf("%d",&choice);
        system("clear");
        
        switch(choice){
            case 1://display list-----------------------------------------------------------------------------------------
            system("clear");
            printlist(head);
            printf("Enter x to return to main menu\n");
            waitforinput('x');
            system("clear");
            break;



            case 2://displace expense distrobution------------------------------------------------------------------------ 
            system("clear");
            display_expense_distrobution(head);
            waitforinput('x');
            system("clear");
            break;



            case 3://sort--------------------------------------------------------------------------------------------------
            sortbytype(head);
            waitforinput('x');
            system("clear");
            break;


            case 4://add entry---------------------------------------------------------------------------------------------
            system("clear");
            addentry(head);
             
            printf("Entry added successfully!\npress x to return to main menu.");
            waitforinput('x');
            system("clear");
            break;



            case 5://modify entry------------------------------------------------------------------------------------------------------
            modentry(head);
            printf("Entry updated successfully\n\nenter x to return to main menu.");
            waitforinput('x');
            system("clear");
            break;
            



            case 6://filter by month----------------------------------------------------------------------------------------------------------
            system("clear");
            int year;
            int month;
            printf("Enter year: ");
            scanf("%d",&year);
            printf("Enter month: ");
            scanf("%d",&month);
            filter_entry_by_month(head,year,month);
            printf("enter x to return to main menu. ");
            waitforinput('x');
            system("clear");
            break;



            case 7://end program.-----------------------------------------------------------------------------------------------------------------
            system("clear");
            printf("Goodbye and thanks for using our budget tracker app\n");
            exit(0);
            break;




        }

    }

    return 0;

}