Square = lambda No : No * No

def main():
    no = [1,2,3,4,5]
    
    print("Original List : ",no)
    
    result = list(map(Square,no))
    
    print("Square of List : ",result)
    
if __name__ == "__main__":
    main()