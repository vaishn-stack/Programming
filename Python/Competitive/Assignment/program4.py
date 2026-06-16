Value = int(input("Enter number : "))

def CheckDivisible(No):
    if ((Value % 3 == 0) and (Value % 5 == 0)):
        print("Number is divisible by 3 & 5")
    else:
        print("Number is not divisible by 3 & 5")
        
CheckDivisible(Value)