# without In-Built function

def Binary(No):
    BinaryNo = " "
    
    while No > 0:
        BinaryNo =  str(No % 2) + BinaryNo
        No = No // 2
        
    print(BinaryNo)
    
def main():
    value = int(input("Enter a number : "))
    
    Binary(value)
    
if __name__ == "__main__":
    main()