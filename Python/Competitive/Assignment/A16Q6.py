# check number positive , negative, Zero

def ChkNum(No):
    if No > 0:
        return "Positive number"
    elif No < 0:
        return "Negative number"
    else:
        return "Zero"
    
def main():
    Value = int(input("Enter a number: "))
    Result = ChkNum(Value)
    print(Result)
    
if __name__ == "__main__":
    main()