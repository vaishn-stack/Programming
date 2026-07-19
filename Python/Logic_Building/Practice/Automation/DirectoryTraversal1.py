import os

def main():
    for FolderName, SubFolder, Filename in os.walk("Marvellous"):
        print(FolderName)
    
if __name__ == "__main__":
    main()