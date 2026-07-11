#-----------------------------------------------------
#               List            Tuple
#-----------------------------------------------------
# ordered         Yes               Yes
# Indexed         Yes               YES
# Mutable         Yes               No
# Heterogeneous   Yes               Yes
#-----------------------------------------------------

def main():
    Data1 = (10,3.14,True,"Pune")           # Tuple
    Data2 = [10,3.14,True,"Pune"]           # List 
    
    print(Data1)
    print(Data2)
    
    print(Data1[0])
    print(Data2[0])        
    
if __name__ == "__main__":
    main()
    
# imp for interview 