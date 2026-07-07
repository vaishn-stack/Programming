def ChkPrime(No):
    Count = 0

    for i in range(1, No + 1):
        if No % i == 0:
            Count = Count + 1

    if Count == 2:
        return True
    else:
        return False