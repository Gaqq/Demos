from ballplayer import*
from swimmer import *
from hockeyplayer import *
from utils import *


print('''
      COMP 348 A2
      Name: Jack Fraser
      ID: 40266009

      
Welcome to athlete managment tool:
''')
filename='testfile.txt'
saved=True#this tracks if the changes have been saved
while True:
    os.system("clear")
    
    x=input('''
select one of the following options:
1. Load File 
2. Print Stats 
3. Delete Athlete 
4. Save File 
5. Athlete Info 
6. Display Chart 
7. Exit
''')
    
    if x=="1":#load file
        os.system('clear')
        filename=input("enter the filename to load: ")
        readfile(filename)      
        saved=False  
    elif x=="2":#print stats
        os.system('clear')
        displaystats()

    elif x=="3":#delete athlete
        os.system('clear')
        deleteathlete()

    elif x=="4":#save file
        os.system('clear')
        savefile(filename)
        saved=True


    elif x=="5":#athlete info
        os.system('clear')
        showathletestats()

    elif x=="6":#pie chart
        os.system('clear')
        displaypie()
    elif x=="7":#exit
        if saved==False:
            
            if input("changes have not been properly saved, do you still wish to exit? (y/n) ")=="n":
                continue


        os.system('clear')
        print("Thanks for using the athlete managment tool")
        exit()
