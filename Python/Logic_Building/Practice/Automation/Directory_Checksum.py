import sys
import os
import hashlib

def CalculateCheckSum(FileName):
    fobj = open(FileName,"rb")
    
    hobj = hashlib.md5()
    
    Buffer = fobj.read(1024)
    
    while(len(Buffer) > 0):
        hobj.update(Buffer)
        Buffer = fobj.read(1024)
        
    fobj.close()
    
    return hobj.hexdigest()

def FindDuplicate(DirectoryName):
    Ret = False
    
    Ret = os.path.exists(DirectoryName)
    
    if Ret == False:
        print("Path is Invalid")
        return
    
    Ret = os.path.isdir(DirectoryName)
    
    if Ret == False:
        print("It is not a Directory")
        return
    
    for FolderName, SubFolder, FileName in os.walk(DirectoryName):
        for fname in FileName:
            fname = os.path.join(FolderName,fname)
            
            Checksum = CalculateCheckSum(fname)
            print(f"{fname} : {Checksum}")
    
def main():
    FindDuplicate("Test")
    
if __name__ == "__main__":
    main()
