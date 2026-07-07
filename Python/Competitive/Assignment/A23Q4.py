from multiprocessing import Pool
import os

def OddCount(No):

    count = 0

    for i in range(1, No + 1):
        if i % 2 != 0:
            count += 1

    print("Process ID :", os.getpid())
    print("Input Number :", No)
    print("Odd Number Count :", count)
    print()

def main():

    arr = list(map(int, input("Enter numbers : ").split()))

    p = Pool()

    p.map(OddCount, arr)

    p.close()
    p.join()

if __name__ == "__main__":
    main()