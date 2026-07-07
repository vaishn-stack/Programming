import threading

def chkPrime(No):
    if No < 2 :
        return False
    
    for i in range(2,No):
        if No % 2 == 0:
            return False
    return True

def Prime(arr):
    print("Prime numbers : ")
    
    for i in arr:
        if chkPrime(i):
            print(i)
            
def NonPrime(arr):
    print("Non Prime numbers : ")
    
    for i in arr:
        if not chkPrime(i):
            print(i)
            
def main():
    arr = list(map(int, input("Enter numbers : ").split()))

    T1 = threading.Thread(target=Prime, args=(arr,), name="Prime")
    T2 = threading.Thread(target=NonPrime, args=(arr,), name="NonPrime")

    T1.start()
    T2.start()

    T1.join()
    T2.join()

    print("End of main")

if __name__ == "__main__":
    main()