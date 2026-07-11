#-----------------------------------------------------
#               List            Tuple
#-----------------------------------------------------
# ordered         Yes               Yes
# Indexed         Yes               YES
# Mutable         Yes               No
#-----------------------------------------------------

def main():
    Data1 = (10,20,30,40)        # (const)immutable Tuple
    Data2 = [10,20,30,40]        #List mutable
    
    print(Data1)
    print(Data2)
    
    print(Data1[0])
    print(Data2[0])        
    
if __name__ == "__main__":
    main()
    
# imp for interview 