def Frequency(Data, No):
    Count = 0

    for i in Data:
        if i == No:
            Count = Count + 1

    return Count

def main():
    Size = int(input("Enter number of elements: "))

    Arr = []

    print("Enter the elements:")
    for i in range(Size):
        Value = int(input())
        Arr.append(Value)

    Search = int(input("Enter element to search: "))

    Result = Frequency(Arr, Search)
    print("Frequency is:", Result)

if __name__ == "__main__":
    main()