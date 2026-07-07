import threading

Sum = 0
Product = 1

def Addition(arr):
    global Sum

    for i in arr:
        Sum += i

def Multiplication(arr):
    global Product

    for i in arr:
        Product *= i

def main():

    global Sum, Product

    arr = list(map(int, input("Enter numbers : ").split()))

    T1 = threading.Thread(target=Addition, args=(arr,))
    T2 = threading.Thread(target=Multiplication, args=(arr,))

    T1.start()
    T2.start()

    T1.join()
    T2.join()

    print("Sum :", Sum)
    print("Product :", Product)

if __name__ == "__main__":
    main()