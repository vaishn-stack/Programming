import os
import time
import multiprocessing

# 2+4+6+8 = 20
def SumEven(No):            
    print(f"PID of SumEven : {os.getpid()} PPID of SumEven : {os.getppid()}")    
                
    Sum = 0
    
    for i in range(2,No,2):
        Sum = Sum + i
        
    print("Summation of Even : ",Sum)
    
# 1+3+5+7+9 = 25
def SumOdd(No):       
    print(f"PID of SumOdd : {os.getpid()} PPID of SumOdd : {os.getppid()}")        
                      
    Sum = 0
    
    for i in range(1,No,2):
        Sum = Sum + i
        
    print("Summation of Odd : ",Sum)
    
def main():
    print(f"PID of main : {os.getpid()} PPID of main : {os.getppid()}")    
    
    start_time = time.perf_counter()

    t1 = multiprocessing.Process(target=SumEven, args=(100,))    
    t2 = multiprocessing.Process(target=SumOdd, args=(100,))    
    
    t1.start()
    t2.start()

    t1.join()
    t2.join()
    
    end_time = time.perf_counter()
    
    print(f"Time requrired is : {end_time - start_time : .4f}")
  
    
if __name__ == "__main__":
    main()
    
# GIL - Global interpreter log

#PID of main : 23188 PPID of main : 8416
#PID of SumEven : 20424 PPID of SumEven : 23188
#Summation of Even :  2450
#PID of SumOdd : 14560 PPID of SumOdd : 23188
#Summation of Odd :  2500
#Time requrired is :  0.2325

# main cha pid ani sumeven and sumodd cha ppid same ae tyla sibling process mhntat.