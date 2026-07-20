def WordFile(FileName,Word):
    try:
        fobj = open(FileName,"r")
        
        Data = fobj.read()
        
        if Word in Data:
            print("Word is present in the file")
        else:
            print("Word is not present in the file")
    
        fobj.close()
    except FileNotFoundError:
        print("File not found")
        
def main():
    FileName = input("Enter file name : ")
    Word = input("Enter word to search : ")
    
    WordFile(FileName, Word)
    
if __name__ == "__main__":
    main()