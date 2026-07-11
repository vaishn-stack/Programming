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