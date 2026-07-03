from functools import reduce

Even = lambda No : No % 2 == 0

def main():
    no = [2,3,4,5,6]
    
    result = list(filter(Even,no))
    
    print("Count of Even numbers : ",result)
    
if __name__ == "__main__":
    main()