def SumDigits(No):
    Sum = 0
    
    while No > 0:
        Digit = No % 10
        Sum = Sum + Digit
        No = No // 10
        
    return Sum

value = int(input("Enter a number :"))

Ans = SumDigits(value)

print("Sum of Digits : ",Ans)