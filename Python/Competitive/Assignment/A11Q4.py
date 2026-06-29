def Reverse(No):
    Rev = 0
    
    while No > 0:
        Digit = No % 10
        Rev = Rev * 10 + Digit
        No = No // 10
        
    return Rev

value = int(input("Enter a number : "))

Ans = Reverse(value)

print("Reverse is : ",Ans)