from athlete import athlete

class ballplayer(athlete):
    team_name="" 
    jersey_number=0
    endorsement=""
    count=0

    totalsalary=0

    def __init__(self,name,age,team_name,jersey_number,country,salary=0,endorsement=""):
        ballplayer.count+=1
        athlete.__init__(self,name,age,country,salary)
        self.team_name= team_name
        self.jersey_number=jersey_number
        self.endorsement=endorsement

        if self.salary!='' and self.salary!=None and self.salary!="0":#checks if salary info is available on the object
            ballplayer.totalsalary+=float(self.salary)
    
    def printEndorsement(self):
        pass
    
    def printStats(self):
        
        
        return f"{super().printStats()},  team_name: {self.team_name}, jersey_number: {self.jersey_number}, endorsement: {self.endorsement}"

    @staticmethod
    def getendorsements():
        endorsments={}

        for n in athlete.athletes:
            
            if isinstance(n,ballplayer) and n.endorsement!=None and n.endorsement!="" and n.endorsement!="None":
                
                if endorsments.get(n.endorsement,True):
                    endorsments.update({n.endorsement:1})
                else:
                    endorsments[n.endorsement]+=1
                
        return dict(sorted(endorsments.items(),key=lambda item:int(item[1])))






class basketballplayer(ballplayer):
    three_point_pct=0.0
    rebounds=0
    count=0
    totalsalary=0
    
    def __init__(self,name=None,age=None,team_name=None,jersey_number=None,country=None,salary=0,endorsement=None,three_point_pct=None,rebounds=None):
        basketballplayer.count+=1
        ballplayer.__init__(self,name,age,team_name,jersey_number,country,salary,endorsement)
        self.three_point_pct=three_point_pct
        self.rebounds=rebounds
        print(f"basketballplayer:{self.name}, {self.age} created; total # of basketballplayer {basketballplayer.count}")

        if self.salary!='' and self.salary!=None and self.salary!="0":#checks if salary info is available on the object
            basketballplayer.totalsalary+=float(self.salary)
        
    
    def printStats(self):
        
        print(f"baskeball: {super().printStats()}, three_point_pct: {self.three_point_pct}, rebounds:{self.rebounds}")
    
    def printEndorsement(self):
        print(self.endorsment)

    @staticmethod
    def parse(text):
        arr=athlete.__parse__(text)
        if(arr.__len__()>=10):#this checks if additional arguments have been given and if true it shortens the list to not include the extra 
            arr=arr[:9]
        return basketballplayer(*arr)
    def __str__(self):
        return f"BasketballPlayer:{self.name},{self.age},{self.team_name},{self.jersey_number},{self.country},{self.salary},{self.endorsement},{self.three_point_pct},{self.rebounds}"

        
    





class footballplayer(ballplayer):
    touchdowns=0
    passing_yards=0
    count=0
    totalsalary=0
    
    def __init__(self,name=None,age=None,team_name=None,jersey_number=None,country=None,salary=0,endorsement=None,touchdowns=0,passing_yards=0):
       
        footballplayer.count+=1
        ballplayer.__init__(self,name,age,team_name,jersey_number,country,salary,endorsement)
        self.touchdowns=touchdowns
        self.passing_yards=passing_yards
        print(f"footballplayer:{self.name}, {self.age} created; total # of footballplayer {footballplayer.count}")
        if self.touchdowns=='':
            self.touchdowns=0

        if self.salary!='' and self.salary!=None and self.salary!="0":#checks if salary info is available on the object
            footballplayer.totalsalary+=float(self.salary)
    
    def printStats(self):
        
        print(f"football: {super().printStats()}, touchdowns: {self.touchdowns}, passing_yards: {self.passing_yards}")

    def printEndorsement(self):
        print(self.endorsment)
    
    @staticmethod
    def parse(text):
        arr=athlete.__parse__(text)
        
        if(arr.__len__()>=10):#this checks if additional arguments have been given and if true it shortens the list to not include the extra 
            arr=arr[:9]

        return footballplayer(*arr)
    
    @staticmethod
    def gettouchdowns():
        tds={}
        for n in athlete.athletes:
            if(isinstance(n,footballplayer)):
                tds.update({n.name:n.touchdowns})
        return dict(sorted(tds.items(),key=lambda item:int(item[1])))
    def __str__(self):
        return f"FootballPlayer:{self.name},{self.age},{self.team_name},{self.jersey_number},{self.country},{self.salary},{self.endorsement},{self.touchdowns},{self.passing_yards}"
