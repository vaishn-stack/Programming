from multiprocessing import Pool
import os

def Factorial(No):
    fact = 1
    
    for i in range(1,No + 1):
        fact *= i
        
    print("Process ID :", os.getpid())
    print("Input :", No)
    print("Factorial :", fact)

def main():
    arr = list(map(int, input("Enter numbers : ").split()))
    
    p = Pool()
    
    p.map(Factorial, arr)
    
    p.close()
    p.join()
    
if __name__ == "__main__":
    main() 