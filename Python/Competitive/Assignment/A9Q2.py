def ChkGreater(No1,No2):
    if No1 > No2:
        print(No1,"is a greater number")
    elif(No2 > No1):
        print(No2,"is a greater number")
    else:
        print("Both numbers are equal")
        
def main():
    value1 = int(input("Enter the First number : "))
    value2 = int(input("Enter the First number : "))
    
    ChkGreater(value1,value2)
    
if __name__ == "__main__":
    main()