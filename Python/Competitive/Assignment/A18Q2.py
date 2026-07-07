def Maximum(Data):
    Max = Data[0]

    for i in Data:
        if i > Max:
            Max = i

    return Max

def main():
    Size = int(input("Enter number of elements: "))

    Arr = []

    print("Enter the elements:")
    for i in range(Size):
        Value = int(input())
        Arr.append(Value)

    Result = Maximum(Arr)
    print("Maximum number is:", Result)

if __name__ == "__main__":
    main()