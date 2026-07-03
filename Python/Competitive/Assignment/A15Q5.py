from functools import reduce

Maximum = lambda No1,No2 : No1 if No1 > No2 else No2 

def main():
    no = [10,15,20,25,30,35,40,45,50]
    
    result = reduce(Maximum,no)
    
    print("Maximum is : ",result)
    
if __name__ == "__main__":
    main()