import sys

def CopyFile(File):
    try:
        fname = open(File,"r")
        fdest = open("Demo.txt", "w")
        
        for i in fname:
            fdest.write(i)
            
        print("Contents copied successfully")
        
        fname.close()
        fdest.close()
    except FileNotFoundError:
        print("File not found")

def main():
    CopyFile(sys.argv[1])

if __name__ == "__main__":
    main()