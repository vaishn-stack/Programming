from multiprocessing import Pool
import os

def EvenSum(No):
    sum = 0

    for i in range(2, No + 1, 2):
        sum += i

    print("Process ID :", os.getpid())
    print("Input Number :", No)
    print("Sum of Even Numbers :", sum)
    print()

def main():

    arr = list(map(int, input("Enter numbers : ").split()))

    p = Pool()

    p.map(EvenSum, arr)

    p.close()
    p.join()

if __name__ == "__main__":
    main()