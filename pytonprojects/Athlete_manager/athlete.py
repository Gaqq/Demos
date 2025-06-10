
class athlete:
    #static
    athletes=[]

    name=""
    age=0
    country="UN"
    totalsalary=0

    count=0

    def __init__(self,name,age,country,salary=0):
        athlete.count+=1
        self.name=name
        self.age=age
        self.country=country
        self.salary=salary
        print(f"athlete:{self.name}, {age} created; total # of athletes {athlete.count}")
        if self.salary!='' and self.salary!=None and self.salary!="0":#checks if salary info is available on the object
            athlete.totalsalary+=float(self.salary)

    @staticmethod
    def __parse__(text):   
        
        arr=text.split(',')
        
        return arr

    def printStats(self):
        return f"name: {self.name}, age: {self.age}, country: {self.country}, salary: {self.salary}"
    
    
        
    


