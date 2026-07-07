from multiprocessing import Pool

def CountPrime(No):

    count = 0

    for i in range(2, No + 1):

        prime = True

        for j in range(2, i):
            if i % j == 0:
                prime = False
                break

        if prime:
            count += 1

    return count

def main():

    arr = list(map(int, input("Enter numbers : ").split()))

    p = Pool()

    result = p.map(CountPrime, arr)

    p.close()
    p.join()

    print(result)

if __name__ == "__main__":
    main()