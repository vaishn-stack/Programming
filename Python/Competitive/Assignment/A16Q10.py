def Name(s):
    return len(s)

def main():
    Value = input("Enter your name: ")
    Result = Name(Value)
    print("Length of Name is : ",Result)

if __name__ == "__main__":
    main()