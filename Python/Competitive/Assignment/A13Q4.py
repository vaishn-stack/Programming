# using In-Built function

def Binary(No):
    print(bin(No)[2:])
    
def main():
    value = int(input("Enter a number : "))
    
    Binary(value)
    
if __name__ == "__main__":
    main()