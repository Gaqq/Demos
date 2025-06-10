import matplotlib.pyplot as plot
import os
from ballplayer import*
from swimmer import *
from hockeyplayer import *
from utils import *

def clearoninput():

    while(input("press x to return ")!='x'):
        pass
    os.system('cls' if os.name=='nt' else "clear")
    return




def readfile(filename):
    file=None
    
    try:
        with open(filename,"r") as file:
            for n in file:
                n=n[:-1]
                splitline=n.split(":")
                
                #try:
                if splitline[0]=="HockeyPlayer":
                   
                    athlete.athletes.append(hockeyplayer.parse(splitline[1]))

                elif splitline[0]=="Swimmer":
                    
                    
                    athlete.athletes.append(swimmer.parse(splitline[1]))

                elif splitline[0]=="FootballPlayer":
                    
                    athlete.athletes.append(footballplayer.parse(splitline[1]))

                elif splitline[0]=="BasketballPlayer":
                   
                    athlete.athletes.append(basketballplayer.parse(splitline[1]))

                #except Exception as e:
                    #print(e)
                    #print("The file is not properly formated") 
                    #exit()

            file.close()

    except FileNotFoundError as e:
        print(e)
        exit()
    clearoninput()




def displaystats():
    if(athlete.athletes.__len__()==0):
        print("no athletes loaded, please load file.")
        return
    
    print(f'''
Statistics: 
------------------- 
{athlete.count} athletes 
{hockeyplayer.count} Hockey Players 
{ballplayer.count} Ball Players ({basketballplayer.count} Basketball and {footballplayer.count} Football Players) 
{swimmer.count} swimmers
''')

    print(f'''
Endoresments:  
-------------------''')
    endorsments=ballplayer.getendorsements()
    for n in endorsments:
        print(f"{n} ({endorsments[n]})")

    print(f'''
Goals scored:
-------------------
''')
    goalist=hockeyplayer.getgoals()
    for n in goalist:
        print(f"{goalist[n]} {n}")

    print(f'''
Touchdowns:
-------------------
''')
    tds=footballplayer.gettouchdowns()
    for n in tds:
        print(f"{tds[n]} {n}")
    
    clearoninput()

def displayallnames():
    
    for n in athlete.athletes:
        print(n.name)

def showathletestats():
    if(athlete.athletes.__len__()==0):
        print("no athletes loaded, please load file.")
        return
    print("Enter the name of the athlete whose stats you want to see: ")
    displayallnames()
    name=input("enter name:")
    found=False
    for n in athlete.athletes:
        if n.name==" "+name:
            n.printStats()
            found=True
    if found==False:
        print(f"no athlete with name: {name}")
    clearoninput()
        

def deleteathlete():
    if(athlete.athletes.__len__()==0):
        print("no athletes loaded, please load file.")
        return
    print("Delete menu:\nenter the name of the athlete to remove from the list:\n")
    displayallnames()
    name=input("name: ")
    name=" "+name#adds a space at the start of the string as that is how the names are read from the file

    
    i=0
    for n in athlete.athletes:#checks for repeated names 
        if n.name==name:
            i+=1
    if i>=2:
        print("multiple athletes with given name, all will be romoved")
        clearoninput()
    i=0
    for n in athlete.athletes:
        if n.name==name:
            
            athlete.athletes.pop(i)
        i+=1
    print("athlete successfully deleted")
    clearoninput()

def savefile(filename):
    if(athlete.athletes.__len__()==0):
        print("no athletes loaded, please load file.")
        return
    print(f"the following will be saved to {filename}.")
    for n in athlete.athletes:
        print(n)
    while(input('select x to continue')!='x'):
        pass

    try:
        with open(filename,'w') as file:
            for n in athlete.athletes:
                print(n)
                file.write(n.__str__())
                file.write("\n")
            file.close()
        print("data saved!")
        clearoninput()
    except FileNotFoundError as e:
        print(f"file {filename} not found")
        
    
def displaypie():
    if(athlete.athletes.__len__()==0):
        print("no athletes loaded, please load file.")
        return

    print('''
Chart menu:

select a chart to display from the following:
1. Number of Athletes (level 1): this chart includes all immediate subclasses of Athlete. 
2. Number of Athletes (leaf level): this chart includes all child classes without any subclass. 
3. Athletes Salaries (level 1): this chart displays the average salary per athlete type.  
4. Athletes Salaries (leaf level): this chart displays the average salary per immediate subclass. 
5. Endorsements: this chart provides the statistics for the endorsements. 
''')
    x=input("please select a number: ")
    labels=[]
    sizes=[]
    colors=['red', 'yellow', 'pink', 'brown']


    if int(x)==1:
        plot.title("Fig 1: athlete subclass distrobution")
        labels=["HockeyPlayers","Swimmers","BallPlayers"]
        sizes=[hockeyplayer.count/athlete.count,swimmer.count/athlete.count,ballplayer.count/athlete.count]
    elif int(x)==2:
        plot.title("Fig 2: athlete distrobution")
        labels=["HockeyPlayers","Swimmers","FootballPlayers","BasketballPlayers"]
        sizes=[hockeyplayer.count/athlete.count,swimmer.count/athlete.count,footballplayer.count/athlete.count,basketballplayer.count/athlete.count]

    elif int(x)==3:
        plot.title("Fig 3: athlete salary distrobution by subclass")
        labels=["HockeyPlayers","Swimmers","BallPlayers"]
        sizes=[hockeyplayer.totalsalary/athlete.totalsalary,swimmer.totalsalary/athlete.totalsalary,ballplayer.totalsalary/athlete.totalsalary]
        

    elif int(x)==4:
        plot.title("Fig 4: athlete salary distrobution")
        labels=["HockeyPlayers","Swimmers","FootballPlayers","BasketballPlayers"]
        sizes=[hockeyplayer.totalsalary/athlete.totalsalary,swimmer.totalsalary/athlete.totalsalary,footballplayer.totalsalary/athlete.totalsalary,basketballplayer.totalsalary/athlete.totalsalary]
        

    elif int(x)==5:
        plot.title("Fig 5: ballplayer endorsement distrobution")
        total=0
        endorsments=ballplayer.getendorsements()
        labels=endorsments.keys()
        for n in endorsments:
            total+=endorsments[n]
        for n in endorsments:
            sizes.append(endorsments[n]/total)
        
        

    else:
        print("invalid input")
        clearoninput()
        return
    plot.pie(sizes,labels=labels)
    plot.show()

    
