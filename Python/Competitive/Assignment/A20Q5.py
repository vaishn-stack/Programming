import threading

def Display():
    print("Thread1")
    for i in range(1, 51):
        print(i)
        
def Reverse():
    print("Thread2")
    for i in range(50, 0, -1):
        print(i)
        
def main():
    T1 = threading.Thread(target=Display, name="Thread1")
    T2 = threading.Thread(target=Reverse, name="Thread2")
    
    T1.start()
    T1.join()
    
    T2.start()
    T2.join()
    
    print("End of main")


if __name__ == "__main__":
    main()