from functools import reduce

Addition = lambda No1,No2 : No1 + No2

def main():
    no = [10,15,20,25,30,35,40,45,50]
    
    result = reduce(Addition,no)
    
    print("Addition is : ",result)
    
if __name__ == "__main__":
    main()