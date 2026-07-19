# seek (kuthe jaych, kuthun jaych) 
# kuthun : 0/1/2 

# 0 --> Starting
# 1 --> Current
# 2 --> End

def main():
    try:
        fobj = open("Demo.txt","r")         
        print("File gets opened")

        fobj.seek(10,0)      # starting che 10 letters skip krel tithun pudhcha data deil
        
        Data = fobj.read()
        print(Data)
        
    except FileNotFoundError as fobj:
        print("File is not present in current directory")
        
        
if __name__ == "__main__":
    main()