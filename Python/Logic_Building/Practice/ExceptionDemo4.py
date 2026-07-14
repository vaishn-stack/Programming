def main():
    Ans = 0
    
    try:
        print("Enter first number :")
        No1 = int(input())
        
        print("Enter second number :")
        No2 = int(input())
        
        Ans = No1 / No2
        
        print("Division is successful")
        
    except ZeroDivisionError as zobj:       # as - alias / zobj = object specific except block
        print("Exception occurred due to second operand is Zero : ",zobj)
        
    except ValueError as vobj:                          # specific except block
        print("Exception occurred due to invalid data type : ",vobj)
        
    except Exception as eobj:                           # Generic Except block -> in-built exception
        print("Exception occurred : ",eobj)
       
    print("Result is : ",Ans)
      
if __name__ == "__main__":
    main()