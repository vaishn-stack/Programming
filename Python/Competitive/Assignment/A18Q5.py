import MarvellousNum

def ListPrime(Data):
    Sum = 0

    for i in Data:
        if MarvellousNum.ChkPrime(i):
            Sum = Sum + i

    return Sum

def main():
    Size = int(input("Enter number of elements: "))

    Arr = []

    print("Enter the elements:")
    for i in range(Size):
        Value = int(input())
        Arr.append(Value)

    Result = ListPrime(Arr)
    print("Addition of prime numbers is:", Result)

if __name__ == "__main__":
    main()