def Add(No1,No2):
    return No1 + No2 

def main():
    value1 = int(input("Enter first number : "))
    value2 = int(input("Enter second number : "))
    
    Result = Add(value1, value2)
    print(Result)
    
if __name__ == "__main__":
    main()