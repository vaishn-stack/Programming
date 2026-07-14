class Base1:
    def fun(self):
        print("Inside base1 fun")
        
class Base2:
    def gun(self):
        print("Inside base2 gun")
        
class Derived(Base1,Base2):        
    def sun(self):
        print("Inside derived sun")
        
dobj = Derived()
dobj.fun()
dobj.sun()
dobj.gun()