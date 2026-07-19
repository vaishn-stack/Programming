import os

def main():
    for FolderName, SubFolder, Filename in os.walk("Marvellous"):
        print("Folder Name : ", FolderName)
        
        for subf in SubFolder:
            print("Sub Folder Name :", subf)
        
    
if __name__ == "__main__":
    main()