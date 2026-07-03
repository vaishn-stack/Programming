Divisible = lambda No: No % 3 == 0 and No % 5 == 0

def main():
    no = [10, 15, 18, 30, 45, 50, 60]

    result = list(filter(Divisible, no))

    print("Original List :", no)
    print("Numbers divisible by both 3 and 5 :", result)

if __name__ == "__main__":
    main()