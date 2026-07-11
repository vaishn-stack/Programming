import time

def SumCube(No):
    sum = 0
    
    for i in range(1,No + 1):
        sum = sum + (i ** 3)
    
    return sum
    
def main():
    Data = [10000000,20000000,30000000,40000000,50000000]
    
    Result = []
    
    start_time = time.perf_counter()
    
    for value in Data:
        Ret = SumCube(value)
        
        Result.append(Ret)
        
    end_time = time.perf_counter()
        
    print("Result is : ")
    print(Result)
        
    print(f"Time required is : {end_time - start_time : .4f} seconds")
    
if __name__ == "__main__":
    main()
    
    
    
# main [10,20,30] tyla loop lavaycha to tyachya cube chi addition krel
# sumcube madhe tya main chya 10,20,30 values la ek ek krun cube krun addition kraychi 
# result madhe tyachi cube chi value store hote