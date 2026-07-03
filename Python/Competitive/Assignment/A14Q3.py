maximum = lambda No1,No2 : No1 if No1 > No2 else No2

def main():
    no1 = int(input("Enter First number : "))
    no2 = int(input("Enter Second number : "))
    
    print("Maximum number is :",maximum(no1,no2))
    
if __name__ == "__main__":
    main()