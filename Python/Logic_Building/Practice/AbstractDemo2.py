from abc import ABC, abstractmethod        # abc is module & ABC is class 

class Base(ABC):
    @abstractmethod             # decorator - abstract
    def Addition(self,No1,No2):
        pass
    
class Derived(Base):            # concrete
    def Addition(self,No1,No2):
        return No1 + No2

dobj = Derived()  

Ret = dobj.Addition(10,11)  
print("Addition is : ", Ret)