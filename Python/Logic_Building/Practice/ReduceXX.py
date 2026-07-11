from functools import reduce                    # functools module tyat reduce function ae

checkEven = lambda No : (No % 2 == 0)

Increment = lambda No : No + 1

Addition = lambda No1,No2 : No1 + No2

def main():
    Data = [13,12,8,10,11,20]
    
    print("Input data is : ",Data)
    
    FData = list(filter(checkEven,Data))  

    print("Data after filter : ",FData)
    
    MData = list(map(Increment,FData))          # one parameter pass in one function but not their return value will be boolean
    
    print("Data after map : ",MData)
    
    RData = reduce(Addition,MData)
    
    print("Data after reduce : ",RData)
        
if __name__ == "__main__":
    main()
    
