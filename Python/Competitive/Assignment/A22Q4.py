from multiprocessing import Pool
import time

def SumPower(No):

    sum = 0

    for i in range(1, No + 1):
        sum += i ** 5

    return sum

def main():

    arr = list(map(int, input("Enter numbers : ").split()))

    start = time.time()

    p = Pool()

    result = p.map(SumPower, arr)

    p.close()
    p.join()

    end = time.time()

    print(result)
    print("Execution Time :", end - start)

if __name__ == "__main__":
    main()