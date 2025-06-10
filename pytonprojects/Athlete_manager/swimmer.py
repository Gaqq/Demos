from athlete import athlete

class swimmer(athlete):
    stroke_style=""
    personal_best_time =0.0
    count=0
    totalsalary=0
    def __init__(self, name=None, age=None,stroke_style=None, country=None, salary=0,personal_best_time=None):
        swimmer.count+=1
        super().__init__(name, age, country, salary)
        self.stroke_style=stroke_style
        self.personal_best_time=personal_best_time
        print(f"swimmer:{self.name}, {self.age} created; total # of swimmer {swimmer.count}")
        if self.salary!='' and self.salary!=None and self.salary!="0":#checks if salary info is available on the object
            swimmer.totalsalary+=float(self.salary)
    
    def printStats(self):
        print(f"swimming: {super().printStats()}, stroke: {self.stroke_style}, personal best time {self.personal_best_time}")
    
    @staticmethod
    def parse(text):
        
        arr=athlete.__parse__(text)
        
        if(arr.__len__()>=7):#this checks if additional arguments have been given and if true it shortens the list to not include the extra 
            arr=arr[:6]
        return swimmer(*arr)
    def __str__(self):
        return f"Swimmer:{self.name},{self.age},{self.stroke_style},{self.country},{self.salary},{self.personal_best_time}"