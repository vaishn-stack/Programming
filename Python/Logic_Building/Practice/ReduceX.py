from functools import reduce                    # functools module tyat reduce function ae

def checkEven(No):             
    return(No % 2 == 0)

def Increment(No):
    return No + 1

def Addition(No1,No2):
    return No1 + No2

def main():
    Data = [13,12,8,10,11,20]
    
    print("Input data is : ",Data)
    
    FData = list(filter(checkEven,Data))  

    print("Data after filter : ",FData)
    
    MData = list(map(Increment,FData))
    
    print("Data after map : ",MData)
    
    RData = reduce(Addition,MData)
    
    print("Data after reduce : ",RData)
        
if __name__ == "__main__":
    main()
    
