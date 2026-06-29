def ChkPerfect(No):
    Sum = 0

    for i in range(1, No):
        if No % i == 0:
            Sum = Sum + i

    if Sum == No:
        return True
    else:
        return False

def main():
    value = int(input("Enter a number: "))

    if ChkPerfect(value):
        print("Perfect Number")
    else:
        print("Not Perfect Number")

if __name__ == "__main__":
    main()