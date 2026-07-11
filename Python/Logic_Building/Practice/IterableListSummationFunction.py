def Summation(Data):
    sum = 0
    
    for no in Data:
        sum = sum + no
        
    return sum

def main():
    Marks = [78,90,56,98,77]
    
    Ret = Summation(Marks)
       
    print("Addition is :",Ret)

if __name__ == "__main__":
    main()