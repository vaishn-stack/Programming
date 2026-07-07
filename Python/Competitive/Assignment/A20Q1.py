import threading

def Even():
    print("First 10 Even numbers : ")
    for i in range(2,21,2):
        print(i)
        
    print()
    
def Odd():
    print("First 10 Odd numbers : ")
    for i in range(1,20,2):
        print(i)
        
    print()
    
def main():
    T1 = threading.Thread(target=Even)
    T2 = threading.Thread(target=Odd)
    
    T1.start()
    T2.start()
    
    T1.join()
    T2.join()
    
    print("End of main")
    
if __name__ == "__main__":
    main()