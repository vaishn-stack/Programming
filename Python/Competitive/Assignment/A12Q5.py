def DisplayReverse(No):
    for i in range(No, 0, -1):
        print(i, end=" ")

def main():
    value = int(input("Enter a number: "))

    DisplayReverse(value)

if __name__ == "__main__":
    main()