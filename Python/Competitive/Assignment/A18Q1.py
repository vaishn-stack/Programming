def ListSum(Data):
    sum = 0
    
    for i in Data:
        sum = sum + i
        
    return sum

def main():
    size = int(input("Enter number of elements :"))
    
    Arr = []
    
    print("Enter the elements : ")
    for i in range(size):
        value = int(input())
        Arr.append(value)
        
    Ret = ListSum(Arr)
    print("Addition is : ",Ret)
    
if __name__ == "__main__":
    main()