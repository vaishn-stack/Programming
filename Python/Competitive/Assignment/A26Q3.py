class Arithmetic:
    
    def __init__(self):
        self.value1 = 0
        self.value2 = 0
        
    def Accept(self):
        self.value1 = int(input("Enter first number :"))
        self.value2 = int(input("Enter second number :"))
        
    def Addition(self):
        return self.value1 + self.value2
    
    def Subtraction(self):
        return self.value1 - self.value2
    
    def Multiplication(self):
        return self.value1 * self.value2

    def Division(self):
        if self.value2 == 0:
            return "Division by Zero is not possible"
        else:
            return self.value1 / self.value2
        
print("------ Object 1 ------")
Obj1 = Arithmetic()

Obj1.Accept()
print("Addition :", Obj1.Addition())
print("Subtraction :", Obj1.Subtraction())
print("Multiplication :", Obj1.Multiplication())
print("Division :", Obj1.Division())

print("\n------ Object 2 ------")
Obj2 = Arithmetic()

Obj2.Accept()
print("Addition :", Obj2.Addition())
print("Subtraction :", Obj2.Subtraction())
print("Multiplication :", Obj2.Multiplication())
print("Division :", Obj2.Division())