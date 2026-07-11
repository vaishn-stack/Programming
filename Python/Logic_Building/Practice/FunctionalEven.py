# hybrid Application
CheckEven = lambda No : (No % 2 == 0)       # Functional
        
def main():                                 # procedural
    value = int(input("Enter number : "))
    
    Ret = CheckEven(value)      # Ret = (value % 2 == 0)

    if(Ret == True):
        print("Number is Even")
    else:
        print("Number is odd")
    
    
if __name__ == "__main__":
    main()
    
