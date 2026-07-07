import threading

counter = 0
lock = threading.Lock()

def Increment():
    global counter

    for i in range(100000):
        lock.acquire()
        counter += 1
        lock.release()

def main():

    T1 = threading.Thread(target=Increment)
    T2 = threading.Thread(target=Increment)

    T1.start()
    T2.start()

    T1.join()
    T2.join()

    print("Final Counter :", counter)

if __name__ == "__main__":
    main()