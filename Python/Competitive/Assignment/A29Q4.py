import sys

def CompareFile(File1, File2):
    try:
        fobj1 = open(File1,"r")
        fobj2 = open(File2,"r")
        
        Data1 = fobj1.read()
        Data2 = fobj2.read()
        
        if Data1 == Data2:
            print("Success")
        else:
            print("Failure")
            
        fobj1.close()
        fobj2.close()

    except FileNotFoundError:
        print("File not found")

def main():
    CompareFile(sys.argv[1], sys.argv[2])

if __name__ == "__main__":
    main()