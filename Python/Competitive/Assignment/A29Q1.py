import os

def CheckFile(FileName):
    if os.path.exists(FileName):
        print("File exists")
    else:
        print("File is not exists")
        
        
def main():
    FileName = input("Enter File name : ")
    CheckFile(FileName)
    
if __name__ == "__main__":
    main()