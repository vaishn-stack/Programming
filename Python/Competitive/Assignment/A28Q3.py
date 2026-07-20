def CountWords(filename): 
    try:
        fobj = open(filename,"r")
        
        for line in fobj:
            print(line)
            
        fobj.close()
        
    except FileNotFoundError:
        print("File not Found")
        
def main():
    FileName = input("Enter file name : ")
    CountWords(FileName)
    
if __name__ == "__main__":
    main()