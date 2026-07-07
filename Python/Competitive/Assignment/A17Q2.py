def Display(No):
    for i in range(No):
        for j in range(No):
            print(" * ", end = " ")
        print()
        
def main():
    Value = int(input("Enter a number: "))
    Display(Value)

if __name__ == "__main__":
    main()