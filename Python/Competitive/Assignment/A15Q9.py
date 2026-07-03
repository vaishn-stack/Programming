from functools import reduce

List = lambda No1,No2 : No1 * No2

def main():
    no = [2,3,4,5,6]
    
    result = reduce(List,no)
    
    print("Product of all elements : ",result)
    
if __name__ == "__main__":
    main()