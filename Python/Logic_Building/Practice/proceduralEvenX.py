def CheckEven(No):
    if(No % 2 == 0):
        return True
    else:
        return False
        
def main():
    value = int(input("Enter number : "))
    
    Ret = CheckEven(value)

    if(Ret == True):
        print("Number is Even")
    else:
        print("Number is odd")
    
    
if __name__ == "__main__":
    main()