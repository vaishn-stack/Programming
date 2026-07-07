def Prime(No):
    count = 0
    
    for i in range(1, No + 1):
        if No % i == 0:
            count = count + 1
            
    if count == 2:
        return True
    else:
        return False

def main():
    Value = int(input("Enter a number: "))

    if Prime(Value):
        print("It is Prime Number")
    else:
        print("It is Not Prime Number")

if __name__ == "__main__":
    main()