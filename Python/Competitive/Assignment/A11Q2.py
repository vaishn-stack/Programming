def CountDigits(No):
    count = 0
    
    while No > 0:
        count = count + 1
        No = No // 10
        
    return count

value = int(input("Enter a number :"))

Ans = CountDigits(value)

print("Count of Digits : ",Ans)