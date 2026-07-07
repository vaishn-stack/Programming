import threading

def EvenFactors(No):
    sum = 0
    
    print("Even factors : ")
    for i in range(1,No + 1):
        if No % i == 0 and i % 2 == 0:
            print(i)
            sum = sum + i
            
    print("Sum of Even factors is : ",sum)
    
def OddFactors(No):
    sum = 0
    
    print("Odd factors : ")
    for i in range(1,No + 1):
        if No % i == 0 and i % 2 != 0:
            print(i)
            sum = sum + i
            
    print("Sum of Odd factors is : ",sum)
    
def main():
    Value = int(input("Enter a number: "))
    
    T1 = threading.Thread(target=EvenFactors)
    T2 = threading.Thread(target=OddFactors)
    
    T1.start()
    T2.start()
    
    T1.join()
    T2.join()
    
    print("End of main")
    
if __name__ == "__main__":
    main()