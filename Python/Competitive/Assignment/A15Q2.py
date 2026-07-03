Even = lambda No : No % 2 == 0

def main():
    no = [10,15,20,25,30,35,40,45,50]
    
    result = list(filter(Even,no))
    
    print("Even numbers are : ",result)
    
if __name__ == "__main__":
    main()