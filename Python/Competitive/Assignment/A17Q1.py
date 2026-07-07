import Arithmetic

def main():
    No1 = int(input("Enter first number: "))
    No2 = int(input("Enter second number: "))

    print("Addition =", Arithmetic.Add(No1, No2))
    print("Subtraction =", Arithmetic.Sub(No1, No2))
    print("Multiplication =", Arithmetic.Mult(No1, No2))
    print("Division =", Arithmetic.Div(No1, No2))

if __name__ == "__main__":
    main()