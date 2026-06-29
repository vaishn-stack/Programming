def Arithmetic(No1, No2):
    print("Addition =", No1 + No2)
    print("Subtraction =", No1 - No2)
    print("Multiplication =", No1 * No2)
    print("Division =", No1 / No2)

def main():
    value1 = int(input("Enter first number: "))
    value2 = int(input("Enter second number: "))

    Arithmetic(value1, value2)

if __name__ == "__main__":
    main()