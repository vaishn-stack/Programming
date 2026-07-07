def CountDigits(No):
    Count = 0

    while No > 0:
        Count = Count + 1
        No = No // 10

    return Count

def main():
    Value = int(input("Enter a number: "))
    Result = CountDigits(Value)
    print("Number of digits =", Result)

if __name__ == "__main__":
    main()