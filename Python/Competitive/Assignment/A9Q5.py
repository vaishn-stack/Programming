def ChkDivisible(No):
    if((No % 3 == 0) and (No % 5 == 0)):
        print("Number is divisible by 3 & 5.")
    else:
        print("Number is not divisible by 3 & 5.")
        
value = int(input("Enter the number : "))

ChkDivisible(value)