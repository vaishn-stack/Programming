class Numbers:

    # Constructor
    def __init__(self, Value):
        self.Value = Value

    # Check if number is Prime
    def ChkPrime(self):
        if self.Value <= 1:
            return False

        for i in range(2, int(self.Value / 2) + 1):
            if self.Value % i == 0:
                return False

        return True

    # Check if number is Perfect
    def ChkPerfect(self):
        Sum = 0

        for i in range(1, self.Value):
            if self.Value % i == 0:
                Sum = Sum + i

        if Sum == self.Value:
            return True
        else:
            return False

    # Sum of Factors
    def Factors(self):
        Sum = 0

        for i in range(1, self.Value):
            if self.Value % i == 0:
                Sum = Sum + i

        return Sum

    # Check if number is Perfect using Factors()
    def ChkPerfectX(self):
        if self.Factors() == self.Value:
            return True
        else:
            return False


def main():

    No = int(input("Enter Number : "))

    Obj = Numbers(No)

    if Obj.ChkPrime():
        print(No, "is a Prime Number")
    else:
        print(No, "is not a Prime Number")

    if Obj.ChkPerfect():
        print(No, "is a Perfect Number")
    else:
        print(No, "is not a Perfect Number")

    print("Sum of Factors :", Obj.Factors())

    if Obj.ChkPerfectX():
        print("ChkPerfectX : Perfect Number")
    else:
        print("ChkPerfectX : Not a Perfect Number")


if __name__ == "__main__":
    main()