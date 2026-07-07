def Display(No):
    count = 0
    
    for i in range(No, 0, -1):
        for j in range(i):
            print("*",end = " ")
            
        print()
            
    if count == 2:
        return True
    else:
        return False

def main():
    Value = int(input("Enter a number: "))
    Display(Value)

if __name__ == "__main__":
    main()