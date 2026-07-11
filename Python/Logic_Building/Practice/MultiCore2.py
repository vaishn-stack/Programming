def SumCube(No):
    sum = 0
    
    for i in range(1,No + 1):
        sum = sum + (i ** 3)
    
    return sum
    
def main():
    Ret = SumCube(5)
    
    print("Result is : ",Ret)
    
if __name__ == "__main__":
    main()