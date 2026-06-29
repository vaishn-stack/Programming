def ChkPrime(No):
    if No <= 1:
        return False
    
    for i in range(2,No):
        if No % i == 0:
            return False
        
    return True

value = int(input("Enter a number : "))

if ChkPrime(value):
    print("Prime number")
else:
    print("Not prime number")