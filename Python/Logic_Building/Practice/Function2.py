def Addition(No1, No2):
    Ans = No1 + No2
    return Ans

def main():
    print("Enter First number : ")
    Value1 = int(input())                   # Local variable - jo varialbe function chya aat ae 
    
    print("Enter Second number : ")
    Value2 = int(input())
    
    Ret = Addition(Value1, Value2)
    
    print("Addition is : ",Ret)
    
if __name__ == "__main__":                  # Starter
    main()
    