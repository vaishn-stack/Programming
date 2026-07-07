import threading

def Small(str):
    print("Thread ID : ",threading.get_ident())
    print("Thread Name : ",threading.current_thread().name)
    
    count = 0
    for ch in str:
        if ch.islower():
            count += 1
            
    print("Lowercase letters : ",count)
    
def Capital(str):
    print("Thread ID : ",threading.get_ident())
    print("Thread Name : ",threading.current_thread().name)
    
    count = 0
    for ch in str:
        if ch.isupper():
            count += 1
            
    print("Uppercase letters : ",count)
    
def Digits(str):
    print("Thread ID : ",threading.get_ident())
    print("Thread Name : ",threading.current_thread().name)
    
    count = 0
    for ch in str:
        if ch.isdigit():
            count += 1
            
    print("Digits : ",count)
    
def main():
    value = input("Enter a string : ")
    
    T1 = threading.Thread(target=Small, args=(value,), name = "Small")
    T2 = threading.Thread(target=Capital, args=(value,), name = "Capital")
    T3 = threading.Thread(target=Digits, args=(value,), name = "Digits")
    
    T1.start()
    T2.start()
    T3.start()

    T1.join()
    T2.join()
    T3.join()

    print("End of main")


if __name__ == "__main__":
    main()