import threading

def Maximum(arr):
    print("Maximum :", max(arr))

def Minimum(arr):
    print("Minimum :", min(arr))

def main():
    arr = list(map(int, input("Enter numbers : ").split()))

    T1 = threading.Thread(target=Maximum, args=(arr,))
    T2 = threading.Thread(target=Minimum, args=(arr,))

    T1.start()
    T2.start()

    T1.join()
    T2.join()

    print("End of main")

if __name__ == "__main__":
    main()