def Minimum(Data):
    Max = Data[0]

    for i in Data:
        if i < Min:
            Min = i

    return Min

def main():
    Size = int(input("Enter number of elements: "))

    Arr = []

    print("Enter the elements:")
    for i in range(Size):
        Value = int(input())
        Arr.append(Value)

    Result = Minimum(Arr)
    print("Minimum number is:", Result)

if __name__ == "__main__":
    main()