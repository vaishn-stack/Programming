# Multithreaded - 3 thread ae
import time
import threading

# 2+4+6+8 = 20
def SumEven(No):                            # thread creation
    Sum = 0
    
    for i in range(2,No,2):
        Sum = Sum + i
        
    print("Summation of Even : ",Sum)
    
# 1+3+5+7+9 = 25
def SumOdd(No):                              # thread creation
    Sum = 0
    
    for i in range(1,No,2):
        Sum = Sum + i
        
    print("Summation of Odd : ",Sum)
    
def main():
    start_time = time.perf_counter()

    t1 = threading.Thread(target=SumEven, args=(100000000,))    
    t2 = threading.Thread(target=SumOdd, args=(100000000,))    
        
    # thread ready to state la gela
    t1.start()
    t2.start()
    
    # thread run zalyavr waiting state pryant jaun thambla
    t1.join()
    t2.join()
    
    end_time = time.perf_counter()
    
    print(f"Time requrired is : {end_time - start_time : .4f}")
  
    
if __name__ == "__main__":
    main()
    
# GIL - Global interpreter log