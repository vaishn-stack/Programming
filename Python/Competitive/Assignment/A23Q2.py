from multiprocessing import Pool
import os

def OddSum(No):
    sum = 0

    for i in range(1, No + 1, 2):
        sum += i

    print("Process ID :", os.getpid())
    print("Input Number :", No)
    print("Sum of Odd Numbers :", sum)
    print()

def main():

    arr = list(map(int, input("Enter numbers : ").split()))

    p = Pool()

    p.map(OddSum, arr)

    p.close()
    p.join()

if __name__ == "__main__":
    main()