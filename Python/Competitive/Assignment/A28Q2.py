def CountWords(filename): 
    try:
        fobj = open(filename,"r")
        
        count = 0
        
        for line in fobj:
            Words = line.split()
            count = count + len(Words)
            
        print("Total number of words :", count)
        fobj.close()
        
    except FileNotFoundError:
        print("File not Found")
        
def main():
    FileName = input("Enter file name : ")
    CountWords(FileName)
    
if __name__ == "__main__":
    main()