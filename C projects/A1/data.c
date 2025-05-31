#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>
#include "data.h"
#include "ordering.h"

/**
 * reads the file with the corresponding filename as the param and creates a linked list of row stucts containing the data of each row
 */
struct node* readfinances(char filename[]){
    struct node *head=NULL;
    FILE *file= fopen(filename,"r");
    
   

    
    if(file==NULL){
        printf("Input File not found.");
        fclose(file);
        return NULL;
    }
    else{

        int id;
        char date[11],type[8],subtype[8],description[16];
        float amount;
        struct row data;
        char line[256];
        while(fgets(line, sizeof(line),file)){
            if(sscanf(line,"%d|%10[^|]|%19[^|]|%19[^|]|%49[^|]|%f",
                  &data.ID, data.date, data.type, 
                  data.subtype, data.description, &data.amount)==6){
                    insertatend(&head,data);
                  }
            


        }



        
        

       
        

    }
    
    fclose(file);
    return head;
}