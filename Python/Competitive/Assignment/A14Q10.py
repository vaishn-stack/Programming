Largest = lambda No1,No2,No3 : No1 if (No1 >= No2 and No1 >= No2) else (No2 if No2 >= No3 else No3)

def main():
    no1 = int(input("Enter First number : "))
    no2 = int(input("Enter second number : "))
    no3 = int(input("Enter third number : "))
    
    print("Largest nymber is :", Largest(no1, no2, no3))
    
if __name__ == "__main__":
    main()