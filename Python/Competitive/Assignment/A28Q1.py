def CountLines(filename): 
    try:
        fobj = open(filename,"r")
        
        count = 0
        
        for line in fobj:
            count = count + 1
            
        print("Total number of lines :", count)
        fobj.close()
        
    except FileNotFoundError:
        print("File not Found")
        
def main():
    FileName = input("Enter file name : ")
    CountLines(FileName)
    
if __name__ == "__main__":
    main()