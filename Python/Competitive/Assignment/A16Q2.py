def ChkNum(No):
    if No % 2 == 0:
        return "Even number"
    else:
        return "Odd number"

def main():
    value = int(input("Enter a number : "))
    
    Result = ChkNum(value)
    print(Result)
    
if __name__ == "__main__":
    main()