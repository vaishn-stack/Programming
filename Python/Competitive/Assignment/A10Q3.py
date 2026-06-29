def Factorial(No):
    Ans = 1
    
    for i in range(1,No + 1):
        Ans = Ans * i
    
    return Ans
        
value = int(input("Enter a number : "))

print("Factorial is :",Factorial(value))