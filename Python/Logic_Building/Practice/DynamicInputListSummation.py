def Summation(Data):
    sum = 0
    
    for no in Data:
        sum = sum + no
        
    return sum
    
def main():
   size = 0
   Arr = list()
   
   print("Enter the number of elements : ")
   size = int(input())
   
   print("Enter the elements : ")
   
   for i in range(size):
       no = int(input())
       Arr.append(no)               # add the value
       
   Ret = Summation(Arr)
   
   print("Summation is : ",Ret)
    
if __name__ == "__main__":
    main()