# seek (kuthe jaych, kuthun jaych) 
# kuthun : 0/1/2 

# 0 --> Starting
# 1 --> Current
# 2 --> End

def main():
    try:
        fobj = open("Demo.txt","r")         
        print("File gets opened")

        Data = fobj.read(5)
        print(Data)
        
        # issue
        fobj.seek(10,0)      
        
        Data = fobj.read(5)
        print(Data)
        
    except FileNotFoundError as fobj:
        print("File is not present in current directory")
        
        
if __name__ == "__main__":
    main()