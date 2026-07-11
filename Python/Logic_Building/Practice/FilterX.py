def checkEven(No):              # data type boolean asel teva fakt ekch parameter pass kraycha
    return(No % 2 == 0)

def main():
    Data = [13,12,8,10,11,20]
    
    print("Input data is : ",Data)
    
    FData = list(filter(checkEven,Data))  

    print("Data after filter : ",FData)
        
if __name__ == "__main__":
    main()
    
# filter -> parameter(function,Iterable) return value --> Iterable __
# map -> parameter(function,Iterable) return value --> Iterable <____|
# reduce -> parameter(function,Iterable) return value --> single value --> output

# FData = list(filter(checkEven,Data)) --> CheckEven() as lihaych nhi as kel tr function cha call hoto