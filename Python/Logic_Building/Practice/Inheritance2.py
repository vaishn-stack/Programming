class Base:
    def __init__(self):
        print("Inside base constructor")

class Derived(Base):        
    def __init__(self):
        print("Inside derived constructor")
        
bobj = Base()
