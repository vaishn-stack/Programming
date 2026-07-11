# user defined FMR

checkEven = lambda No : (No % 2 == 0)
Increment = lambda No : No + 1
Addition = lambda No1,No2 : No1 + No2

def filterX(Task, Elements):                # task --> chkeven, Data --> elements
    Result = []
    
    for no in Elements:
        Ret = Task(no)                      # chkeven(no) --> append kr true or false asel tr
        if(Ret == True):
            Result.append(no)
            
    return Result

def mapX(Task,Elements):                    # task --> increment, FData --> elements
    Result = []
    
    for no in Elements:
        Ret = Task(no)
        Result.append(Ret)
        
    return Result

def reduceX(Task,Elements):                  # task --> Addition, MData --> elements
    Sum = 0
     
    for no in Elements:
        Sum = Task(Sum,no)
    
    return Sum    

def main():
    Data = [13,12,8,10,11,20]
    
    print("Input data is : ",Data)
    
    FData = list(filterX(checkEven,Data))  

    print("Data after filter : ",FData)
    
    MData = list(mapX(Increment,FData))          
    
    print("Data after map : ",MData)
    
    RData = reduceX(Addition,MData)
    
    print("Data after reduce : ",RData)
        
if __name__ == "__main__":
    main()
    
