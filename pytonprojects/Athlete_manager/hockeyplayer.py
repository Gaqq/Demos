from athlete import athlete
from enum import Enum,auto

class positions(Enum):
    forward="forward"
    defenseman="defenseman"
    goalie="goalie"




class hockeyplayer(athlete):
    position=positions.forward
    goals_scored=0
    stick_brand=""
    skates_size=0
    count=0
    totalsalary=0

    def __init__(self, name=None, age=None, country=None, salary=0, position=None, goals_scored=0, stick_brand="NA", skates_size=0):
        

        hockeyplayer.count+=1
        athlete.__init__(self,name, age, country, salary)
        self.position=position
        self.goals_scored=goals_scored
        self.stick_brand=stick_brand
        self.skates_size=skates_size
        print(f"hockeyplayer:{self.name}, {self.age} created; total # of hockeyplayer {hockeyplayer.count}")
        if self.goals_scored=='':
            self.goals_scored=0

        if self.salary!='' and self.salary!=None and self.salary!="0":#checks if salary info is available on the object
            hockeyplayer.totalsalary+=float(self.salary)
    
    def printstats(self):
        print(f"hockey: {super().printStats}, goals: {self.goals_scored}, stick brand: {self.stick_brand}, skate size: {self.skates_size}")

    def __str__(self):
        return f"HockeyPlayer:{self.name},{self.age},{self.country},{self.salary},{self.position},{self.goals_scored},{self.stick_brand},{self.skates_size}"

    @staticmethod
    def parse(text):
        arr=athlete.__parse__(text)
        
        if arr.__len__()>=9:#this checks if additional arguments have been given and if true it shortens the list to not include the extra 
            arr=arr[:8]

        return hockeyplayer(*arr)
    
    @staticmethod
    def getgoals():
        goalist={}
        for n in athlete.athletes:
            if(isinstance(n,hockeyplayer)):
                goalist.update({n.name:n.goals_scored})
        return dict(sorted(goalist.items(),key=lambda item:int(item[1])))
    
    




