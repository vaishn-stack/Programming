Divisible = lambda No : No % 5 == 0

def main():
    no = int(input("Enter a number : "))
    print(Divisible(no))
    
if __name__ == "__main__":
    main()