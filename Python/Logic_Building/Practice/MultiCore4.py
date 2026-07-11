import multiprocessing
import os
import time

def SumCube(No):
    print("Process is Running with PID : ",os.getpid())
    
    sum = 0
    
    for i in range(1,No + 1):
        sum = sum + (i ** 3)
    
    return sum
    
def main():
    Data = [10000000,20000000,30000000,40000000,50000000]
    
    Result = []
    
    start_time = time.perf_counter()
    
    pobj = multiprocessing.Pool()
    
    Result = pobj.map(SumCube,Data)
    
    pobj.close()
    pobj.join()
        
    end_time = time.perf_counter()
        
    print("Result is : ")
    print(Result)
        
    print(f"Time required is : {end_time - start_time : .4f} seconds")
    
if __name__ == "__main__":
    main()
    
# Load Balancing - 
# Elastic Computing is a core part of os eg - rubber odun tutne (capacity of rubber) same concept of microprocessor 
# AI cha extreme and advanced part ae elastic computing

# Pool navacha class ae , pool cha arth as a taki asa hoto
# join sagle kam hot nhi to pryant thamba
# map navachi method hi Pool class madhun ali ae 
# map ha similar ae FMR madhlya map() sarkh kam krto