def Frequency(FileName, Word):
    try:
        fobj = open(FileName, "r")
        
        Data = fobj.read()
        
        count = Data.count(Word)
        
        print("Frequency of", Word, "is", count)
        
        fobj.close()
    
    except FileExistsError:
        print("File not found")
        
def main():
    FileName = input("Enter file name : ")
    Word = input("Enter word : ")

    Frequency(FileName, Word)

if __name__ == "__main__":
    main()