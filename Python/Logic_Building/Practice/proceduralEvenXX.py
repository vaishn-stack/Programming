def CheckEven(No):
    return (No % 2 == 0)
        
def main():
    value = int(input("Enter number : "))
    
    Ret = CheckEven(value)

    if(Ret == True):
        print("Number is Even")
    else:
        print("Number is odd")
    
    
if __name__ == "__main__":
    main()
    
# checkEven = lambda No : No % 2 == 0
#       return True
# Ret = checkEven(No)