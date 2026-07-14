from abc import ABC, abstractmethod        # abc is module & ABC is class 

class Base(ABC):
    @abstractmethod             # decorator
    def Addition(self,No1,No2):
        pass
    

class Derived(Base):
    pass

dobj = Derived()    # Error
