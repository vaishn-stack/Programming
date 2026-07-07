from multiprocessing import Pool

def SumSquare(No):
    sum = 0
    
    for i in range(1,No + 1):
        sum += i * i
        
    return sum

def main():
    arr = list(map(int, input("Enter numbers : ").split()))
    
    p = Pool()
    
    result = p.map(SumSquare, arr)
    
    p.close()
    p.join()
    
    print(result)
    
if __name__ == "__main__":
    main()