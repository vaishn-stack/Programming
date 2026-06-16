class NumberX:
    @staticmethod
    def CheckDivisible(No):
        return(No % 3 == 0) and (No % 5 == 0)
    
Value = int(input("Enter Number : "))

if NumberX.CheckDivisible(Value):
    print("Number is divisible by 3 & 5")
else:
    print("Number is not divisible by 3 & 5")