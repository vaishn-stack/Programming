minimum = lambda No1,No2 : No1 if No1 < No2 else No2

def main():
    no1 = int(input("Enter First number : "))
    no2 = int(input("Enter Second number : "))
    
    print("Minimum number is :",minimum(no1,no2))
    
if __name__ == "__main__":
    main()