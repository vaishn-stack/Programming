def DisplayFile(FileName):
    try:
        fobj = open(FileName, "r")
        
        Data = fobj.read()
        print(Data)
        
        fobj.close()
        
    except FileNotFoundError:
        print("File not found")
        
def main():
    FileName = input("Enter File name : ")
    DisplayFile(FileName)
    
if __name__ == "__main__":
    main()