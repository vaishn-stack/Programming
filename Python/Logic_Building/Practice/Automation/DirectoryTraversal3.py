import os

def main():
    for FolderName, SubFolder, FileName in os.walk("Marvellous"):
        print("Folder Name : ", FolderName)
        
        for subf in SubFolder:
            print("Sub Folder Name :", subf)
        
        for fname in FileName:
            print("File name :", fname)
            
if __name__ == "__main__":
    main()