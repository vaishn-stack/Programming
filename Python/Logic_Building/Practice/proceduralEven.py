def CheckEven(No):
    if(No % 2 == 0):
        print("Number is Even")
    else:
        print("Number is odd")
        
def main():
    value = int(input("Enter number : "))
    
    CheckEven(value)
    
if __name__ == "__main__":
    main()