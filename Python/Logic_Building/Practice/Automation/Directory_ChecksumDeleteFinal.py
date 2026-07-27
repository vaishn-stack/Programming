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
    
    Duplicate = {}
    
    for FolderName, SubFolder, FileName in os.walk(DirectoryName):
        for fname in FileName:
            fname = os.path.join(FolderName,fname)
            
            Checksum = CalculateCheckSum(fname)
            
            if Checksum in Duplicate:
                Duplicate[Checksum].append(fname)
            else:
                Duplicate[Checksum] = [fname]
    
    return Duplicate
    
def DeleteDuplicate(DirectoryName):
    MyDict = FindDuplicate(DirectoryName)
    
    # Result = MyDict.values()
    
    Result = list(filter(lambda x : len(x) > 1, MyDict.values()))          # lambda function
    
    count = 0
    TotalDeleted = 0
    
    for value in Result:
        for subvalue in value:
            count = count + 1
            if(count > 1):
                os.remove(subvalue)
                TotalDeleted = TotalDeleted + 1
        count = 0
    
    print("Total Deleted files : ",TotalDeleted)
    
def main():
    DeleteDuplicate("Test")
    
if __name__ == "__main__":
    main()
  
# Directory use for traversal 
# dict is used to store data
# Duplicate{} - create empty set and dictionary
# try to learn github code and open source contributor
# add command line, 
# scheduler 2 min, , 
# periodically timestamp, 
# totalfiles scanned, duplicate files found, 
# list of duplicate files found, 
# deleted files --h amd --u