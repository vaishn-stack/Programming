def Sum(No):
    Ans = 0
    
    for i in range(1,No + 1):
        Ans = Ans + i
    
    return Ans
        
value = int(input("Enter a number : "))

print("Sum is :",Sum(value))