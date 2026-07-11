import Marvellous as MI              # as means reference (Topan nav)

def main():
    print("Enter First number : ")
    Value1 = int(input())                   
    
    print("Enter Second number : ")
    Value2 = int(input())
    
    Ret = MI.Addition(Value1, Value2)          
    
    print("Addition is : ",Ret)
    
if __name__ == "__main__":                  
    main()
    