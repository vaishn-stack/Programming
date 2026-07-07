from functools import reduce

Filterx = lambda No : No >= 70 and No <=90
Mapx = lambda No : No + 10
Reducex = lambda A,B : A *B

def main():
    Data = []
    
    size = int(input("Enter number of elements :"))
    
    print("Enter the elements:")
    for i in range(size):
        Value = int(input())
        Data.append(Value)

    FData = list(filter(Filterx, Data))
    print("List after filter:", FData)

    MData = list(map(Mapx, FData))
    print("List after map:", MData)

    Result = reduce(Reducex, MData)
    print("After Reduce:", Result)

if __name__ == "__main__":
    main()
    