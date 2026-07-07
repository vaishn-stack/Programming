from functools import reduce

FilterX = lambda No: No % 2 == 0
MapX = lambda No: No ** 2
ReduceX = lambda A, B: A + B

def main():
    Data = []

    Size = int(input("Enter number of elements: "))

    print("Enter the elements:")
    for i in range(Size):
        Value = int(input())
        Data.append(Value)

    FData = list(filter(FilterX, Data))
    print("List after filter:", FData)

    MData = list(map(MapX, FData))
    print("List after map:", MData)

    Result = reduce(ReduceX, MData)
    print("After reduce:", Result)

if __name__ == "__main__":
    main()