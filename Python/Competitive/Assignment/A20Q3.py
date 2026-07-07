import threading

def EvenList(Data):
    sum = 0
    
    print("Even elements are : ")
    for i in Data:
        if i % 2 == 0:
            print(i)
            sum = sum + i
            
    print("Sum of Even elements is : ",sum)
    
def OddList(Data):
    sum = 0
    
    print("Odd elemnets are : ")
    for i in Data:
        if i % 2 != 0:
            print(i)
            sum = sum + i
            
    print("Sum of Odd elements is : ",sum)
    
def main():
    Value = int(input("Enter a number of elements : "))
    
    T1 = threading.Thread(target=EvenList)
    T2 = threading.Thread(target=OddList)
    
    T1.start()
    T2.start()
    
    T1.join()
    T2.join()
    
    print("End of main")
    
if __name__ == "__main__":
    main()